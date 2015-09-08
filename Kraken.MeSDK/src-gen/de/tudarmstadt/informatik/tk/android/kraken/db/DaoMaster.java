package de.tudarmstadt.informatik.tk.android.kraken.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import de.tudarmstadt.informatik.tk.android.kraken.db.UserDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.UserSocialProfileDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.LoginDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DeviceDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.ModuleDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.ModuleCapabilityDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.ModuleInstallationDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.PositionSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.GyroscopeSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.AccelerometerSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.MagneticFieldSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.MotionActivityEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.ConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.WifiConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.MobileConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.LoudnessEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.MagneticFieldUncalibratedSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.GyroscopeUncalibratedSensorDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 12): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 12;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        UserDao.createTable(db, ifNotExists);
        UserSocialProfileDao.createTable(db, ifNotExists);
        LoginDao.createTable(db, ifNotExists);
        DeviceDao.createTable(db, ifNotExists);
        ModuleDao.createTable(db, ifNotExists);
        ModuleCapabilityDao.createTable(db, ifNotExists);
        ModuleInstallationDao.createTable(db, ifNotExists);
        PositionSensorDao.createTable(db, ifNotExists);
        GyroscopeSensorDao.createTable(db, ifNotExists);
        AccelerometerSensorDao.createTable(db, ifNotExists);
        MagneticFieldSensorDao.createTable(db, ifNotExists);
        MotionActivityEventDao.createTable(db, ifNotExists);
        ConnectionEventDao.createTable(db, ifNotExists);
        WifiConnectionEventDao.createTable(db, ifNotExists);
        MobileConnectionEventDao.createTable(db, ifNotExists);
        LoudnessEventDao.createTable(db, ifNotExists);
        MagneticFieldUncalibratedSensorDao.createTable(db, ifNotExists);
        GyroscopeUncalibratedSensorDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        UserDao.dropTable(db, ifExists);
        UserSocialProfileDao.dropTable(db, ifExists);
        LoginDao.dropTable(db, ifExists);
        DeviceDao.dropTable(db, ifExists);
        ModuleDao.dropTable(db, ifExists);
        ModuleCapabilityDao.dropTable(db, ifExists);
        ModuleInstallationDao.dropTable(db, ifExists);
        PositionSensorDao.dropTable(db, ifExists);
        GyroscopeSensorDao.dropTable(db, ifExists);
        AccelerometerSensorDao.dropTable(db, ifExists);
        MagneticFieldSensorDao.dropTable(db, ifExists);
        MotionActivityEventDao.dropTable(db, ifExists);
        ConnectionEventDao.dropTable(db, ifExists);
        WifiConnectionEventDao.dropTable(db, ifExists);
        MobileConnectionEventDao.dropTable(db, ifExists);
        LoudnessEventDao.dropTable(db, ifExists);
        MagneticFieldUncalibratedSensorDao.dropTable(db, ifExists);
        GyroscopeUncalibratedSensorDao.dropTable(db, ifExists);
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
        registerDaoClass(UserDao.class);
        registerDaoClass(UserSocialProfileDao.class);
        registerDaoClass(LoginDao.class);
        registerDaoClass(DeviceDao.class);
        registerDaoClass(ModuleDao.class);
        registerDaoClass(ModuleCapabilityDao.class);
        registerDaoClass(ModuleInstallationDao.class);
        registerDaoClass(PositionSensorDao.class);
        registerDaoClass(GyroscopeSensorDao.class);
        registerDaoClass(AccelerometerSensorDao.class);
        registerDaoClass(MagneticFieldSensorDao.class);
        registerDaoClass(MotionActivityEventDao.class);
        registerDaoClass(ConnectionEventDao.class);
        registerDaoClass(WifiConnectionEventDao.class);
        registerDaoClass(MobileConnectionEventDao.class);
        registerDaoClass(LoudnessEventDao.class);
        registerDaoClass(MagneticFieldUncalibratedSensorDao.class);
        registerDaoClass(GyroscopeUncalibratedSensorDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
