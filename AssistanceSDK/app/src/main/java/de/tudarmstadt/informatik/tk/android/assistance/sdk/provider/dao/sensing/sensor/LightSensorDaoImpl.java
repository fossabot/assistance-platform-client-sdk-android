package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.sensor;

import java.util.Collections;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbLightSensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbLightSensorDao;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.DtoType;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.sensing.sensor.LightSensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.10.2015
 */
public class LightSensorDaoImpl extends
        CommonEventDaoImpl<DbLightSensor> implements
        LightSensorDao {

    private static final String TAG = LightSensorDaoImpl.class.getSimpleName();

    private static LightSensorDao INSTANCE;

    private LightSensorDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbLightSensorDao());
    }

    public static LightSensorDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new LightSensorDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Override
    public LightSensorDto convertObject(DbLightSensor sensor) {

        if (sensor == null) {
            return null;
        }

        LightSensorDto result = new LightSensorDto();

        result.setId(sensor.getId());
        result.setAccuracy(sensor.getAccuracy());
        result.setValue(sensor.getValue());
        result.setType(DtoType.LIGHT);
        result.setTypeStr(DtoType.getApiName(DtoType.LIGHT));
        result.setCreated(sensor.getCreated());

        return result;
    }

    @Override
    public List<DbLightSensor> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbLightSensorDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }
}