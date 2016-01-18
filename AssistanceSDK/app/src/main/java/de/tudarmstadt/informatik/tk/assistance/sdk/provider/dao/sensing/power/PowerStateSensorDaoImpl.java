package de.tudarmstadt.informatik.tk.assistance.sdk.provider.dao.sensing.power;

import android.support.annotation.Nullable;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbPowerStateSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.model.api.sensing.sensor.PowerStateSensorDto;
import de.tudarmstadt.informatik.tk.assistance.sdk.provider.dao.sensing.common.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 31.10.2015
 */
public class PowerStateSensorDaoImpl extends
        CommonEventDaoImpl<DbPowerStateSensor> implements
        PowerStateSensorDao {

    private static final String TAG = PowerStateSensorDaoImpl.class.getSimpleName();

    private static PowerStateSensorDao INSTANCE;

    private PowerStateSensorDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbPowerStateSensorDao());
    }

    public static PowerStateSensorDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new PowerStateSensorDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Nullable
    @Override
    public PowerStateSensorDto convertObject(DbPowerStateSensor sensor) {

        if (sensor == null) {
            return null;
        }

        PowerStateSensorDto result = new PowerStateSensorDto(
                sensor.getIsCharging(),
                sensor.getPercent(),
                sensor.getChargingState(),
                sensor.getChargingMode(),
                sensor.getPowerSaveMode(),
                sensor.getCreated()
        );

        return result;
    }
}