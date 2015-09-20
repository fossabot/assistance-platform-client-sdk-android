package de.tudarmstadt.informatik.tk.android.kraken.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

import java.io.Serializable;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.kraken.ActivityCommunicator;
import de.tudarmstadt.informatik.tk.android.kraken.KrakenSdkSettings;
import de.tudarmstadt.informatik.tk.android.kraken.communication.RetroServerPushManager;
import de.tudarmstadt.informatik.tk.android.kraken.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.kraken.db.DatabaseManager;
import de.tudarmstadt.informatik.tk.android.kraken.model.db.sensors.ECommandType;
import de.tudarmstadt.informatik.tk.android.kraken.model.db.sensors.SensorManager;
import de.tudarmstadt.informatik.tk.android.kraken.model.db.sensors.interfaces.ISensor;
import de.tudarmstadt.informatik.tk.android.kraken.preference.PreferenceManager;
import de.tudarmstadt.informatik.tk.android.kraken.R;


public class KrakenService extends Service implements Callback {

    private static final String TAG = KrakenService.class.getSimpleName();

    // public static ScheduledExecutorService m_scheduleTaskExecutor;

    private boolean m_bIsRunning = false;

    private static KrakenService instance;

    private final Messenger messenger = new Messenger(new Handler(this));

    private SensorManager mSensorManager;
    private PreferenceManager mPreferenceManager;
    private DatabaseManager mDatabaseManager;

    public static KrakenService getInstance() {
        return instance;
    }

    public DaoSession getDaoSession() {
        return mDatabaseManager.getDaoSession();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "OnCreate. Service starting...");

        instance = this;

        // Init database FIRST!
        mDatabaseManager = DatabaseManager.getInstance(getApplicationContext());

        mPreferenceManager = PreferenceManager.getInstance(getApplicationContext());

        // GcmManager.getInstance(this).registerAtCloud();

        startService();
    }

    private void startService() {

        if (!m_bIsRunning) {
            m_bIsRunning = true;
            monitorStart();
        }

        // TODO: enable it if ready with sending info
//        RetroServerPushManager.getInstance(getApplicationContext());

        if (mPreferenceManager.getShowNotification()) {
            showIcon();
        } else {
            hideIcon();
        }
    }

    private void showIcon() {

        Log.d(TAG, "Showing icon...");

        //TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        //stackBuilder.addParentStack(MainActivity.class);
        //Intent resultIntent = new Intent(this, MainActivity.class);

        // Adds the Intent that starts the Activity to the top of the stack
        //stackBuilder.addNextIntent(resultIntent);
        //PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(this);

        //builder.setSmallIcon(R.drawable.ic_kraken_service).setContentIntent(resultPendingIntent);

        // FIXME This is disabled for a short time, due to ongoing brainstorming on design

        Resources res = getResources();
        int height = Math.round(res.getDimension(android.R.dimen.notification_large_icon_height) * 0.75f);
        int width = Math.round(res.getDimension(android.R.dimen.notification_large_icon_width) * 0.75f);
        Bitmap kraki = BitmapFactory.decodeResource(res, R.drawable.kraki_big);
        builder.setLargeIcon(Bitmap.createScaledBitmap(kraki, width, height, false));

        builder.setContentTitle(getString(R.string.app_name));
        builder.setContentText(getString(R.string.service_notfication_text));

        builder.setOngoing(true);
//        startForeground(KrakenSdkSettings.KRAKEN_NOTIFICATION_ID, builder.build());

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify("kraken", KrakenSdkSettings.KRAKEN_NOTIFICATION_ID, builder.build());
    }

    private void hideIcon() {

        Log.d(TAG, "Hiding icon...");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel("kraken", KrakenSdkSettings.KRAKEN_NOTIFICATION_ID);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand");

        if (intent != null && intent.hasExtra(KrakenSdkSettings.INTENT_EXTRA_SHOW_ICON)) {

            boolean showIcon = intent.getBooleanExtra(KrakenSdkSettings.INTENT_EXTRA_SHOW_ICON, PreferenceManager.DEFAULT_KRAKEN_SHOW_NOTIFICATION);
            if (showIcon) {
                showIcon();
            } else {
                hideIcon();
            }
        }

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {

        Log.d(TAG, "Service onDestroy");

        stopService();
        super.onDestroy();
    }

    private void stopService() {
        if (m_bIsRunning) {
            monitorStop();
            m_bIsRunning = false;
        }

        //ServerPushManager.stopPeriodicPush();
        RetroServerPushManager.stopPeriodicPush();
        setActivityHandler(null);
        hideIcon();
        stopSelf();
    }

    public boolean isRunning() {
        return m_bIsRunning;
    }

    private void monitorStart() {

        Log.d(TAG, "Starting monitoring service...");

//		Handler handler = ActivityCommunicator.getHandler();

        mSensorManager = SensorManager.getInstance(this);

        List<ISensor> enabledSensors = mSensorManager.getEnabledSensors();

        Log.d(TAG, "Active sensors: " + enabledSensors.size());

        for (ISensor sensor : enabledSensors) {
            sensor.startSensor();
//			sensor.setCallbackHandler(handler);
        }

        Log.d(TAG, "All sensors are enabled.");

        // TODO: enable that later
//        startAccessibilityService();
    }

    private void monitorStop() {

        Log.d(TAG, "Stopping service...");

        Log.d(TAG, "Active sensors: " + mSensorManager.getEnabledSensors());

        for (ISensor sensor : mSensorManager.getEnabledSensors()) {
            sensor.stopSensor();
        }

        Log.d(TAG, "All sensors were stopped.");
        Log.d(TAG, "Service was stopped.");
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.d(TAG, "Service onUnbind");

        setActivityHandler(null);
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "Service onBind");

        return messenger.getBinder();
    }

    private void setActivityHandler(Messenger messenger) {
        ActivityCommunicator.setMessenger(messenger, this);
    }

    @Override
    public boolean handleMessage(Message msg) {

        Bundle data = msg.getData();
        Serializable obj = data.getSerializable("command");
        if (obj == null || !(obj instanceof ECommandType))
            return false;

        switch ((ECommandType) obj) {
            case SET_HANDLER:
                Messenger messenger = (Messenger) data.getParcelable("value");
                setActivityHandler(messenger);
                break;
            case START_SERVICE:
                startService();
                break;
            case STOP_SERVICE:
                stopService();
                break;
            case REMOVE_HANDLER:
                setActivityHandler(null);
                break;
            case HIDE_ICON:
                hideIcon();
                break;
            case SHOW_ICON:
                showIcon();
                break;
            default:
                return false;
        }
        return true;
    }

    public static void handleCommand(Messenger messenger, ECommandType command, Object value) {

        if (messenger == null || command == null) {
            return;
        }

        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putSerializable("command", command);

        if (value != null) {
            if (value instanceof String)
                bundle.putString("value", (String) value);
            else if (value instanceof Parcelable)
                bundle.putParcelable("value", (Parcelable) value);
        }

        msg.setData(bundle);

        try {
            messenger.send(msg);
        } catch (RemoteException e) {
            Log.e(TAG, "Cannot send message! Error: ", e);
        }
    }

    private void startAccessibilityService() {

        Log.d(TAG, "Starting accessibility service...");

        Intent intent = new Intent(this, KrakenAccessibilityService.class);
        startService(intent);
    }

}
