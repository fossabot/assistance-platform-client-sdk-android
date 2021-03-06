package de.tudarmstadt.informatik.tk.assistance.sdk.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 22.08.2015
 */
public enum HardwareUtils {
    ;

    /**
     * Returns current version of Android operating system
     *
     * @return
     */
    public static String getAndroidVersion() {
        return VERSION.RELEASE;
    }

    /**
     * Returns device brand name
     *
     * @return
     */
    public static String getDeviceBrandName() {
        return Build.BRAND;
    }

    /**
     * Returns device model name
     *
     * @return
     */
    public static String getDeviceModelName() {
        return Build.MODEL;
    }

    /**
     * Returns unique Android id for current device
     *
     * @param context
     * @return
     */
    public static String getAndroidId(Context context) {
        return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
    }

}
