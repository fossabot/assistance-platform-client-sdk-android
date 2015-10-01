package de.tudarmstadt.informatik.tk.android.kraken.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "browser_history_event".
 */
public class DbBrowserHistoryEvent implements de.tudarmstadt.informatik.tk.android.kraken.interfaces.IDbUpdatableSensor {

    private Long id;
    private String url;
    private String title;
    private Long lastVisited;
    private Integer visits;
    private Boolean bookmark;
    private Boolean isNew;
    private Boolean isUpdated;
    private Boolean isDeleted;
    /** Not-null value. */
    private String created;

    public DbBrowserHistoryEvent() {
    }

    public DbBrowserHistoryEvent(Long id) {
        this.id = id;
    }

    public DbBrowserHistoryEvent(Long id, String url, String title, Long lastVisited, Integer visits, Boolean bookmark, Boolean isNew, Boolean isUpdated, Boolean isDeleted, String created) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.lastVisited = lastVisited;
        this.visits = visits;
        this.bookmark = bookmark;
        this.isNew = isNew;
        this.isUpdated = isUpdated;
        this.isDeleted = isDeleted;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(Long lastVisited) {
        this.lastVisited = lastVisited;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Boolean getBookmark() {
        return bookmark;
    }

    public void setBookmark(Boolean bookmark) {
        this.bookmark = bookmark;
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

    /** Not-null value. */
    public String getCreated() {
        return created;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCreated(String created) {
        this.created = created;
    }

}
