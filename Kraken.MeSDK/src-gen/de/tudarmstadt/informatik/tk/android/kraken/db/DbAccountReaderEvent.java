package de.tudarmstadt.informatik.tk.android.kraken.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "account_reader_event".
 */
public class DbAccountReaderEvent implements de.tudarmstadt.informatik.tk.android.kraken.interfaces.IDbSensor {

    private Long id;
    private String types;
    /** Not-null value. */
    private String created;

    public DbAccountReaderEvent() {
    }

    public DbAccountReaderEvent(Long id) {
        this.id = id;
    }

    public DbAccountReaderEvent(Long id, String types, String created) {
        this.id = id;
        this.types = types;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
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