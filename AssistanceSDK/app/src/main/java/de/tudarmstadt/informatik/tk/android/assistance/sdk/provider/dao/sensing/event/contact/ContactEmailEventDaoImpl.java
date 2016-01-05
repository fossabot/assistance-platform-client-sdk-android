package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.event.contact;

import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbContactEmailSensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbContactEmailSensorDao;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.SensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 24.11.2015
 */
public class ContactEmailEventDaoImpl extends
        CommonEventDaoImpl<DbContactEmailSensor> implements
        ContactEmailEventDao {

    private static final String TAG = ContactEmailEventDaoImpl.class.getSimpleName();

    private static ContactEmailEventDao INSTANCE;

    private ContactEmailEventDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbContactEmailSensorDao());
    }

    public static ContactEmailEventDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new ContactEmailEventDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Nullable
    @Override
    public SensorDto convertObject(DbContactEmailSensor sensor) {

        if (sensor == null) {
            return null;
        }

//        ContactEmailEventDto result = new ContactEmailEventDto();
//
//        result.setId(sensor.getId());
//        result.setContactId(sensor.getContactId());
//        result.setMailId(sensor.getMailId());
//        result.setAddress(sensor.getAddress());
//        result.setEventType(sensor.getType());
//        result.setIsNew(sensor.getIsNew());
//        result.setIsUpdated(sensor.getIsUpdated());
//        result.setIsDeleted(sensor.getIsDeleted());
//        result.setType(SensorApiType.CONTACT_EMAIL);
//        result.setTypeStr(SensorApiType.getApiName(SensorApiType.CONTACT_EMAIL));
//        result.setCreated(sensor.getCreated());

        return null;
    }

    @Nullable
    @Override
    public DbContactEmailSensor get(Long id) {

        if (id == null) {
            return null;
        }

        return dao
                .queryBuilder()
                .where(DbContactEmailSensorDao.Properties.Id.eq(id))
                .limit(1)
                .build()
                .unique();
    }

    @Override
    public List<DbContactEmailSensor> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbContactEmailSensorDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }

    @Override
    public List<DbContactEmailSensor> getAll(Long contactId) {

        if (contactId == null) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .where(DbContactEmailSensorDao.Properties.ContactId.eq(contactId))
                .build()
                .list();
    }
}
