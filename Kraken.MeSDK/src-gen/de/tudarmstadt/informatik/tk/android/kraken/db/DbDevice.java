package de.tudarmstadt.informatik.tk.android.kraken.db;

import de.tudarmstadt.informatik.tk.android.kraken.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "device".
 */
public class DbDevice {

    private Long id;
    private String deviceIdentifier;
    private String os;
    private String osVersion;
    private String brand;
    private String model;
    private Long serverDeviceId;
    private String gcmRegistrationToken;
    private String userDefinedName;
    /** Not-null value. */
    private String created;
    private Long userId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient DbDeviceDao myDao;

    private DbUser dbUser;
    private Long dbUser__resolvedKey;


    public DbDevice() {
    }

    public DbDevice(Long id) {
        this.id = id;
    }

    public DbDevice(Long id, String deviceIdentifier, String os, String osVersion, String brand, String model, Long serverDeviceId, String gcmRegistrationToken, String userDefinedName, String created, Long userId) {
        this.id = id;
        this.deviceIdentifier = deviceIdentifier;
        this.os = os;
        this.osVersion = osVersion;
        this.brand = brand;
        this.model = model;
        this.serverDeviceId = serverDeviceId;
        this.gcmRegistrationToken = gcmRegistrationToken;
        this.userDefinedName = userDefinedName;
        this.created = created;
        this.userId = userId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDbDeviceDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public void setDeviceIdentifier(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getServerDeviceId() {
        return serverDeviceId;
    }

    public void setServerDeviceId(Long serverDeviceId) {
        this.serverDeviceId = serverDeviceId;
    }

    public String getGcmRegistrationToken() {
        return gcmRegistrationToken;
    }

    public void setGcmRegistrationToken(String gcmRegistrationToken) {
        this.gcmRegistrationToken = gcmRegistrationToken;
    }

    public String getUserDefinedName() {
        return userDefinedName;
    }

    public void setUserDefinedName(String userDefinedName) {
        this.userDefinedName = userDefinedName;
    }

    /** Not-null value. */
    public String getCreated() {
        return created;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCreated(String created) {
        this.created = created;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** To-one relationship, resolved on first access. */
    public DbUser getDbUser() {
        Long __key = this.userId;
        if (dbUser__resolvedKey == null || !dbUser__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DbUserDao targetDao = daoSession.getDbUserDao();
            DbUser dbUserNew = targetDao.load(__key);
            synchronized (this) {
                dbUser = dbUserNew;
            	dbUser__resolvedKey = __key;
            }
        }
        return dbUser;
    }

    public void setDbUser(DbUser dbUser) {
        synchronized (this) {
            this.dbUser = dbUser;
            userId = dbUser == null ? null : dbUser.getId();
            dbUser__resolvedKey = userId;
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
