package de.tudarmstadt.informatik.tk.assistance.api.tester.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wladimir Schmidt on 28.06.2015.
 */
public class LoginResponse {

    @SerializedName("token")
    @Expose
    private String userToken;

    @SerializedName("device_id")
    @Expose
    private Long deviceId;

    public LoginResponse() {
    }

    public LoginResponse(String userToken, Long deviceId) {
        this.userToken = userToken;
        this.deviceId = deviceId;
    }

    public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getUserToken() {
        return userToken;
    }

    public Long getDeviceId() {
        return this.deviceId;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userToken='" + userToken + '\'' +
                ", deviceId=" + deviceId +
                '}';
    }
}