package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.event;

import java.util.Collections;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbContactNumberEvent;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbContactNumberEventDao;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.DtoType;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.SensorDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.sensing.event.ContactNumberEventDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 24.11.2015
 */
public class ContactNumberEventDaoImpl extends
        CommonEventDaoImpl<DbContactNumberEvent> implements
        ContactNumberEventDao {

    private static final String TAG = ContactNumberEventDaoImpl.class.getSimpleName();

    private static ContactNumberEventDao INSTANCE;

    private ContactNumberEventDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbContactNumberEventDao());
    }

    public static ContactNumberEventDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new ContactNumberEventDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Override
    public SensorDto convertObject(DbContactNumberEvent sensor) {

        if (sensor == null) {
            return null;
        }

        ContactNumberEventDto result = new ContactNumberEventDto();

        result.setEventType(sensor.getType());
        result.setNumber(sensor.getNumber());
        result.setIsNew(sensor.getIsNew());
        result.setIsUpdated(sensor.getIsUpdated());
        result.setIsDeleted(sensor.getIsDeleted());
        result.setContactId(sensor.getContactId());
        result.setType(DtoType.CONTACT_NUMBER);
        result.setTypeStr(DtoType.getApiName(DtoType.CONTACT_NUMBER));
        result.setCreated(sensor.getCreated());

        return result;
    }

    @Override
    public List<DbContactNumberEvent> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbContactNumberEventDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }
}