package de.tudarmstadt.informatik.tk.assistance.sdk.provider.dao.sensing;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.Property;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbNetworkTrafficSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbNetworkTrafficSensorDao.Properties;
import de.tudarmstadt.informatik.tk.assistance.sdk.model.api.sensing.sensor.NetworkTrafficSensorDto;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.10.2015
 */
@Singleton
public final class NetworkTrafficSensorDaoImpl extends
        CommonEventDaoImpl<DbNetworkTrafficSensor> implements
        NetworkTrafficSensorDao {

    private static final String TAG = NetworkTrafficSensorDaoImpl.class.getSimpleName();

    @Inject
    public NetworkTrafficSensorDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbNetworkTrafficSensorDao());
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

    @Override
    public List<DbNetworkTrafficSensor> getAllBackground(long deviceId) {

        if (deviceId < 0) {
            return Collections.emptyList();
        }

        for (Property property : properties) {
            if (property.name.equals(DEVICE_ID_FIELD_NAME)) {
                return dao
                        .queryBuilder()
                        .where(Properties.Background.eq(Boolean.TRUE))
                        .where(property.eq(deviceId))
                        .build()
                        .list();
            }
        }

        return Collections.emptyList();
    }

    @Override
    public List<DbNetworkTrafficSensor> getAllForeground(long deviceId) {

        if (deviceId < 0) {
            return Collections.emptyList();
        }

        for (Property property : properties) {
            if (property.name.equals(DEVICE_ID_FIELD_NAME)) {
                return dao
                        .queryBuilder()
                        .where(Properties.Background.eq(Boolean.FALSE))
                        .where(property.eq(deviceId))
                        .build()
                        .list();
            }
        }

        return Collections.emptyList();
    }

    @Override
    public List<DbNetworkTrafficSensor> getFirstNBackground(int amount, long deviceId) {

        if (amount <= 0 || deviceId < 0) {
            return Collections.emptyList();
        }

        for (Property property : properties) {
            if (property.name.equals(DEVICE_ID_FIELD_NAME)) {
                return dao
                        .queryBuilder()
                        .where(Properties.Background.eq(Boolean.TRUE))
                        .where(property.eq(deviceId))
                        .limit(amount)
                        .build()
                        .list();
            }
        }

        return Collections.emptyList();
    }

    @Override
    public List<DbNetworkTrafficSensor> getFirstNForeground(int amount, long deviceId) {

        if (amount <= 0 || deviceId < 0) {
            return Collections.emptyList();
        }

        for (Property property : properties) {
            if (property.name.equals(DEVICE_ID_FIELD_NAME)) {
                return dao
                        .queryBuilder()
                        .where(Properties.Background.eq(Boolean.FALSE))
                        .where(property.eq(deviceId))
                        .limit(amount)
                        .build()
                        .list();
            }
        }

        return Collections.emptyList();
    }
}