package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.event;

import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbAccountReaderSensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbAccountReaderSensorDao;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.SensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.sensing.sensor.AccountReaderSensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 24.11.2015
 */
public class AccountReaderEventDaoImpl extends
        CommonEventDaoImpl<DbAccountReaderSensor> implements
        AccountReaderEventDao {

    private static final String TAG = AccountReaderEventDaoImpl.class.getSimpleName();

    private static AccountReaderEventDao INSTANCE;

    private AccountReaderEventDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbAccountReaderSensorDao());
    }

    public static AccountReaderEventDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new AccountReaderEventDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Nullable
    @Override
    public SensorDto convertObject(DbAccountReaderSensor sensor) {

        if (sensor == null) {
            return null;
        }

        AccountReaderSensorDto result = new AccountReaderSensorDto();

        result.setTypes(sensor.getTypes());
        result.setCreated(sensor.getCreated());

        return result;
    }

    @Nullable
    @Override
    public DbAccountReaderSensor get(Long id) {

        if (id == null) {
            return null;
        }

        return dao
                .queryBuilder()
                .where(DbAccountReaderSensorDao.Properties.Id.eq(id))
                .limit(1)
                .build()
                .unique();
    }

    @Override
    public List<DbAccountReaderSensor> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbAccountReaderSensorDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }
}
