package de.tudarmstadt.informatik.tk.android.kraken.model.api.dto.sensor;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import de.tudarmstadt.informatik.tk.android.kraken.model.api.dto.DtoType;
import de.tudarmstadt.informatik.tk.android.kraken.model.sensor.Sensor;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.08.2015
 */
public class GyroscopeSensorDto implements Sensor {

    private Long id;

    @SerializedName("x")
    @Expose
    private Double x;

    @SerializedName("y")
    @Expose
    private Double y;

    @SerializedName("z")
    @Expose
    private Double z;

    @SerializedName("xUncalibratedNoDrift")
    @Expose
    private Float xUncalibratedNoDrift;

    @SerializedName("yUncalibratedNoDrift")
    @Expose
    private Float yUncalibratedNoDrift;

    @SerializedName("zUncalibratedNoDrift")
    @Expose
    private Float zUncalibratedNoDrift;

    @SerializedName("xUncalibratedEstimatedDrift")
    @Expose
    private Float xUncalibratedEstimatedDrift;

    @SerializedName("yUncalibratedEstimatedDrift")
    @Expose
    private Float yUncalibratedEstimatedDrift;

    @SerializedName("zUncalibratedEstimatedDrift")
    @Expose
    private Float zUncalibratedEstimatedDrift;

    @SerializedName("accuracy")
    @Expose
    private Integer accuracy;

    /**
     * Not-null value.
     */
    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("type")
    @Expose
    private String typeStr;

    private int type;

    public GyroscopeSensorDto() {
        this.type = DtoType.GYROSCOPE;
        this.typeStr = DtoType.getApiName(this.type);
    }

    public GyroscopeSensorDto(long id) {
        this.id = id;
        this.type = DtoType.GYROSCOPE;
        this.typeStr = DtoType.getApiName(this.type);
    }

    public GyroscopeSensorDto(Long id, Double x, Double y, Double z, Float xUncalibratedNoDrift, Float yUncalibratedNoDrift, Float zUncalibratedNoDrift, Float xUncalibratedEstimatedDrift, Float yUncalibratedEstimatedDrift, Float zUncalibratedEstimatedDrift, Integer accuracy, String created) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xUncalibratedNoDrift = xUncalibratedNoDrift;
        this.yUncalibratedNoDrift = yUncalibratedNoDrift;
        this.zUncalibratedNoDrift = zUncalibratedNoDrift;
        this.xUncalibratedEstimatedDrift = xUncalibratedEstimatedDrift;
        this.yUncalibratedEstimatedDrift = yUncalibratedEstimatedDrift;
        this.zUncalibratedEstimatedDrift = zUncalibratedEstimatedDrift;
        this.accuracy = accuracy;
        this.created = created;
        this.type = DtoType.GYROSCOPE;
        this.typeStr = DtoType.getApiName(this.type);
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

    public Float getxUncalibratedNoDrift() {
        return this.xUncalibratedNoDrift;
    }

    public void setxUncalibratedNoDrift(Float xUncalibratedNoDrift) {
        this.xUncalibratedNoDrift = xUncalibratedNoDrift;
    }

    public Float getyUncalibratedNoDrift() {
        return this.yUncalibratedNoDrift;
    }

    public void setyUncalibratedNoDrift(Float yUncalibratedNoDrift) {
        this.yUncalibratedNoDrift = yUncalibratedNoDrift;
    }

    public Float getzUncalibratedNoDrift() {
        return this.zUncalibratedNoDrift;
    }

    public void setzUncalibratedNoDrift(Float zUncalibratedNoDrift) {
        this.zUncalibratedNoDrift = zUncalibratedNoDrift;
    }

    public Float getxUncalibratedEstimatedDrift() {
        return this.xUncalibratedEstimatedDrift;
    }

    public void setxUncalibratedEstimatedDrift(Float xUncalibratedEstimatedDrift) {
        this.xUncalibratedEstimatedDrift = xUncalibratedEstimatedDrift;
    }

    public Float getyUncalibratedEstimatedDrift() {
        return this.yUncalibratedEstimatedDrift;
    }

    public void setyUncalibratedEstimatedDrift(Float yUncalibratedEstimatedDrift) {
        this.yUncalibratedEstimatedDrift = yUncalibratedEstimatedDrift;
    }

    public Float getzUncalibratedEstimatedDrift() {
        return this.zUncalibratedEstimatedDrift;
    }

    public void setzUncalibratedEstimatedDrift(Float zUncalibratedEstimatedDrift) {
        this.zUncalibratedEstimatedDrift = zUncalibratedEstimatedDrift;
    }

    public Integer getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
    }

    public String getTypeStr() {
        return this.typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    @Override
    public String toString() {
        return "GyroscopeSensorDto{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", xUncalibratedNoDrift=" + xUncalibratedNoDrift +
                ", yUncalibratedNoDrift=" + yUncalibratedNoDrift +
                ", zUncalibratedNoDrift=" + zUncalibratedNoDrift +
                ", xUncalibratedEstimatedDrift=" + xUncalibratedEstimatedDrift +
                ", yUncalibratedEstimatedDrift=" + yUncalibratedEstimatedDrift +
                ", zUncalibratedEstimatedDrift=" + zUncalibratedEstimatedDrift +
                ", accuracy=" + accuracy +
                ", created='" + created + '\'' +
                ", typeStr='" + typeStr + '\'' +
                ", type=" + type +
                '}';
    }
}
