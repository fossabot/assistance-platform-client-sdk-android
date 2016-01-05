package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.event;

import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbNetworkTrafficSensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbNetworkTrafficSensorDao;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.sensing.sensor.NetworkTrafficSensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.10.2015
 */
public class NetworkTrafficEventDaoImpl extends
        CommonEventDaoImpl<DbNetworkTrafficSensor> implements
        NetworkTrafficEventDao {

    private static final String TAG = NetworkTrafficEventDaoImpl.class.getSimpleName();

    private static NetworkTrafficEventDao INSTANCE;

    private NetworkTrafficEventDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbNetworkTrafficSensorDao());
    }

    public static NetworkTrafficEventDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new NetworkTrafficEventDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Nullable
    @Override
    public NetworkTrafficSensorDto convertObject(DbNetworkTrafficSensor sensor) {

        if (sensor == null) {
            return null;
        }

        NetworkTrafficSensorDto result = new NetworkTrafficSensorDto();

        result.setAppName(sensor.getAppName());
        result.setRxBytes(sensor.getRxBytes());
        result.setTxBytes(sensor.getTxBytes());
        result.setBackground(sensor.getBackground());
        result.setLongitude(sensor.getLongitude());
        result.setLatitude(sensor.getLatitude());
        result.setCreated(sensor.getCreated());

        return result;
    }

    @Nullable
    @Override
    public DbNetworkTrafficSensor get(Long id) {

        if (id == null) {
            return null;
        }

        return dao
                .queryBuilder()
                .where(DbNetworkTrafficSensorDao.Properties.Id.eq(id))
                .limit(1)
                .build()
                .unique();
    }

    @Override
    public List<DbNetworkTrafficSensor> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbNetworkTrafficSensorDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }

    @Override
    public List<DbNetworkTrafficSensor> getAllBackground() {
        return dao
                .queryBuilder()
                .where(DbNetworkTrafficSensorDao.Properties.Background.eq(Boolean.TRUE))
                .build()
                .list();
    }

    @Override
    public List<DbNetworkTrafficSensor> getAllForeground() {
        return dao
                .queryBuilder()
                .where(DbNetworkTrafficSensorDao.Properties.Background.eq(Boolean.FALSE))
                .build()
                .list();
    }

    @Override
    public List<DbNetworkTrafficSensor> getFirstNBackground(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .where(DbNetworkTrafficSensorDao.Properties.Background.eq(Boolean.TRUE))
                .limit(amount)
                .build()
                .list();
    }

    @Override
    public List<DbNetworkTrafficSensor> getFirstNForeground(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .where(DbNetworkTrafficSensorDao.Properties.Background.eq(Boolean.FALSE))
                .limit(amount)
                .build()
                .list();
    }
}