package de.tudarmstadt.informatik.tk.assistance.sdk.provider.dao.sensing.contact;

import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbContactEmailSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbContactNumberSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbContactSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbContactSensorDao;
import de.tudarmstadt.informatik.tk.assistance.sdk.model.api.SensorDto;
import de.tudarmstadt.informatik.tk.assistance.sdk.model.api.sensing.sensor.contact.ContactEmailNumber;
import de.tudarmstadt.informatik.tk.assistance.sdk.model.api.sensing.sensor.contact.ContactSensorDto;
import de.tudarmstadt.informatik.tk.assistance.sdk.provider.dao.sensing.common.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 24.11.2015
 */
public class ContactSensorDaoImpl extends
        CommonEventDaoImpl<DbContactSensor> implements
        ContactSensorDao {

    private static final String TAG = ContactSensorDaoImpl.class.getSimpleName();

    private static ContactSensorDao INSTANCE;

    private ContactSensorDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbContactSensorDao());
    }

    public static ContactSensorDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new ContactSensorDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Nullable
    @Override
    public SensorDto convertObject(DbContactSensor sensor) {

        if (sensor == null) {
            return null;
        }

        ContactSensorDto result = new ContactSensorDto();

        result.setGlobalContactId(sensor.getGlobalContactId());
        result.setDisplayName(sensor.getDisplayName());
        result.setGivenName(sensor.getGivenName());
        result.setFamilyName(sensor.getFamilyName());
        result.setStarred(sensor.getStarred());
        result.setLastTimeContacted(sensor.getLastTimeContacted());
        result.setTimesContacted(sensor.getTimesContacted());
        result.setNote(sensor.getNote());
        result.setIsDeleted(sensor.getIsDeleted());
        result.setCreated(sensor.getCreated());

        List<DbContactEmailSensor> dbEmails = sensor.getDbContactEmailSensorList();
        List<DbContactNumberSensor> dbNumbers = sensor.getDbContactNumberSensorList();

        if (dbEmails != null && !dbEmails.isEmpty()) {

            Set<ContactEmailNumber> emailsDto = new HashSet<>(dbEmails.size());

            for (DbContactEmailSensor emailEvent : dbEmails) {

                ContactEmailNumber emailDto = new ContactEmailNumber(
                        emailEvent.getType(),
                        emailEvent.getAddress());

                emailsDto.add(emailDto);
            }

            result.setEmailAddresses(emailsDto);
        }

        if (dbNumbers != null && !dbNumbers.isEmpty()) {

            Set<ContactEmailNumber> numbersDto = new HashSet<>(dbNumbers.size());

            for (DbContactNumberSensor numberEvent : dbNumbers) {

                ContactEmailNumber emailDto = new ContactEmailNumber(
                        numberEvent.getType(),
                        numberEvent.getNumber());

                numbersDto.add(emailDto);
            }

            result.setPhoneNumbers(numbersDto);
        }

        return result;
    }

    @Nullable
    @Override
    public DbContactSensor get(Long id) {

        if (id == null) {
            return null;
        }

        return dao
                .queryBuilder()
                .where(DbContactSensorDao.Properties.Id.eq(id))
                .limit(1)
                .build()
                .unique();
    }

    @Override
    public List<DbContactSensor> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbContactSensorDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }

    @Override
    public List<DbContactSensor> getAllUpdated() {
        return dao
                .queryBuilder()
                .where(DbContactSensorDao.Properties.IsUpdated.eq(1))
                .build()
                .list();
    }
}