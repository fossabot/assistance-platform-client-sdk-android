package de.tudarmstadt.informatik.tk.kraken.android.sdk.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SENSOR_ACCOUNTS_READER.
 */
public class SensorAccountsReader implements de.tudarmstadt.informatik.tk.kraken.android.sdk.interfaces.IDbSensor {

    private Long id;
    private String accountTypes;
    private Long timestamp;

    public SensorAccountsReader() {
    }

    public SensorAccountsReader(Long id) {
        this.id = id;
    }

    public SensorAccountsReader(Long id, String accountTypes, Long timestamp) {
        this.id = id;
        this.accountTypes = accountTypes;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(String accountTypes) {
        this.accountTypes = accountTypes;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}