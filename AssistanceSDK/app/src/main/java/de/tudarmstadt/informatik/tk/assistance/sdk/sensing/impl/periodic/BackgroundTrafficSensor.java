package de.tudarmstadt.informatik.tk.assistance.sdk.sensing.impl.periodic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbNetworkTrafficSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.model.api.sensing.SensorApiType;
import de.tudarmstadt.informatik.tk.assistance.sdk.model.enums.EPushType;
import de.tudarmstadt.informatik.tk.assistance.sdk.provider.PreferenceProvider;
import de.tudarmstadt.informatik.tk.assistance.sdk.sensing.impl.AbstractPeriodicSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.sensing.impl.triggered.ForegroundTrafficSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.util.DateUtils;
import de.tudarmstadt.informatik.tk.assistance.sdk.util.logger.Log;

/**
 * This is a Periodic Sensor class which collect the mobile traffic data produced by the apps in the
 * background in periodic intervals. This is important to get the traffic from apps which runs
 * services in background.
 * <p>
 * Created by Stefan Hacker on 09.12.14
 *
 * @edited by Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 24.11.2015
 */
@Singleton
public final class BackgroundTrafficSensor extends AbstractPeriodicSensor {

    private static final String TAG = BackgroundTrafficSensor.class.getSimpleName();

    private int UPDATE_INTERVAL_IN_SEC = 5 * 60;

    private PackageManager packageManager;

    /**
     * Constructor of a new Background Traffic Sensor
     *
     * @param context global information about assistance app
     */
    @Inject
    public BackgroundTrafficSensor(Context context) {
        super(context);
        init();
    }

    /**
     * Initializer
     */
    private void init() {

        setDataIntervalInSec(UPDATE_INTERVAL_IN_SEC);

        packageManager = context.getPackageManager();

        long deviceId = PreferenceProvider.getInstance(context).getCurrentDeviceId();

        //initial Data
        DbNetworkTrafficSensor networkTrafficEvent = new DbNetworkTrafficSensor();

        networkTrafficEvent.setAppName(ForegroundTrafficSensor.EVENT_START_ASSISTANCE);
        networkTrafficEvent.setBackground(true);
        networkTrafficEvent.setCreated(DateUtils.dateToISO8601String(new Date(), Locale.getDefault()));

        double lastLatitude = PreferenceProvider.getInstance(context).getLastLatitude();
        double lastLongitude = PreferenceProvider.getInstance(context).getLastLongitude();

        if (lastLatitude != 0) {
            networkTrafficEvent.setLatitude(lastLatitude);
        }

        if (lastLongitude != 0) {
            networkTrafficEvent.setLongitude(lastLongitude);
        }

        networkTrafficEvent.setDeviceId(deviceId);

        Log.d(TAG, "Insert entry");

        daoProvider.getNetworkTrafficSensorDao().insert(networkTrafficEvent);

        Log.d(TAG, "Finished");

        getData();
    }

    /**
     * Called when timer for period is zero and new measurement data will collect the traffic of all
     * installed apps
     */
    @Override
    protected void getData() {

        List<ApplicationInfo> packages = packageManager
                .getInstalledApplications(PackageManager.GET_META_DATA);

        if (packages == null) {
            return;
        }

        PreferenceProvider preferenceProvider = PreferenceProvider.getInstance(context);
        String created = DateUtils.dateToISO8601String(new Date(), Locale.getDefault());

        List<DbNetworkTrafficSensor> insertList = new ArrayList<>(packages.size());

        for (ApplicationInfo packageInfo : packages) {

            if (packageInfo == null) {
                continue;
            }

            DbNetworkTrafficSensor networkTrafficEvent = new DbNetworkTrafficSensor();

            if (TrafficStats.getUidTxPackets(packageInfo.uid) != 0 ||
                    TrafficStats.getUidRxPackets(packageInfo.uid) != 0) {

                networkTrafficEvent.setAppName(packageInfo.packageName);
                networkTrafficEvent.setTxBytes(TrafficStats.getUidTxPackets(packageInfo.uid));
                networkTrafficEvent.setRxBytes(TrafficStats.getUidRxPackets(packageInfo.uid));
                networkTrafficEvent.setBackground(Boolean.TRUE);
                networkTrafficEvent.setCreated(created);

                double lastLatitude = preferenceProvider.getLastLatitude();
                double lastLongitude = preferenceProvider.getLastLongitude();

                if (lastLatitude != 0) {
                    networkTrafficEvent.setLatitude(lastLatitude);
                }

                if (lastLongitude != 0) {
                    networkTrafficEvent.setLongitude(lastLongitude);
                }

                networkTrafficEvent.setDeviceId(preferenceProvider.getCurrentDeviceId());

                // speed optimization
                insertList.add(networkTrafficEvent);
            }
        }

        Log.d(TAG, "Insert entry");

        daoProvider.getNetworkTrafficSensorDao().insert(insertList);

        Log.d(TAG, "Finished");
    }

    /**
     * set own sensor type for push manager
     *
     * @return sensor type of sensor
     */
    @Override
    public int getType() {
        return SensorApiType.BACKGROUND_TRAFFIC;
    }

    /**
     * set push type of sensor for push manager
     *
     * @return push type of sensor
     */
    @Override
    public EPushType getPushType() {
        return EPushType.WLAN_ONLY;
    }

    @Override
    public void dumpData() {

    }

    @Override
    public void reset() {

    }

    /**
     * Update intervals
     */
    @Override
    public void updateSensorInterval(Double collectionInterval) {

        Log.d(TAG, "onUpdate interval");
        Log.d(TAG, "Old update interval: " + UPDATE_INTERVAL_IN_SEC + " sec");

        int newUpdateIntervalInSec = collectionInterval.intValue();

        Log.d(TAG, "New update interval: " + newUpdateIntervalInSec + " sec");

        this.UPDATE_INTERVAL_IN_SEC = newUpdateIntervalInSec;
        setDataIntervalInSec(newUpdateIntervalInSec);
    }
}
