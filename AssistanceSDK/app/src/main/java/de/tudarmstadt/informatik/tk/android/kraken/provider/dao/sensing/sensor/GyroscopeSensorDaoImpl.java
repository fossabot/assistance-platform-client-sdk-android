package de.tudarmstadt.informatik.tk.android.kraken.provider.dao.sensing.sensor;

import android.util.Log;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.kraken.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbGyroscopeSensor;
import de.tudarmstadt.informatik.tk.android.kraken.db.DbGyroscopeSensorDao;
import de.tudarmstadt.informatik.tk.android.kraken.interfaces.IDbSensor;
import de.tudarmstadt.informatik.tk.android.kraken.model.api.dto.DtoType;
import de.tudarmstadt.informatik.tk.android.kraken.model.api.dto.sensor.GyroscopeSensorDto;
import de.tudarmstadt.informatik.tk.android.kraken.model.sensor.Sensor;
import de.tudarmstadt.informatik.tk.android.kraken.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.10.2015
 */
public class GyroscopeSensorDaoImpl extends
        CommonEventDaoImpl implements
        GyroscopeSensorDao {

    private static final String TAG = GyroscopeSensorDaoImpl.class.getSimpleName();

    private static GyroscopeSensorDao INSTANCE;

    private DbGyroscopeSensorDao dao;

    private GyroscopeSensorDaoImpl(DaoSession daoSession) {

        if (dao == null) {
            dao = daoSession.getDbGyroscopeSensorDao();
        }
    }

    public static GyroscopeSensorDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new GyroscopeSensorDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Override
    public GyroscopeSensorDto convertObject(DbGyroscopeSensor sensor) {

        if (sensor == null) {
            return null;
        }

        GyroscopeSensorDto result = new GyroscopeSensorDto();

        result.setId(sensor.getId());
        result.setX(sensor.getX());
        result.setY(sensor.getY());
        result.setZ(sensor.getZ());
        result.setAccuracy(sensor.getAccuracy());
        result.setxUncalibratedNoDrift(sensor.getXUncalibratedNoDrift());
        result.setyUncalibratedNoDrift(sensor.getYUncalibratedNoDrift());
        result.setzUncalibratedNoDrift(sensor.getZUncalibratedNoDrift());
        result.setxUncalibratedEstimatedDrift(sensor.getXUncalibratedEstimatedDrift());
        result.setyUncalibratedEstimatedDrift(sensor.getYUncalibratedEstimatedDrift());
        result.setzUncalibratedEstimatedDrift(sensor.getZUncalibratedEstimatedDrift());
        result.setType(DtoType.GYROSCOPE);
        result.setTypeStr(DtoType.getApiName(DtoType.GYROSCOPE));
        result.setCreated(sensor.getCreated());

        return result;
    }

    @Override
    public List<Sensor> convertObjects(List<? extends IDbSensor> dbSensors) {

        List<Sensor> result = new LinkedList<>();

        if (dbSensors != null && !dbSensors.isEmpty()) {

            for (DbGyroscopeSensor dbSensor : (List<DbGyroscopeSensor>) dbSensors) {
                result.add(convertObject(dbSensor));
            }
        }

        return result;
    }

    @Override
    public List<? extends IDbSensor> getAll() {
        return dao
                .queryBuilder()
                .build()
                .list();
    }

    @Override
    public List<? extends IDbSensor> getFirstN(int amount) {

        if (amount <= 0) {
            return Collections.EMPTY_LIST;
        }

        return dao
                .queryBuilder()
                .limit(amount)
                .build()
                .list();
    }

    @Override
    public List<? extends IDbSensor> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.EMPTY_LIST;
        }

        return dao
                .queryBuilder()
                .orderDesc(DbGyroscopeSensorDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }

    @Override
    public long insert(IDbSensor sensor) {

        if (sensor == null) {
            return -1l;
        }

        Log.d(TAG, "Dumping data to db...");

        long result = dao.insertOrReplace((DbGyroscopeSensor) sensor);

        Log.d(TAG, "Finished dumping data");

        return result;
    }

    @Override
    public void delete(List<? extends IDbSensor> events) {

        if (events == null || events.isEmpty()) {
            return;
        }

        dao.deleteInTx((Iterable<DbGyroscopeSensor>) events);
    }
}
