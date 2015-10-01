package de.tudarmstadt.informatik.tk.android.kraken.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "network_traffic_event".
 */
public class DbNetworkTrafficEvent implements de.tudarmstadt.informatik.tk.android.kraken.interfaces.IDbSensor {

    private Long id;
    private String appName;
    private Long rxBytes;
    private Long txBytes;
    private Boolean background;
    private Double longitude;
    private Double latitude;
    /** Not-null value. */
    private String created;

    public DbNetworkTrafficEvent() {
    }

    public DbNetworkTrafficEvent(Long id) {
        this.id = id;
    }

    public DbNetworkTrafficEvent(Long id, String appName, Long rxBytes, Long txBytes, Boolean background, Double longitude, Double latitude, String created) {
        this.id = id;
        this.appName = appName;
        this.rxBytes = rxBytes;
        this.txBytes = txBytes;
        this.background = background;
        this.longitude = longitude;
        this.latitude = latitude;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Long getRxBytes() {
        return rxBytes;
    }

    public void setRxBytes(Long rxBytes) {
        this.rxBytes = rxBytes;
    }

    public Long getTxBytes() {
        return txBytes;
    }

    public void setTxBytes(Long txBytes) {
        this.txBytes = txBytes;
    }

    public Boolean getBackground() {
        return background;
    }

    public void setBackground(Boolean background) {
        this.background = background;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /** Not-null value. */
    public String getCreated() {
        return created;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCreated(String created) {
        this.created = created;
    }

}
