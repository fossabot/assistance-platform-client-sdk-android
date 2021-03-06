package de.tudarmstadt.informatik.tk.assistance.sdk.sensing.impl.periodic;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbRunningProcessesSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.model.api.sensing.SensorApiType;
import de.tudarmstadt.informatik.tk.assistance.sdk.provider.PreferenceProvider;
import de.tudarmstadt.informatik.tk.assistance.sdk.sensing.impl.AbstractPeriodicSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.util.DateUtils;
import de.tudarmstadt.informatik.tk.assistance.sdk.util.logger.Log;

/**
 * @author Unknown
 * @edited by Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 24.11.2015
 */
@Singleton
public final class RunningProcessesReaderSensor extends AbstractPeriodicSensor {

    private static final String TAG = RunningProcessesReaderSensor.class.getSimpleName();

    private int UPDATE_INTERVAL_IN_SEC = 30;

    private ActivityManager mActivityManager;
    private List<String> mLastProcesses = new ArrayList<>();

    private String currentProcessName = "";

    @Inject
    public RunningProcessesReaderSensor(Context context) {
        super(context);

        setDataIntervalInSec(UPDATE_INTERVAL_IN_SEC);
        mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    @Override
    public void dumpData() {

        long deviceId = PreferenceProvider.getInstance(context).getCurrentDeviceId();

        DbRunningProcessesSensor runningProcessesEvent = new DbRunningProcessesSensor();

        runningProcessesEvent.setName(currentProcessName);
        runningProcessesEvent.setCreated(DateUtils.dateToISO8601String(new Date(), Locale.getDefault()));
        runningProcessesEvent.setDeviceId(deviceId);

        Log.d(TAG, "Insert entry");

        daoProvider.getRunningProcessesSensorDao().insert(runningProcessesEvent);

        Log.d(TAG, "Finished");
    }

    @Override
    public int getType() {
        return SensorApiType.RUNNING_PROCESSES;
    }

    @Override
    public void reset() {

        currentProcessName = "";
        mLastProcesses.clear();
    }

    @Override
    protected void getData() {

        List<RunningAppProcessInfo> processes = mActivityManager.getRunningAppProcesses();

        List<String> processNames = new ArrayList<>(processes.size());

        boolean processesChanged = processes.size() != mLastProcesses.size();

        for (RunningAppProcessInfo process : processes) {

            processNames.add(process.processName);

            if (!processesChanged && !mLastProcesses.contains(process.processName)) {
                processesChanged = true;
            }
        }

        if (processesChanged) {

            mLastProcesses = processNames;

            for (String processName : processNames) {
                currentProcessName = processName;
                dumpData();
            }
        }
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