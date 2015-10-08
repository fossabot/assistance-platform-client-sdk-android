package de.tudarmstadt.informatik.tk.android.kraken.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GcmNetworkManager;

import java.io.Serializable;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.kraken.ActivityCommunicator;
import de.tudarmstadt.informatik.tk.android.kraken.PreferenceManager;
import de.tudarmstadt.informatik.tk.android.kraken.R;
import de.tudarmstadt.informatik.tk.android.kraken.SensorManager;
import de.tudarmstadt.informatik.tk.android.kraken.Settings;
import de.tudarmstadt.informatik.tk.android.kraken.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleInstallation;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleInstallationDao;
import de.tudarmstadt.informatik.tk.android.kraken.model.enums.ECommandType;
import de.tudarmstadt.informatik.tk.android.kraken.model.sensor.ISensor;
import de.tudarmstadt.informatik.tk.android.kraken.provider.DbProvider;

/**
 * @edited by Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 08.10.2015
 */
public class HarvesterService extends Service implements Callback {

    private static final String TAG = HarvesterService.class.getSimpleName();

    private static HarvesterService INSTANCE;

    private final Messenger messenger = new Messenger(new Handler(this));

    // task identifier
    private long taskID = 999;
    // the task should be executed every 30 seconds
    private long periodSecs = 5L;
    // the task can run as early as -15 seconds from the scheduled time
    private long flexSecs = 1L;
    // an unique task identifier
    private String taskTag = "periodic | " + taskID + ": " + periodSecs + "s, f:" + flexSecs;

    private SensorManager mSensorManager;
    private PreferenceManager mPreferenceManager;
    private DbProvider mDbProvider;

    private static DbModuleInstallationDao dbModuleInstallationDao;

    private NotificationManager mNotificationManager;

    public HarvesterService() {
    }

    public static HarvesterService getInstance() {
        return INSTANCE;
    }

    public DaoSession getDaoSession() {
        return mDbProvider.getDaoSession();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        Log.d(TAG, "Service starting...");

        // Init database FIRST!
        mDbProvider = DbProvider.getInstance(getApplicationContext());

        mPreferenceManager = PreferenceManager.getInstance(getApplicationContext());

        initService();
    }

    /**
     * Initializes a service
     */
    private void initService() {

        Log.d(TAG, "Initializing service...");

        if (dbModuleInstallationDao == null) {
            dbModuleInstallationDao = mDbProvider.getDaoSession().getDbModuleInstallationDao();
        }

        SharedPreferences sharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        long userId = sharedPreferences.getLong("current_user_id", -1);

        List<DbModuleInstallation> dbModuleInstallations = dbModuleInstallationDao
                .queryBuilder()
                .where(DbModuleInstallationDao.Properties.UserId.eq(userId))
                .build()
                .list();

        if (dbModuleInstallations != null && !dbModuleInstallations.isEmpty()) {
            Log.d(TAG, "Found active modules -> starting monitoring activities...");

            monitorStart();

            Log.d(TAG, "Uploader task tag: " + taskTag);
//            EventUploaderService.schedulePeriodicTask(getApplicationContext(), 5L, 1L, taskTag);

        } else {
            Log.d(TAG, "No active module were found!");
        }

//        RetroServerPushManager.getInstance(getApplicationContext());

        if (mPreferenceManager.getShowNotification()) {
            showIcon();
        } else {
            hideIcon();
        }

        Log.d(TAG, "Service was initiated.");
    }

    private void stopService() {

        monitorStop();

        GcmNetworkManager.getInstance(getApplicationContext()).cancelAllTasks(EventUploaderService.class);
//        RetroServerPushManager.stopPeriodicPush();

        setActivityHandler(null);
        stopForeground(true);
        stopSelf();
    }

    /**
     * Starts sensors / events
     */
    private void monitorStart() {

        Log.d(TAG, "Starting monitoring service...");

//		Handler handler = ActivityCommunicator.getHandler();

        mSensorManager = SensorManager.getInstance(this);

        List<ISensor> enabledSensors = mSensorManager.getEnabledSensors();

        for (ISensor sensor : enabledSensors) {

            if (sensor == null) {
                continue;
            }

            sensor.startSensor();
        }

        Log.d(TAG, "All sensors are enabled!");

        // TODO: enable that later
//        startAccessibilityService();
    }

    /**
     * Stops sensors / events
     */
    private void monitorStop() {

        Log.d(TAG, "Stopping service...");

        if (mSensorManager == null) {
            mSensorManager = SensorManager.getInstance(this);
        }

        for (ISensor sensor : mSensorManager.getEnabledSensors()) {

            if (sensor == null) {
                continue;
            }

            sensor.stopSensor();
        }

        Log.d(TAG, "All sensors were stopped.");
        Log.d(TAG, "Service was stopped.");
    }

    /**
     * Shows service ongoing notification that service is running
     */
    private void showIcon() {

        Log.d(TAG, "Showing icon...");

        if (mNotificationManager == null) {
            mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_kraken_service)
                        .setContentTitle(getString(R.string.service_running_notification_title))
                        .setContentText(getString(R.string.service_running_notification_text))
                        .setPriority(Notification.PRIORITY_MIN)
                        .setOngoing(true);

        mNotificationManager.notify(Settings.DEFAULT_NOTIFICATION_ID, mBuilder.build());
    }

    /**
     * Hides service ongoing notification that service is running
     */
    private void hideIcon() {

        Log.d(TAG, "Hiding icon...");

        if (mNotificationManager == null) {
            mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }

        mNotificationManager.cancel(Settings.DEFAULT_NOTIFICATION_ID);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand");

        if (intent != null && intent.hasExtra(Settings.INTENT_EXTRA_SHOW_ICON)) {

            boolean showIcon = intent.getBooleanExtra(Settings.INTENT_EXTRA_SHOW_ICON, PreferenceManager.DEFAULT_KRAKEN_SHOW_NOTIFICATION);

            if (showIcon) {
                showIcon();
            } else {
                hideIcon();
            }
        }

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_kraken_service)
                        .setContentTitle(getString(R.string.service_running_notification_title))
                        .setContentText(getString(R.string.service_running_notification_text))
                        .setPriority(Notification.PRIORITY_MIN)
                        .setOngoing(true);

        startForeground(Settings.DEFAULT_NOTIFICATION_ID, mBuilder.build());

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {

        Log.d(TAG, "Destroying service...");

        stopService();

        dbModuleInstallationDao = null;

        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.d(TAG, "Unbinding...");

        setActivityHandler(null);
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "Binding...");

        return messenger.getBinder();
    }

    private void setActivityHandler(Messenger messenger) {
        ActivityCommunicator.setMessenger(messenger, this);
    }

    @Override
    public boolean handleMessage(Message msg) {

        Bundle data = msg.getData();
        Serializable obj = data.getSerializable("command");
        if (obj == null || !(obj instanceof ECommandType)) {
            return false;
        }

        ECommandType command = (ECommandType) obj;

        switch (command) {
            case SET_HANDLER:
                Log.d(TAG, "Command: SET_HANDLER received");
                Messenger messenger = (Messenger) data.getParcelable("value");
                setActivityHandler(messenger);
                break;
            case START_SERVICE:
                Log.d(TAG, "Command: START_SERVICE received");
                initService();
                break;
            case STOP_SERVICE:
                Log.d(TAG, "Command: STOP_SERVICE received");
                stopService();
                break;
            case REMOVE_HANDLER:
                Log.d(TAG, "Command: REMOVE_HANDLER received");
                setActivityHandler(null);
                break;
            case HIDE_ICON:
                Log.d(TAG, "Command: HIDE_ICON received");
                hideIcon();
                break;
            case SHOW_ICON:
                Log.d(TAG, "Command: SHOW_ICON received");
                showIcon();
                break;
            default:
                Log.e(TAG, "Unknown Command!");
                return false;
        }
        return true;
    }

    public static void sendCommand(Messenger messenger, ECommandType command, Object value) {

        if (messenger == null || command == null) {
            return;
        }

        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putSerializable("command", command);

        if (value != null) {
            if (value instanceof String) {
                bundle.putString("value", (String) value);
            } else {
                if (value instanceof Parcelable) {
                    bundle.putParcelable("value", (Parcelable) value);
                }
            }
        }

        msg.setData(bundle);

        try {
            messenger.send(msg);
        } catch (RemoteException e) {
            Log.e(TAG, "Cannot send message! Error: ", e);
        }
    }

    /**
     * Starts AccessibilityService
     */
    private void startAccessibilityService() {

        Log.d(TAG, "Starting accessibility service...");

        Intent intent = new Intent(this, AssistanceAccessibilityService.class);
        startService(intent);
    }

}