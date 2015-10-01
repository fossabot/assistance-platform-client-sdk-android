package de.tudarmstadt.informatik.tk.android.kraken.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "running_services_event".
 */
public class DbRunningServicesEvent implements de.tudarmstadt.informatik.tk.android.kraken.interfaces.IDbSensor {

    private Long id;
    private String runningServices;
    /** Not-null value. */
    private String created;

    public DbRunningServicesEvent() {
    }

    public DbRunningServicesEvent(Long id) {
        this.id = id;
    }

    public DbRunningServicesEvent(Long id, String runningServices, String created) {
        this.id = id;
        this.runningServices = runningServices;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRunningServices() {
        return runningServices;
    }

    public void setRunningServices(String runningServices) {
        this.runningServices = runningServices;
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
