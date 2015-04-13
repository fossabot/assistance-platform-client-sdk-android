package de.tudarmstadt.informatik.tk.kraken.android.sdk.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SENSOR_CONNECTION.
 */
public class SensorConnection implements de.tudarmstadt.informatik.tk.kraken.android.sdk.interfaces.IDbSensor {

    private Long id;
    private Integer activeNetwork;
    private Boolean mobileIsAvailable;
    private Integer mobileState;
    private Integer wlanState;
    private Boolean wlanIsAvailable;
    private Long timestamp;

    public SensorConnection() {
    }

    public SensorConnection(Long id) {
        this.id = id;
    }

    public SensorConnection(Long id, Integer activeNetwork, Boolean mobileIsAvailable, Integer mobileState, Integer wlanState, Boolean wlanIsAvailable, Long timestamp) {
        this.id = id;
        this.activeNetwork = activeNetwork;
        this.mobileIsAvailable = mobileIsAvailable;
        this.mobileState = mobileState;
        this.wlanState = wlanState;
        this.wlanIsAvailable = wlanIsAvailable;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getActiveNetwork() {
        return activeNetwork;
    }

    public void setActiveNetwork(Integer activeNetwork) {
        this.activeNetwork = activeNetwork;
    }

    public Boolean getMobileIsAvailable() {
        return mobileIsAvailable;
    }

    public void setMobileIsAvailable(Boolean mobileIsAvailable) {
        this.mobileIsAvailable = mobileIsAvailable;
    }

    public Integer getMobileState() {
        return mobileState;
    }

    public void setMobileState(Integer mobileState) {
        this.mobileState = mobileState;
    }

    public Integer getWlanState() {
        return wlanState;
    }

    public void setWlanState(Integer wlanState) {
        this.wlanState = wlanState;
    }

    public Boolean getWlanIsAvailable() {
        return wlanIsAvailable;
    }

    public void setWlanIsAvailable(Boolean wlanIsAvailable) {
        this.wlanIsAvailable = wlanIsAvailable;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
