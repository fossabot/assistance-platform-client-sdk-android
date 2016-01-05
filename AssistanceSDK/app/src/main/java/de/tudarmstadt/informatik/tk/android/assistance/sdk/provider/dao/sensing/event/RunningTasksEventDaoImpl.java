package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.event;

import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbRunningTasksSensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbRunningTasksSensorDao;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.SensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.sensing.sensor.RunningTaskSensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 24.11.2015
 */
public class RunningTasksEventDaoImpl extends
        CommonEventDaoImpl<DbRunningTasksSensor> implements
        RunningTasksEventDao {

    private static final String TAG = RunningTasksEventDaoImpl.class.getSimpleName();

    private static RunningTasksEventDao INSTANCE;

    private RunningTasksEventDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbRunningTasksSensorDao());
    }

    public static RunningTasksEventDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new RunningTasksEventDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Nullable
    @Override
    public SensorDto convertObject(DbRunningTasksSensor sensor) {

        if (sensor == null) {
            return null;
        }

        RunningTaskSensorDto result = new RunningTaskSensorDto();

        result.setName(sensor.getName());
        result.setStackPosition(sensor.getStackPosition());
        result.setCreated(sensor.getCreated());

        return result;
    }

    @Nullable
    @Override
    public DbRunningTasksSensor get(Long id) {

        if (id == null) {
            return null;
        }

        return dao
                .queryBuilder()
                .where(DbRunningTasksSensorDao.Properties.Id.eq(id))
                .limit(1)
                .build()
                .unique();
    }

    @Override
    public List<DbRunningTasksSensor> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbRunningTasksSensorDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }
}
