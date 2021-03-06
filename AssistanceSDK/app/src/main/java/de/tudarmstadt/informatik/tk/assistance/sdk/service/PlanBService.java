package de.tudarmstadt.informatik.tk.assistance.sdk.service;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

import de.tudarmstadt.informatik.tk.assistance.sdk.provider.HarvesterServiceProvider;
import de.tudarmstadt.informatik.tk.assistance.sdk.provider.PreferenceProvider;
import de.tudarmstadt.informatik.tk.assistance.sdk.util.GcmUtils;
import de.tudarmstadt.informatik.tk.assistance.sdk.util.logger.Log;

/**
 * This service is looking for sensing service running.
 * If it is not running, starts it
 * Executing every 3 hours +- 15 min
 *
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 26.11.2015
 */
public class PlanBService extends GcmTaskService {

    private static final String TAG = PlanBService.class.getSimpleName();

    // task identifier
    private static final long taskID = 4321;
    // the task should be executed every N seconds
    private static final long periodSecs = 11700L;
    // the task can run as early as N seconds from the scheduled time
    private static final long flexSecs = 9900L;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "PlanB Service starting...");

        // schedule service to repeat itself
        GcmUtils.startPeriodicTask(
                getApplicationContext(),
                PlanBService.class,
                taskID,
                periodSecs,
                flexSecs);
    }

    @Override
    public int onRunTask(TaskParams taskParams) {

        Log.d(TAG, "PlanB task has been executed!");

        String userToken = PreferenceProvider
                .getInstance(getApplicationContext())
                .getUserToken();

        // only when user is logged in
        if (userToken != null && !userToken.isEmpty()) {

            HarvesterServiceProvider serviceProvider = HarvesterServiceProvider.getInstance(getApplicationContext());

            if (!serviceProvider.isServiceRunning()) {
                serviceProvider.startSensingService();
            }

            if (!serviceProvider.isAccessibilityServiceRunning()) {
                serviceProvider.startAccessibilityService();
            }
        }

        return GcmNetworkManager.RESULT_SUCCESS;
    }
}