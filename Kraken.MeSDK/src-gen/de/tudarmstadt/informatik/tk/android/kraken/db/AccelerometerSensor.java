package de.tudarmstadt.informatik.tk.android.kraken.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "accelerometer_sensor".
 */
public class AccelerometerSensor implements de.tudarmstadt.informatik.tk.android.kraken.interfaces.IDbSensor {

    private Long id;
    private Double x;
    private Double y;
    private Double z;
    /** Not-null value. */
    private String created;
    private Integer accuracy;

    public AccelerometerSensor() {
    }

    public AccelerometerSensor(Long id) {
        this.id = id;
    }

    public AccelerometerSensor(Long id, Double x, Double y, Double z, String created, Integer accuracy) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.created = created;
        this.accuracy = accuracy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    /** Not-null value. */
    public String getCreated() {
        return created;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

}
