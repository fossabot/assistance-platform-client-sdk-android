package de.tudarmstadt.informatik.tk.android.kraken.model.api.dto.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import de.tudarmstadt.informatik.tk.android.kraken.model.api.dto.DtoType;
import de.tudarmstadt.informatik.tk.android.kraken.model.api.dto.SensorDto;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.08.2015
 */
public class LoudnessEventDto implements SensorDto {

    private Long id;

    @SerializedName("loudness")
    @Expose
    private float loudness;
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

    public LoudnessEventDto() {
        this.type = DtoType.LOUDNESS;
        this.typeStr = DtoType.getApiName(this.type);
    }

    public LoudnessEventDto(long id) {
        this.id = id;
        this.type = DtoType.LOUDNESS;
        this.typeStr = DtoType.getApiName(this.type);
    }

    public LoudnessEventDto(long id, float loudness, String created) {
        this.id = id;
        this.loudness = loudness;
        this.created = created;
        this.type = DtoType.LOUDNESS;
        this.typeStr = DtoType.getApiName(this.type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getLoudness() {
        return loudness;
    }

    public void setLoudness(float loudness) {
        this.loudness = loudness;
    }

    /**
     * Not-null value.
     */
    public String getCreated() {
        return created;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
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
        return "LoudnessEventRequest{" +
                "id=" + id +
                ", loudness=" + loudness +
                ", created='" + created + '\'' +
                ", typeStr='" + typeStr + '\'' +
                ", type=" + type +
                '}';
    }
}
