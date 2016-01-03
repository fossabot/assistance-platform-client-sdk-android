package de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.device;

import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.Config;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * API endpoints for managing user's devices
 *
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 13.09.2015
 */
public interface DeviceApi {

    @POST(Config.DEVICE_REGISTRATION_ENDPOINT)
    void registerDevice(@Header("X-AUTH-TOKEN") String userToken,
                        @Body DeviceRegistrationRequestDto body,
                        Callback<Void> callback);

    @GET(Config.DEVICE_LIST_ENDPOINT)
    void getDeviceList(@Header("X-AUTH-TOKEN") String userToken,
                       Callback<List<DeviceListResponseDto>> callback);

    @POST(Config.DEVICE_SET_USER_DEFINED_NAME_ENDPOINT)
    void setUserDefinedName(@Header("X-AUTH-TOKEN") String userToken,
                            @Body DeviceUserDefinedNameRequestDto body,
                            Callback<Void> callback);

}