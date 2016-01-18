package de.tudarmstadt.informatik.tk.assistance.sdk.db;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "power_state_sensor".
 */
public class DbPowerStateSensor implements de.tudarmstadt.informatik.tk.assistance.sdk.interfaces.IDbSensor {

    private Long id;
    private Boolean isCharging;
    private Float percent;
    /** Not-null value. */
    private String created;
    private Integer chargingState;
    private Integer chargingMode;
    private Boolean powerSaveMode;
    private Long deviceId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient DbPowerStateSensorDao myDao;

    private DbDevice dbDevice;
    private Long dbDevice__resolvedKey;


    public DbPowerStateSensor() {
    }

    public DbPowerStateSensor(Long id) {
        this.id = id;
    }

    public DbPowerStateSensor(Long id, Boolean isCharging, Float percent, String created, Integer chargingState, Integer chargingMode, Boolean powerSaveMode, Long deviceId) {
        this.id = id;
        this.isCharging = isCharging;
        this.percent = percent;
        this.created = created;
        this.chargingState = chargingState;
        this.chargingMode = chargingMode;
        this.powerSaveMode = powerSaveMode;
        this.deviceId = deviceId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDbPowerStateSensorDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsCharging() {
        return isCharging;
    }

    public void setIsCharging(Boolean isCharging) {
        this.isCharging = isCharging;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    /** Not-null value. */
    public String getCreated() {
        return created;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getChargingState() {
        return chargingState;
    }

    public void setChargingState(Integer chargingState) {
        this.chargingState = chargingState;
    }

    public Integer getChargingMode() {
        return chargingMode;
    }

    public void setChargingMode(Integer chargingMode) {
        this.chargingMode = chargingMode;
    }

    public Boolean getPowerSaveMode() {
        return powerSaveMode;
    }

    public void setPowerSaveMode(Boolean powerSaveMode) {
        this.powerSaveMode = powerSaveMode;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /** To-one relationship, resolved on first access. */
    public DbDevice getDbDevice() {
        Long __key = this.deviceId;
        if (dbDevice__resolvedKey == null || !dbDevice__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DbDeviceDao targetDao = daoSession.getDbDeviceDao();
            DbDevice dbDeviceNew = targetDao.load(__key);
            synchronized (this) {
                dbDevice = dbDeviceNew;
            	dbDevice__resolvedKey = __key;
            }
        }
        return dbDevice;
    }

    public void setDbDevice(DbDevice dbDevice) {
        synchronized (this) {
            this.dbDevice = dbDevice;
            deviceId = dbDevice == null ? null : dbDevice.getId();
            dbDevice__resolvedKey = deviceId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
