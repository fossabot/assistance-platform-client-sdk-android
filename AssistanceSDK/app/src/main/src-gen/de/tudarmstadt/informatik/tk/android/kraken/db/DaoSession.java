package de.tudarmstadt.informatik.tk.android.kraken.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.android.kraken.db.DbUser;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbUserSocialProfile;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbDevice;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModule;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleCapability;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleInstallation;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbNews;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbPositionSensor;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbGyroscopeSensor;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbAccelerometerSensor;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMagneticFieldSensor;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMotionActivityEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbConnectionEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbWifiConnectionEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMobileConnectionEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbLoudnessEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbForegroundEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbLightSensor;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbRingtoneEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbRunningProcessesEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbRunningServicesEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbRunningTasksEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbAccountReaderEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbNetworkTrafficEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbBrowserHistoryEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbCallLogEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbCalendarEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbCalendarReminderEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbContactEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbContactNumberEvent;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbContactEmailEvent;

import de.tudarmstadt.informatik.tk.android.kraken.db.DbUserDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbUserSocialProfileDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbDeviceDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleCapabilityDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbModuleInstallationDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbNewsDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbPositionSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbGyroscopeSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbAccelerometerSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMagneticFieldSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMotionActivityEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbWifiConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbMobileConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbLoudnessEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbForegroundEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbLightSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbRingtoneEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbRunningProcessesEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbRunningServicesEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbRunningTasksEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbAccountReaderEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbNetworkTrafficEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbBrowserHistoryEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbCallLogEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbCalendarEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbCalendarReminderEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbContactEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbContactNumberEventDao;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbContactEmailEventDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dbUserDaoConfig;
    private final DaoConfig dbUserSocialProfileDaoConfig;
    private final DaoConfig dbDeviceDaoConfig;
    private final DaoConfig dbModuleDaoConfig;
    private final DaoConfig dbModuleCapabilityDaoConfig;
    private final DaoConfig dbModuleInstallationDaoConfig;
    private final DaoConfig dbNewsDaoConfig;
    private final DaoConfig dbPositionSensorDaoConfig;
    private final DaoConfig dbGyroscopeSensorDaoConfig;
    private final DaoConfig dbAccelerometerSensorDaoConfig;
    private final DaoConfig dbMagneticFieldSensorDaoConfig;
    private final DaoConfig dbMotionActivityEventDaoConfig;
    private final DaoConfig dbConnectionEventDaoConfig;
    private final DaoConfig dbWifiConnectionEventDaoConfig;
    private final DaoConfig dbMobileConnectionEventDaoConfig;
    private final DaoConfig dbLoudnessEventDaoConfig;
    private final DaoConfig dbForegroundEventDaoConfig;
    private final DaoConfig dbLightSensorDaoConfig;
    private final DaoConfig dbRingtoneEventDaoConfig;
    private final DaoConfig dbRunningProcessesEventDaoConfig;
    private final DaoConfig dbRunningServicesEventDaoConfig;
    private final DaoConfig dbRunningTasksEventDaoConfig;
    private final DaoConfig dbAccountReaderEventDaoConfig;
    private final DaoConfig dbNetworkTrafficEventDaoConfig;
    private final DaoConfig dbBrowserHistoryEventDaoConfig;
    private final DaoConfig dbCallLogEventDaoConfig;
    private final DaoConfig dbCalendarEventDaoConfig;
    private final DaoConfig dbCalendarReminderEventDaoConfig;
    private final DaoConfig dbContactEventDaoConfig;
    private final DaoConfig dbContactNumberEventDaoConfig;
    private final DaoConfig dbContactEmailEventDaoConfig;

    private final DbUserDao dbUserDao;
    private final DbUserSocialProfileDao dbUserSocialProfileDao;
    private final DbDeviceDao dbDeviceDao;
    private final DbModuleDao dbModuleDao;
    private final DbModuleCapabilityDao dbModuleCapabilityDao;
    private final DbModuleInstallationDao dbModuleInstallationDao;
    private final DbNewsDao dbNewsDao;
    private final DbPositionSensorDao dbPositionSensorDao;
    private final DbGyroscopeSensorDao dbGyroscopeSensorDao;
    private final DbAccelerometerSensorDao dbAccelerometerSensorDao;
    private final DbMagneticFieldSensorDao dbMagneticFieldSensorDao;
    private final DbMotionActivityEventDao dbMotionActivityEventDao;
    private final DbConnectionEventDao dbConnectionEventDao;
    private final DbWifiConnectionEventDao dbWifiConnectionEventDao;
    private final DbMobileConnectionEventDao dbMobileConnectionEventDao;
    private final DbLoudnessEventDao dbLoudnessEventDao;
    private final DbForegroundEventDao dbForegroundEventDao;
    private final DbLightSensorDao dbLightSensorDao;
    private final DbRingtoneEventDao dbRingtoneEventDao;
    private final DbRunningProcessesEventDao dbRunningProcessesEventDao;
    private final DbRunningServicesEventDao dbRunningServicesEventDao;
    private final DbRunningTasksEventDao dbRunningTasksEventDao;
    private final DbAccountReaderEventDao dbAccountReaderEventDao;
    private final DbNetworkTrafficEventDao dbNetworkTrafficEventDao;
    private final DbBrowserHistoryEventDao dbBrowserHistoryEventDao;
    private final DbCallLogEventDao dbCallLogEventDao;
    private final DbCalendarEventDao dbCalendarEventDao;
    private final DbCalendarReminderEventDao dbCalendarReminderEventDao;
    private final DbContactEventDao dbContactEventDao;
    private final DbContactNumberEventDao dbContactNumberEventDao;
    private final DbContactEmailEventDao dbContactEmailEventDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dbUserDaoConfig = daoConfigMap.get(DbUserDao.class).clone();
        dbUserDaoConfig.initIdentityScope(type);

        dbUserSocialProfileDaoConfig = daoConfigMap.get(DbUserSocialProfileDao.class).clone();
        dbUserSocialProfileDaoConfig.initIdentityScope(type);

        dbDeviceDaoConfig = daoConfigMap.get(DbDeviceDao.class).clone();
        dbDeviceDaoConfig.initIdentityScope(type);

        dbModuleDaoConfig = daoConfigMap.get(DbModuleDao.class).clone();
        dbModuleDaoConfig.initIdentityScope(type);

        dbModuleCapabilityDaoConfig = daoConfigMap.get(DbModuleCapabilityDao.class).clone();
        dbModuleCapabilityDaoConfig.initIdentityScope(type);

        dbModuleInstallationDaoConfig = daoConfigMap.get(DbModuleInstallationDao.class).clone();
        dbModuleInstallationDaoConfig.initIdentityScope(type);

        dbNewsDaoConfig = daoConfigMap.get(DbNewsDao.class).clone();
        dbNewsDaoConfig.initIdentityScope(type);

        dbPositionSensorDaoConfig = daoConfigMap.get(DbPositionSensorDao.class).clone();
        dbPositionSensorDaoConfig.initIdentityScope(type);

        dbGyroscopeSensorDaoConfig = daoConfigMap.get(DbGyroscopeSensorDao.class).clone();
        dbGyroscopeSensorDaoConfig.initIdentityScope(type);

        dbAccelerometerSensorDaoConfig = daoConfigMap.get(DbAccelerometerSensorDao.class).clone();
        dbAccelerometerSensorDaoConfig.initIdentityScope(type);

        dbMagneticFieldSensorDaoConfig = daoConfigMap.get(DbMagneticFieldSensorDao.class).clone();
        dbMagneticFieldSensorDaoConfig.initIdentityScope(type);

        dbMotionActivityEventDaoConfig = daoConfigMap.get(DbMotionActivityEventDao.class).clone();
        dbMotionActivityEventDaoConfig.initIdentityScope(type);

        dbConnectionEventDaoConfig = daoConfigMap.get(DbConnectionEventDao.class).clone();
        dbConnectionEventDaoConfig.initIdentityScope(type);

        dbWifiConnectionEventDaoConfig = daoConfigMap.get(DbWifiConnectionEventDao.class).clone();
        dbWifiConnectionEventDaoConfig.initIdentityScope(type);

        dbMobileConnectionEventDaoConfig = daoConfigMap.get(DbMobileConnectionEventDao.class).clone();
        dbMobileConnectionEventDaoConfig.initIdentityScope(type);

        dbLoudnessEventDaoConfig = daoConfigMap.get(DbLoudnessEventDao.class).clone();
        dbLoudnessEventDaoConfig.initIdentityScope(type);

        dbForegroundEventDaoConfig = daoConfigMap.get(DbForegroundEventDao.class).clone();
        dbForegroundEventDaoConfig.initIdentityScope(type);

        dbLightSensorDaoConfig = daoConfigMap.get(DbLightSensorDao.class).clone();
        dbLightSensorDaoConfig.initIdentityScope(type);

        dbRingtoneEventDaoConfig = daoConfigMap.get(DbRingtoneEventDao.class).clone();
        dbRingtoneEventDaoConfig.initIdentityScope(type);

        dbRunningProcessesEventDaoConfig = daoConfigMap.get(DbRunningProcessesEventDao.class).clone();
        dbRunningProcessesEventDaoConfig.initIdentityScope(type);

        dbRunningServicesEventDaoConfig = daoConfigMap.get(DbRunningServicesEventDao.class).clone();
        dbRunningServicesEventDaoConfig.initIdentityScope(type);

        dbRunningTasksEventDaoConfig = daoConfigMap.get(DbRunningTasksEventDao.class).clone();
        dbRunningTasksEventDaoConfig.initIdentityScope(type);

        dbAccountReaderEventDaoConfig = daoConfigMap.get(DbAccountReaderEventDao.class).clone();
        dbAccountReaderEventDaoConfig.initIdentityScope(type);

        dbNetworkTrafficEventDaoConfig = daoConfigMap.get(DbNetworkTrafficEventDao.class).clone();
        dbNetworkTrafficEventDaoConfig.initIdentityScope(type);

        dbBrowserHistoryEventDaoConfig = daoConfigMap.get(DbBrowserHistoryEventDao.class).clone();
        dbBrowserHistoryEventDaoConfig.initIdentityScope(type);

        dbCallLogEventDaoConfig = daoConfigMap.get(DbCallLogEventDao.class).clone();
        dbCallLogEventDaoConfig.initIdentityScope(type);

        dbCalendarEventDaoConfig = daoConfigMap.get(DbCalendarEventDao.class).clone();
        dbCalendarEventDaoConfig.initIdentityScope(type);

        dbCalendarReminderEventDaoConfig = daoConfigMap.get(DbCalendarReminderEventDao.class).clone();
        dbCalendarReminderEventDaoConfig.initIdentityScope(type);

        dbContactEventDaoConfig = daoConfigMap.get(DbContactEventDao.class).clone();
        dbContactEventDaoConfig.initIdentityScope(type);

        dbContactNumberEventDaoConfig = daoConfigMap.get(DbContactNumberEventDao.class).clone();
        dbContactNumberEventDaoConfig.initIdentityScope(type);

        dbContactEmailEventDaoConfig = daoConfigMap.get(DbContactEmailEventDao.class).clone();
        dbContactEmailEventDaoConfig.initIdentityScope(type);

        dbUserDao = new DbUserDao(dbUserDaoConfig, this);
        dbUserSocialProfileDao = new DbUserSocialProfileDao(dbUserSocialProfileDaoConfig, this);
        dbDeviceDao = new DbDeviceDao(dbDeviceDaoConfig, this);
        dbModuleDao = new DbModuleDao(dbModuleDaoConfig, this);
        dbModuleCapabilityDao = new DbModuleCapabilityDao(dbModuleCapabilityDaoConfig, this);
        dbModuleInstallationDao = new DbModuleInstallationDao(dbModuleInstallationDaoConfig, this);
        dbNewsDao = new DbNewsDao(dbNewsDaoConfig, this);
        dbPositionSensorDao = new DbPositionSensorDao(dbPositionSensorDaoConfig, this);
        dbGyroscopeSensorDao = new DbGyroscopeSensorDao(dbGyroscopeSensorDaoConfig, this);
        dbAccelerometerSensorDao = new DbAccelerometerSensorDao(dbAccelerometerSensorDaoConfig, this);
        dbMagneticFieldSensorDao = new DbMagneticFieldSensorDao(dbMagneticFieldSensorDaoConfig, this);
        dbMotionActivityEventDao = new DbMotionActivityEventDao(dbMotionActivityEventDaoConfig, this);
        dbConnectionEventDao = new DbConnectionEventDao(dbConnectionEventDaoConfig, this);
        dbWifiConnectionEventDao = new DbWifiConnectionEventDao(dbWifiConnectionEventDaoConfig, this);
        dbMobileConnectionEventDao = new DbMobileConnectionEventDao(dbMobileConnectionEventDaoConfig, this);
        dbLoudnessEventDao = new DbLoudnessEventDao(dbLoudnessEventDaoConfig, this);
        dbForegroundEventDao = new DbForegroundEventDao(dbForegroundEventDaoConfig, this);
        dbLightSensorDao = new DbLightSensorDao(dbLightSensorDaoConfig, this);
        dbRingtoneEventDao = new DbRingtoneEventDao(dbRingtoneEventDaoConfig, this);
        dbRunningProcessesEventDao = new DbRunningProcessesEventDao(dbRunningProcessesEventDaoConfig, this);
        dbRunningServicesEventDao = new DbRunningServicesEventDao(dbRunningServicesEventDaoConfig, this);
        dbRunningTasksEventDao = new DbRunningTasksEventDao(dbRunningTasksEventDaoConfig, this);
        dbAccountReaderEventDao = new DbAccountReaderEventDao(dbAccountReaderEventDaoConfig, this);
        dbNetworkTrafficEventDao = new DbNetworkTrafficEventDao(dbNetworkTrafficEventDaoConfig, this);
        dbBrowserHistoryEventDao = new DbBrowserHistoryEventDao(dbBrowserHistoryEventDaoConfig, this);
        dbCallLogEventDao = new DbCallLogEventDao(dbCallLogEventDaoConfig, this);
        dbCalendarEventDao = new DbCalendarEventDao(dbCalendarEventDaoConfig, this);
        dbCalendarReminderEventDao = new DbCalendarReminderEventDao(dbCalendarReminderEventDaoConfig, this);
        dbContactEventDao = new DbContactEventDao(dbContactEventDaoConfig, this);
        dbContactNumberEventDao = new DbContactNumberEventDao(dbContactNumberEventDaoConfig, this);
        dbContactEmailEventDao = new DbContactEmailEventDao(dbContactEmailEventDaoConfig, this);

        registerDao(DbUser.class, dbUserDao);
        registerDao(DbUserSocialProfile.class, dbUserSocialProfileDao);
        registerDao(DbDevice.class, dbDeviceDao);
        registerDao(DbModule.class, dbModuleDao);
        registerDao(DbModuleCapability.class, dbModuleCapabilityDao);
        registerDao(DbModuleInstallation.class, dbModuleInstallationDao);
        registerDao(DbNews.class, dbNewsDao);
        registerDao(DbPositionSensor.class, dbPositionSensorDao);
        registerDao(DbGyroscopeSensor.class, dbGyroscopeSensorDao);
        registerDao(DbAccelerometerSensor.class, dbAccelerometerSensorDao);
        registerDao(DbMagneticFieldSensor.class, dbMagneticFieldSensorDao);
        registerDao(DbMotionActivityEvent.class, dbMotionActivityEventDao);
        registerDao(DbConnectionEvent.class, dbConnectionEventDao);
        registerDao(DbWifiConnectionEvent.class, dbWifiConnectionEventDao);
        registerDao(DbMobileConnectionEvent.class, dbMobileConnectionEventDao);
        registerDao(DbLoudnessEvent.class, dbLoudnessEventDao);
        registerDao(DbForegroundEvent.class, dbForegroundEventDao);
        registerDao(DbLightSensor.class, dbLightSensorDao);
        registerDao(DbRingtoneEvent.class, dbRingtoneEventDao);
        registerDao(DbRunningProcessesEvent.class, dbRunningProcessesEventDao);
        registerDao(DbRunningServicesEvent.class, dbRunningServicesEventDao);
        registerDao(DbRunningTasksEvent.class, dbRunningTasksEventDao);
        registerDao(DbAccountReaderEvent.class, dbAccountReaderEventDao);
        registerDao(DbNetworkTrafficEvent.class, dbNetworkTrafficEventDao);
        registerDao(DbBrowserHistoryEvent.class, dbBrowserHistoryEventDao);
        registerDao(DbCallLogEvent.class, dbCallLogEventDao);
        registerDao(DbCalendarEvent.class, dbCalendarEventDao);
        registerDao(DbCalendarReminderEvent.class, dbCalendarReminderEventDao);
        registerDao(DbContactEvent.class, dbContactEventDao);
        registerDao(DbContactNumberEvent.class, dbContactNumberEventDao);
        registerDao(DbContactEmailEvent.class, dbContactEmailEventDao);
    }
    
    public void clear() {
        dbUserDaoConfig.getIdentityScope().clear();
        dbUserSocialProfileDaoConfig.getIdentityScope().clear();
        dbDeviceDaoConfig.getIdentityScope().clear();
        dbModuleDaoConfig.getIdentityScope().clear();
        dbModuleCapabilityDaoConfig.getIdentityScope().clear();
        dbModuleInstallationDaoConfig.getIdentityScope().clear();
        dbNewsDaoConfig.getIdentityScope().clear();
        dbPositionSensorDaoConfig.getIdentityScope().clear();
        dbGyroscopeSensorDaoConfig.getIdentityScope().clear();
        dbAccelerometerSensorDaoConfig.getIdentityScope().clear();
        dbMagneticFieldSensorDaoConfig.getIdentityScope().clear();
        dbMotionActivityEventDaoConfig.getIdentityScope().clear();
        dbConnectionEventDaoConfig.getIdentityScope().clear();
        dbWifiConnectionEventDaoConfig.getIdentityScope().clear();
        dbMobileConnectionEventDaoConfig.getIdentityScope().clear();
        dbLoudnessEventDaoConfig.getIdentityScope().clear();
        dbForegroundEventDaoConfig.getIdentityScope().clear();
        dbLightSensorDaoConfig.getIdentityScope().clear();
        dbRingtoneEventDaoConfig.getIdentityScope().clear();
        dbRunningProcessesEventDaoConfig.getIdentityScope().clear();
        dbRunningServicesEventDaoConfig.getIdentityScope().clear();
        dbRunningTasksEventDaoConfig.getIdentityScope().clear();
        dbAccountReaderEventDaoConfig.getIdentityScope().clear();
        dbNetworkTrafficEventDaoConfig.getIdentityScope().clear();
        dbBrowserHistoryEventDaoConfig.getIdentityScope().clear();
        dbCallLogEventDaoConfig.getIdentityScope().clear();
        dbCalendarEventDaoConfig.getIdentityScope().clear();
        dbCalendarReminderEventDaoConfig.getIdentityScope().clear();
        dbContactEventDaoConfig.getIdentityScope().clear();
        dbContactNumberEventDaoConfig.getIdentityScope().clear();
        dbContactEmailEventDaoConfig.getIdentityScope().clear();
    }

    public DbUserDao getDbUserDao() {
        return dbUserDao;
    }

    public DbUserSocialProfileDao getDbUserSocialProfileDao() {
        return dbUserSocialProfileDao;
    }

    public DbDeviceDao getDbDeviceDao() {
        return dbDeviceDao;
    }

    public DbModuleDao getDbModuleDao() {
        return dbModuleDao;
    }

    public DbModuleCapabilityDao getDbModuleCapabilityDao() {
        return dbModuleCapabilityDao;
    }

    public DbModuleInstallationDao getDbModuleInstallationDao() {
        return dbModuleInstallationDao;
    }

    public DbNewsDao getDbNewsDao() {
        return dbNewsDao;
    }

    public DbPositionSensorDao getDbPositionSensorDao() {
        return dbPositionSensorDao;
    }

    public DbGyroscopeSensorDao getDbGyroscopeSensorDao() {
        return dbGyroscopeSensorDao;
    }

    public DbAccelerometerSensorDao getDbAccelerometerSensorDao() {
        return dbAccelerometerSensorDao;
    }

    public DbMagneticFieldSensorDao getDbMagneticFieldSensorDao() {
        return dbMagneticFieldSensorDao;
    }

    public DbMotionActivityEventDao getDbMotionActivityEventDao() {
        return dbMotionActivityEventDao;
    }

    public DbConnectionEventDao getDbConnectionEventDao() {
        return dbConnectionEventDao;
    }

    public DbWifiConnectionEventDao getDbWifiConnectionEventDao() {
        return dbWifiConnectionEventDao;
    }

    public DbMobileConnectionEventDao getDbMobileConnectionEventDao() {
        return dbMobileConnectionEventDao;
    }

    public DbLoudnessEventDao getDbLoudnessEventDao() {
        return dbLoudnessEventDao;
    }

    public DbForegroundEventDao getDbForegroundEventDao() {
        return dbForegroundEventDao;
    }

    public DbLightSensorDao getDbLightSensorDao() {
        return dbLightSensorDao;
    }

    public DbRingtoneEventDao getDbRingtoneEventDao() {
        return dbRingtoneEventDao;
    }

    public DbRunningProcessesEventDao getDbRunningProcessesEventDao() {
        return dbRunningProcessesEventDao;
    }

    public DbRunningServicesEventDao getDbRunningServicesEventDao() {
        return dbRunningServicesEventDao;
    }

    public DbRunningTasksEventDao getDbRunningTasksEventDao() {
        return dbRunningTasksEventDao;
    }

    public DbAccountReaderEventDao getDbAccountReaderEventDao() {
        return dbAccountReaderEventDao;
    }

    public DbNetworkTrafficEventDao getDbNetworkTrafficEventDao() {
        return dbNetworkTrafficEventDao;
    }

    public DbBrowserHistoryEventDao getDbBrowserHistoryEventDao() {
        return dbBrowserHistoryEventDao;
    }

    public DbCallLogEventDao getDbCallLogEventDao() {
        return dbCallLogEventDao;
    }

    public DbCalendarEventDao getDbCalendarEventDao() {
        return dbCalendarEventDao;
    }

    public DbCalendarReminderEventDao getDbCalendarReminderEventDao() {
        return dbCalendarReminderEventDao;
    }

    public DbContactEventDao getDbContactEventDao() {
        return dbContactEventDao;
    }

    public DbContactNumberEventDao getDbContactNumberEventDao() {
        return dbContactNumberEventDao;
    }

    public DbContactEmailEventDao getDbContactEmailEventDao() {
        return dbContactEmailEventDao;
    }

}
