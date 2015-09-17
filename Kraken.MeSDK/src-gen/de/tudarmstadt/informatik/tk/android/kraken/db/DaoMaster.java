package de.tudarmstadt.informatik.tk.android.kraken.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import de.tudarmstadt.informatik.tk.android.kraken.db.DbUserDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbUserSocialProfileDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbDeviceDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleCapabilityDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleInstallationDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbPositionSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbGyroscopeSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbAccelerometerSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMagneticFieldSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMotionActivityEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbWifiConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMobileConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbLoudnessEventDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 1): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        DbUserDao.createTable(db, ifNotExists);
        DbUserSocialProfileDao.createTable(db, ifNotExists);
        DbDeviceDao.createTable(db, ifNotExists);
        DbModuleDao.createTable(db, ifNotExists);
        DbModuleCapabilityDao.createTable(db, ifNotExists);
        DbModuleInstallationDao.createTable(db, ifNotExists);
        DbPositionSensorDao.createTable(db, ifNotExists);
        DbGyroscopeSensorDao.createTable(db, ifNotExists);
        DbAccelerometerSensorDao.createTable(db, ifNotExists);
        DbMagneticFieldSensorDao.createTable(db, ifNotExists);
        DbMotionActivityEventDao.createTable(db, ifNotExists);
        DbConnectionEventDao.createTable(db, ifNotExists);
        DbWifiConnectionEventDao.createTable(db, ifNotExists);
        DbMobileConnectionEventDao.createTable(db, ifNotExists);
        DbLoudnessEventDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        DbUserDao.dropTable(db, ifExists);
        DbUserSocialProfileDao.dropTable(db, ifExists);
        DbDeviceDao.dropTable(db, ifExists);
        DbModuleDao.dropTable(db, ifExists);
        DbModuleCapabilityDao.dropTable(db, ifExists);
        DbModuleInstallationDao.dropTable(db, ifExists);
        DbPositionSensorDao.dropTable(db, ifExists);
        DbGyroscopeSensorDao.dropTable(db, ifExists);
        DbAccelerometerSensorDao.dropTable(db, ifExists);
        DbMagneticFieldSensorDao.dropTable(db, ifExists);
        DbMotionActivityEventDao.dropTable(db, ifExists);
        DbConnectionEventDao.dropTable(db, ifExists);
        DbWifiConnectionEventDao.dropTable(db, ifExists);
        DbMobileConnectionEventDao.dropTable(db, ifExists);
        DbLoudnessEventDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(DbUserDao.class);
        registerDaoClass(DbUserSocialProfileDao.class);
        registerDaoClass(DbDeviceDao.class);
        registerDaoClass(DbModuleDao.class);
        registerDaoClass(DbModuleCapabilityDao.class);
        registerDaoClass(DbModuleInstallationDao.class);
        registerDaoClass(DbPositionSensorDao.class);
        registerDaoClass(DbGyroscopeSensorDao.class);
        registerDaoClass(DbAccelerometerSensorDao.class);
        registerDaoClass(DbMagneticFieldSensorDao.class);
        registerDaoClass(DbMotionActivityEventDao.class);
        registerDaoClass(DbConnectionEventDao.class);
        registerDaoClass(DbWifiConnectionEventDao.class);
        registerDaoClass(DbMobileConnectionEventDao.class);
        registerDaoClass(DbLoudnessEventDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
