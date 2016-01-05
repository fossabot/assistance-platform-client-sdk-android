package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.event;

import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbMotionActivitySensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbMotionActivitySensorDao;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.sensing.sensor.MotionActivitySensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.10.2015
 */
public class MotionActivityEventDaoImpl extends
        CommonEventDaoImpl<DbMotionActivitySensor> implements
        MotionActivityEventDao {

    private static final String TAG = MotionActivityEventDaoImpl.class.getSimpleName();

    private static MotionActivityEventDao INSTANCE;

    private MotionActivityEventDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbMotionActivitySensorDao());
    }

    public static MotionActivityEventDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new MotionActivityEventDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Nullable
    @Override
    public MotionActivitySensorDto convertObject(DbMotionActivitySensor sensor) {

        if (sensor == null) {
            return null;
        }

        MotionActivitySensorDto result = new MotionActivitySensorDto();

        result.setRunning(sensor.getRunning());
        result.setStationary(sensor.getStationary());
        result.setCycling(sensor.getCycling());
        result.setWalking(sensor.getWalking());
        result.setDriving(sensor.getDriving());
        result.setOnFoot(sensor.getOnFoot());
        result.setTilting(sensor.getTilting());
        result.setUnknown(sensor.getUnknown());
        result.setCreated(sensor.getCreated());

        return result;
    }

    @Nullable
    @Override
    public DbMotionActivitySensor get(Long id) {

        if (id == null) {
            return null;
        }

        return dao
                .queryBuilder()
                .where(DbMotionActivitySensorDao.Properties.Id.eq(id))
                .limit(1)
                .build()
                .unique();
    }

    @Override
    public List<DbMotionActivitySensor> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbMotionActivitySensorDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }
}
