package de.tudarmstadt.informatik.tk.assistance.sdk.db;

import org.greenrobot.greendao.annotation.*;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DaoSession;
import org.greenrobot.greendao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.
/**
 * Entity mapped to table "logs_sensor_upload".
 */
@Entity(active = true, nameInDb = "logs_sensor_upload")
public class LogsSensorUpload {

    @Id(autoincrement = true)
    @Index
    private Long id;
    private Long startTime;
    private Long processingTime;
    private Long responseTime;
    private String networkType;
    private Integer eventsNumber;
    private Long bodySize;

    @Index
    private Long userId;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient LogsSensorUploadDao myDao;

    @ToOne(joinProperty = "userId")
    private DbUser dbUser;

    @Generated
    private transient Long dbUser__resolvedKey;

    @Generated
    public LogsSensorUpload() {
    }

    public LogsSensorUpload(Long id) {
        this.id = id;
    }

    @Generated
    public LogsSensorUpload(Long id, Long startTime, Long processingTime, Long responseTime, String networkType, Integer eventsNumber, Long bodySize, Long userId) {
        this.id = id;
        this.startTime = startTime;
        this.processingTime = processingTime;
        this.responseTime = responseTime;
        this.networkType = networkType;
        this.eventsNumber = eventsNumber;
        this.bodySize = bodySize;
        this.userId = userId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLogsSensorUploadDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Long processingTime) {
        this.processingTime = processingTime;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public Integer getEventsNumber() {
        return eventsNumber;
    }

    public void setEventsNumber(Integer eventsNumber) {
        this.eventsNumber = eventsNumber;
    }

    public Long getBodySize() {
        return bodySize;
    }

    public void setBodySize(Long bodySize) {
        this.bodySize = bodySize;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated
    public DbUser getDbUser() {
        Long __key = this.userId;
        if (dbUser__resolvedKey == null || !dbUser__resolvedKey.equals(__key)) {
            __throwIfDetached();
            DbUserDao targetDao = daoSession.getDbUserDao();
            DbUser dbUserNew = targetDao.load(__key);
            synchronized (this) {
                dbUser = dbUserNew;
            	dbUser__resolvedKey = __key;
            }
        }
        return dbUser;
    }

    @Generated
    public void setDbUser(DbUser dbUser) {
        synchronized (this) {
            this.dbUser = dbUser;
            userId = dbUser == null ? null : dbUser.getId();
            dbUser__resolvedKey = userId;
        }
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

}