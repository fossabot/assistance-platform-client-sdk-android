package de.tudarmstadt.informatik.tk.android.kraken.model.sensor;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import de.tudarmstadt.informatik.tk.android.kraken.Settings;
import de.tudarmstadt.informatik.tk.android.kraken.RetroServerPushManager;
import de.tudarmstadt.informatik.tk.android.kraken.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.kraken.provider.DbProvider;
import de.tudarmstadt.informatik.tk.android.kraken.interfaces.IDbSensor;
import de.tudarmstadt.informatik.tk.android.kraken.interfaces.IDbUpdatableSensor;
import de.tudarmstadt.informatik.tk.android.kraken.model.enums.EPushType;
import de.tudarmstadt.informatik.tk.android.kraken.service.HarvesterService;
import de.tudarmstadt.informatik.tk.android.kraken.util.DateUtils;

public abstract class AbstractSensor implements ISensor {

    private static final String TAG = AbstractSensor.class.getSimpleName();

    protected Context context;

    protected DaoSession mDaoSession;

    // for caching
    private Method mInsertMethod = null;
    private Method mUpdateMethod;
    protected AbstractDao<?, Long> mDaoObject = null;
    protected Class<? extends IDbSensor> mSensorClass = null;
    private Property m_propTimestamp;

    private boolean isDisabledByUser = false;
    private boolean isDisabledBySystem = false;
    protected long lastDataFlushTimestamp = -1;
    protected int pushIntervallInMin = 0;
    protected boolean isRunning = false;

    private HashMap<String, Boolean> m_mapNewData = new HashMap<String, Boolean>();

    public AbstractSensor(Context context) {
        setContext(context);
//        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(KrakenSdkSettings.PREFERENCES_NAME, Context.MODE_PRIVATE);
//        isDisabledByUser = sharedPreferences.getBoolean(getSensorType().toString() + KrakenSdkSettings.PREFERENCES_SENSOR_DISABLED_BY_USER_POSTFIX, false);
//
//        lastDataFlushTimestamp = sharedPreferences.getLong(getSensorType().toString() + KrakenSdkSettings.PREFERENCES_SENSOR_LAST_PUSHED_TIMESTAMP_POSTFIX, -1);

        if (mDaoSession == null) {
            mDaoSession = DbProvider.getInstance(context).getDaoSession();
        }
    }

    protected void handleDBEntry(IDbSensor dbEntry) {
        handleDBEntry(dbEntry, false, true, true);
    }

    protected void handleDBEntry(IDbSensor dbEntry, boolean bUpdate) {
        handleDBEntry(dbEntry, bUpdate, true, true);
    }

    protected void handleDBEntry(IDbSensor dbEntry, boolean bUpdate, boolean isTimeCreatedNeeded, boolean isSendToHandler) {

        if (isTimeCreatedNeeded) {
            final String now = DateUtils.dateToISO8601String(new Date(), Locale.getDefault());
            dbEntry.setCreated(now);
        }

        // init vars
        if (mDaoSession != null) {

            if (mSensorClass != dbEntry.getClass()) {
                mSensorClass = dbEntry.getClass();
                try {
                    mDaoObject = getDaoEntry(mSensorClass);
                } catch (Exception e) {
                    Log.e(TAG, "Cant get DAO entry! Error: ", e);
                }
                mInsertMethod = null;
                mUpdateMethod = null;
            }

            try {
                if (bUpdate && mUpdateMethod == null)
                    mUpdateMethod = mDaoObject.getClass().getMethod("update", java.lang.Object.class);
                else if (!bUpdate && mInsertMethod == null)
                    mInsertMethod = mDaoObject.getClass().getMethod("insert", java.lang.Object.class);
            } catch (NoSuchMethodException e) {
                Log.e(TAG, "No such method found. Error: ", e);
            }
        }

        try {
            if (!bUpdate && mInsertMethod != null & mDaoObject != null) {
                try {
                    mInsertMethod.invoke(mDaoObject, dbEntry);
                } catch (Exception e) {
                    Log.e(TAG, "Could not insert object in database. Error: ", e);
                }
            } else if (bUpdate && mUpdateMethod != null & mDaoObject != null) {
                mUpdateMethod.invoke(mDaoObject, dbEntry);
            }
            String strClassName = dbEntry.getClass().getName();
            m_mapNewData.put(strClassName, true);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        if (isSendToHandler) {
//            saveDbEntry(dbEntry);
//        }

        RetroServerPushManager.getInstance(context).inform(this);
    }

//    protected void saveDbEntry(IDbSensor dbObject) {
//
//        Bundle data = new Bundle();
//
//        data.putSerializable("sensorType", getSensorType());
//        data.putSerializable("sensorData", dbObject);
//
//        ActivityCommunicator.getInstance().handleData(data);
//    }

    protected AbstractDao<?, Long> getDaoEntry(Class<? extends IDbSensor> sensorClass) throws NoSuchFieldException, IllegalAccessException,
            IllegalArgumentException {

        String strSimpleClassNameOfDBObject = sensorClass.getSimpleName();
        return getDaoEntry(strSimpleClassNameOfDBObject);
    }

    protected AbstractDao<?, Long> getDaoEntry(String strClassNameWithoutDaoPostfix) throws NoSuchFieldException, IllegalAccessException,
            IllegalArgumentException {

        if (mDaoSession == null) {
            mDaoSession = DbProvider.getInstance(context).getDaoSession();
        }

        if (mDaoSession == null) {
            throw new IllegalAccessError("no valid daoSession available!");
        }

        String daoName = Character.toLowerCase(strClassNameWithoutDaoPostfix.charAt(0))
                + (strClassNameWithoutDaoPostfix.length() > 1 ? strClassNameWithoutDaoPostfix.substring(1) : "") + "Dao";
        Field field = DaoSession.class.getDeclaredField(daoName);
        field.setAccessible(true);
        return (AbstractDao<?, Long>) field.get(mDaoSession);
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
        if (context instanceof HarvesterService) {
            setDaoSession(((HarvesterService) context).getDaoSession());
        }
    }

    @Override
    public void setDisabledBySystem(boolean bDisabled) {
        isDisabledBySystem = bDisabled;
    }

    @Override
    public boolean isDisabledBySystem() {
        return isDisabledBySystem;
    }

    @Override
    public void setDisabledByUser(boolean bDisabled) {
        isDisabledByUser = bDisabled;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Settings.PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(getSensorType().toString() + Settings.PREFERENCES_SENSOR_DISABLED_BY_USER_POSTFIX, bDisabled).apply();
    }

    @Override
    public boolean isDisabledByUser() {
        return isDisabledByUser;
    }

    @Override
    public boolean flushData(DaoSession daoSession) throws JSONException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {

        String strClassName = getSensorType().getSensorName();
        boolean result = flushData(daoSession, strClassName);

        return result;
    }

    public boolean flushData(final DaoSession daoSession, String strFullQualifiedBeanClassName) throws JSONException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        long longTimestamp = Calendar.getInstance().getTimeInMillis();

        // caching is important, because reflections are not really
        // performant
        if (mSensorClass == null || !mSensorClass.getName().equals(strFullQualifiedBeanClassName)) {
            // getting database bean
            mSensorClass = (Class<? extends IDbSensor>) Class.forName(strFullQualifiedBeanClassName);
            // get the *Dao object for doing a query
            mDaoObject = getDaoEntry(mSensorClass);
            m_propTimestamp = null;
        }

        QueryBuilder<? extends IDbSensor> qb = (QueryBuilder<? extends IDbSensor>) mDaoObject.queryBuilder();

        Query<? extends IDbSensor> query;
        try {
            query = getDbQuery(mSensorClass, longTimestamp, qb);
        } catch (Exception e) {
            m_propTimestamp = null;
            query = getDbQuery(mSensorClass, longTimestamp, qb);
        }

        // set timestamp of last query
        lastDataFlushTimestamp = longTimestamp;

        List<? extends IDbSensor> list = query.list();
        if (list.size() > 0) {
            return true;
        }

        return false;
    }

    @Override
    public List<Sensor> flushDataRetro() {
        String strClassName = getSensorType().getSensorName();
        return flushDataRetro(strClassName);
    }

    @Override
    public List<Sensor> flushDataRetro(String strFullQualifiedBeanClassName) {

        HarvesterService service = HarvesterService.getInstance();
        Boolean bDataAvailable = m_mapNewData.get(strFullQualifiedBeanClassName);
        if (service == null || bDataAvailable == null || !bDataAvailable)
            return null;

        long longTimestamp = Calendar.getInstance().getTimeInMillis();

        try {
            // caching is important, because reflections are not really
            // performant
            if (mSensorClass == null || !mSensorClass.getName().equals(strFullQualifiedBeanClassName)) {
                // getting database bean
                mSensorClass = (Class<? extends IDbSensor>) Class.forName(strFullQualifiedBeanClassName);
                // get the *Dao object for doing a query
                mDaoObject = getDaoEntry(mSensorClass);
                m_propTimestamp = null;
            }

            QueryBuilder<? extends IDbSensor> qb = (QueryBuilder<? extends IDbSensor>) mDaoObject.queryBuilder();

            Query<? extends IDbSensor> query;
            try {
                query = getDbQuery(mSensorClass, longTimestamp, qb);
            } catch (Exception e) {
                m_propTimestamp = null;
                query = getDbQuery(mSensorClass, longTimestamp, qb);
            }

            // set timestamp of last query
            lastDataFlushTimestamp = longTimestamp;
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Settings.PREFERENCES_NAME, Context.MODE_PRIVATE);
            sharedPreferences.edit()
                    .putLong(strFullQualifiedBeanClassName + Settings.PREFERENCES_SENSOR_LAST_PUSHED_TIMESTAMP_POSTFIX, lastDataFlushTimestamp).apply();

            // handle every entry and convert it to Json
            List<? extends IDbSensor> list = query.list();
            if (list.size() > 0) {

                LinkedList<IDbSensor> sensorData = new LinkedList<>();
                for (IDbSensor sensor : list) {
                    sensorData.add(sensor);
                    //TODO: remove id? why?
                }
                List<Sensor> events = new LinkedList<>();

                m_mapNewData.put(strFullQualifiedBeanClassName, false);
                return events;
            }
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Query<? extends IDbSensor> getDbQuery(Class<? extends IDbSensor> sensorClass, long longTimestamp, QueryBuilder<? extends IDbSensor> qb)
            throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        if (m_propTimestamp == null) {
            m_propTimestamp = getPropertiesArgument(sensorClass, "Timestamp");
        }

        Query<? extends IDbSensor> query = qb.where(m_propTimestamp.gt(lastDataFlushTimestamp), m_propTimestamp.le(longTimestamp)).build();
        return query;
    }

    /**
     * This method gets the Property field of the corresponding *Dao class of
     * the database bean. This is needed for filter by an Property in DB queues.
     *
     * @param sensorClass
     * @param strArgumentName
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    protected Property getPropertiesArgument(Class<? extends IDbSensor> sensorClass, String strArgumentName) throws ClassNotFoundException,
            NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Class<?> cl = Class.forName(sensorClass.getName() + "Dao$Properties");
        Field field = cl.getField(strArgumentName);
        return (Property) field.get(null);
    }

    @Override
    public void removeDataFromDb(List<? extends IDbSensor> liSensorData, String strFullqualifiedSensorClassName) {

        try {
//            if (strFullqualifiedSensorClassName == null)
//                strFullqualifiedSensorClassName = getSensorType().getFullqualifiedDatabaseClassName();

            // caching is important, because reflections are not really
            // performant
            if (mSensorClass == null || !mSensorClass.getName().equals(strFullqualifiedSensorClassName)) {
                // getting database bean
                mSensorClass = (Class<? extends IDbSensor>) Class.forName(strFullqualifiedSensorClassName);
                // get the *Dao object for doing a query
                mDaoObject = getDaoEntry(mSensorClass);
            }

            // We assume that every entry in this list is of the same type!
            if (liSensorData != null && liSensorData.size() > 0) {
                // UpdatableSensors won't be simply deleted from database. May
                // be we have to update the flags!
                if (liSensorData.get(0) instanceof IDbUpdatableSensor) {
                    List<IDbUpdatableSensor> liDelete = new LinkedList<IDbUpdatableSensor>();
                    List<IDbUpdatableSensor> liUpdate = new LinkedList<IDbUpdatableSensor>();
                    for (IDbSensor data : liSensorData) {
                        IDbUpdatableSensor event = (IDbUpdatableSensor) data;
                        if (event.getIsDeleted())
                            liDelete.add(event);
                        else {
                            event.setIsNew(false);
                            event.setIsUpdated(false);
                            liUpdate.add(event);
                        }
                    }
                    mDaoObject.updateInTx((Iterable) liUpdate);
                    mDaoObject.deleteInTx((Iterable) liDelete);
                } else {
                    mDaoObject.deleteInTx((Iterable) liSensorData);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EPushType getPushType() {
        return EPushType.WLAN_ONLY;
    }

    public void configure(JSONObject json) {
        // stop sensor if necessary
        boolean bWasRunning = isRunning();
        if (bWasRunning)
            stopSensor();

        configure(json, this.getClass());

        // restart sensor if it was running
        if (bWasRunning) {
            startSensor();
        }
    }

    private void configure(JSONObject json, Class<?> configurationClass) {
        try {
            // get the Configuration-enum with all available configurations
            String strClassName = configurationClass.getName() + ("$Configuration");

            Class<?> classConfiguration = Class.forName(strClassName);

            // these are all available configuration parameters. check every of
            // them!
            Field[] fields = classConfiguration.getFields();
            for (Field configurationField : fields) {

                // the current parameter name
                String strConfigurationName = configurationField.getName();

                // check if there's a configuration parameter in json
                if (json.has(strConfigurationName)) {
                    try {

                        // this is the REAL parameter (not only the field which
                        // is declared in the enum
                        Field configurationAttribute = configurationClass.getDeclaredField(strConfigurationName);

                        try {
                            // set the parameter accessible and set the value
                            configurationAttribute.setAccessible(true);

                            if ("int".equals(configurationAttribute.getType().toString()))
                                configurationAttribute.set(this, json.getInt(strConfigurationName));
                            else if ("String".equals(configurationAttribute.getType().toString()))
                                configurationAttribute.set(this, json.getString(strConfigurationName));

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }

                }
            }

        } catch (ClassNotFoundException e) {

        }

        if (configurationClass != AbstractSensor.class) {
            Class<?> superclass = configurationClass.getSuperclass();
            if (superclass != null && superclass != Object.class)
                configure(json, superclass);
        }
    }

    @Override
    public int getPushIntervalInMin() {
        return pushIntervallInMin;
    }

    @Override
    public void setPushIntervalInMin(int intInterval) {
        pushIntervallInMin = intInterval;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void setDaoSession(DaoSession daoSession) {
        this.mDaoSession = daoSession;
    }

    protected abstract void dumpData();
}
