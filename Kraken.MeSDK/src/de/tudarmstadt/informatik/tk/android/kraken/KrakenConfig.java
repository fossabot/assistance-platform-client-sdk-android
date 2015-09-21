package de.tudarmstadt.informatik.tk.android.kraken;


/**
 * Config for Kraken SDK
 *
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 18.09.2015
 */
public class KrakenConfig {

    public static final String PLATFORM_NAME = "android";

    /**
     * Android http logger custom name
     */
    public static final String HTTP_LOGGER_NAME = "HTTPS_CLIENT";

    /**
     * Endpoint for uploading sensor reading as well as events
     */
    public static final String ASSISTANCE_EVENT_UPLOAD_ENDPOINT = "/sensordata/upload";

}