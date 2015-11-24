package de.tudarmstadt.informatik.tk.android.assistance.sdk.util;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import java.util.HashMap;
import java.util.Map;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.DtoType;

/**
 * Provides permission checks on runtime
 *
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 02.10.2015
 */
public class PermissionUtils {

    private static final String TAG = PermissionUtils.class.getSimpleName();

    private static PermissionUtils INSTANCE;

    private final Context mContext;

    private Map<String, String[]> dangerousGroup;

    private Map<String, String[]> dangerousPermissionsToDtoMapping;

    private PermissionUtils(Context context) {
        this.mContext = context;

        // don't mess with the order of functions!
        createDangerousGroupsPermissions();
        createDangerousPermissionsToDtoMappings();
    }

    /**
     * Initializes and returns an instance of this class
     *
     * @param context
     * @return
     */
    public static PermissionUtils getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = new PermissionUtils(context);
        }

        return INSTANCE;
    }

    /**
     * these permissions need special permission from user in runtime
     */
    private void createDangerousGroupsPermissions() {

        dangerousGroup = new HashMap<>();

        dangerousGroup.put(Manifest.permission_group.CALENDAR, new String[]{
                Manifest.permission.READ_CALENDAR,
                Manifest.permission.WRITE_CALENDAR
        });

        dangerousGroup.put(Manifest.permission_group.CAMERA, new String[]{
                Manifest.permission.CAMERA
        });

        dangerousGroup.put(Manifest.permission_group.CONTACTS, new String[]{
                Manifest.permission.GET_ACCOUNTS,
                Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.READ_CONTACTS
        });

        dangerousGroup.put(Manifest.permission_group.LOCATION, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        });

        dangerousGroup.put(Manifest.permission_group.MICROPHONE, new String[]{
                Manifest.permission.RECORD_AUDIO
        });

        dangerousGroup.put(Manifest.permission_group.PHONE, new String[]{
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.WRITE_CALL_LOG,
                Manifest.permission.ADD_VOICEMAIL,
                Manifest.permission.USE_SIP,
                Manifest.permission.PROCESS_OUTGOING_CALLS
        });

        dangerousGroup.put(Manifest.permission_group.SENSORS, new String[]{
                Manifest.permission.BODY_SENSORS
        });

        dangerousGroup.put(Manifest.permission_group.SMS, new String[]{
                Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.READ_SMS,
                Manifest.permission.RECEIVE_WAP_PUSH,
                Manifest.permission.RECEIVE_MMS
        });

        dangerousGroup.put(Manifest.permission_group.STORAGE, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        });
    }

    /**
     * creating mapping between API definitions and permissions
     * key: capability type of a module
     * value: needed permissions for that
     */
    private void createDangerousPermissionsToDtoMappings() {

        dangerousPermissionsToDtoMapping = new HashMap<>();

        dangerousPermissionsToDtoMapping.put(
                DtoType.getApiName(DtoType.CALENDAR),
                dangerousGroup.get(Manifest.permission_group.CALENDAR)
        );

        dangerousPermissionsToDtoMapping.put(
                DtoType.getApiName(DtoType.CALL_LOG),
                new String[]{
                        Manifest.permission.READ_CALL_LOG,
                        Manifest.permission.WRITE_CALL_LOG
                }
        );

        dangerousPermissionsToDtoMapping.put(
                DtoType.getApiName(DtoType.CONTACTS),
                dangerousGroup.get(Manifest.permission_group.CONTACTS)
        );

        dangerousPermissionsToDtoMapping.put(
                DtoType.getApiName(DtoType.LOCATION),
                dangerousGroup.get(Manifest.permission_group.LOCATION)
        );
    }

    public Map<String, String[]> getDangerousGroup() {
        return this.dangerousGroup;
    }

    public Map<String, String[]> getDangerousPermissionsToDtoMapping() {
        return this.dangerousPermissionsToDtoMapping;
    }

    /**
     * Generic check for given permission (Android M version)
     *
     * @param permission
     * @return
     */
    @TargetApi(Build.VERSION_CODES.M)
    public boolean isPermissionGranted(String permission) {

        if (permission == null) {
            return false;
        }

        return ContextCompat.checkSelfPermission(mContext, permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Handles user permission action
     *
     * @param grantResults
     * @return
     */
    public boolean handlePermissionResult(@NonNull int[] grantResults) {

        if (grantResults == null || grantResults.length <= 0) {
            return false;
        }

        return grantResults[0] == PackageManager.PERMISSION_GRANTED;
    }
}