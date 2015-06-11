package de.tudarmstadt.informatik.tk.kraken.android.sdk.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SENSOR_CONTACT_MAIL.
 */
public class SensorContactMail implements de.tudarmstadt.informatik.tk.kraken.android.sdk.interfaces.IDbUpdatableSensor {

    private Long id;
    private long fkContact;
    private Long mailId;
    private Long contactId;
    private String address;
    private String type;
    private Long timestamp;
    private Boolean isNew;
    private Boolean isUpdated;
    private Boolean isDeleted;

    public SensorContactMail() {
    }

    public SensorContactMail(Long id) {
        this.id = id;
    }

    public SensorContactMail(Long id, long fkContact, Long mailId, Long contactId, String address, String type, Long timestamp, Boolean isNew, Boolean isUpdated, Boolean isDeleted) {
        this.id = id;
        this.fkContact = fkContact;
        this.mailId = mailId;
        this.contactId = contactId;
        this.address = address;
        this.type = type;
        this.timestamp = timestamp;
        this.isNew = isNew;
        this.isUpdated = isUpdated;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getFkContact() {
        return fkContact;
    }

    public void setFkContact(long fkContact) {
        this.fkContact = fkContact;
    }

    public Long getMailId() {
        return mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsUpdated() {
        return isUpdated;
    }

    public void setIsUpdated(Boolean isUpdated) {
        this.isUpdated = isUpdated;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}