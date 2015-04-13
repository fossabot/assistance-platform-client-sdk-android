package de.tudarmstadt.informatik.tk.kraken.android.sdk.db;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import de.tudarmstadt.informatik.tk.kraken.android.sdk.db.SensorContactNumber;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SENSOR_CONTACT_NUMBER.
*/
public class SensorContactNumberDao extends AbstractDao<SensorContactNumber, Long> {

    public static final String TABLENAME = "SENSOR_CONTACT_NUMBER";

    /**
     * Properties of entity SensorContactNumber.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property FkContact = new Property(1, long.class, "fkContact", false, "FK_CONTACT");
        public final static Property NumberId = new Property(2, Long.class, "numberId", false, "NUMBER_ID");
        public final static Property ContactId = new Property(3, Long.class, "contactId", false, "CONTACT_ID");
        public final static Property Type = new Property(4, String.class, "type", false, "TYPE");
        public final static Property Number = new Property(5, String.class, "number", false, "NUMBER");
        public final static Property Timestamp = new Property(6, Long.class, "timestamp", false, "TIMESTAMP");
        public final static Property IsNew = new Property(7, Boolean.class, "isNew", false, "IS_NEW");
        public final static Property IsUpdated = new Property(8, Boolean.class, "isUpdated", false, "IS_UPDATED");
        public final static Property IsDeleted = new Property(9, Boolean.class, "isDeleted", false, "IS_DELETED");
    };

    private Query<SensorContactNumber> sensorContact_SensorContactNumberListQuery;

    public SensorContactNumberDao(DaoConfig config) {
        super(config);
    }
    
    public SensorContactNumberDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SENSOR_CONTACT_NUMBER' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'FK_CONTACT' INTEGER NOT NULL ," + // 1: fkContact
                "'NUMBER_ID' INTEGER," + // 2: numberId
                "'CONTACT_ID' INTEGER," + // 3: contactId
                "'TYPE' TEXT," + // 4: type
                "'NUMBER' TEXT," + // 5: number
                "'TIMESTAMP' INTEGER," + // 6: timestamp
                "'IS_NEW' INTEGER," + // 7: isNew
                "'IS_UPDATED' INTEGER," + // 8: isUpdated
                "'IS_DELETED' INTEGER);"); // 9: isDeleted
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SENSOR_CONTACT_NUMBER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SensorContactNumber entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getFkContact());
 
        Long numberId = entity.getNumberId();
        if (numberId != null) {
            stmt.bindLong(3, numberId);
        }
 
        Long contactId = entity.getContactId();
        if (contactId != null) {
            stmt.bindLong(4, contactId);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(5, type);
        }
 
        String number = entity.getNumber();
        if (number != null) {
            stmt.bindString(6, number);
        }
 
        Long timestamp = entity.getTimestamp();
        if (timestamp != null) {
            stmt.bindLong(7, timestamp);
        }
 
        Boolean isNew = entity.getIsNew();
        if (isNew != null) {
            stmt.bindLong(8, isNew ? 1l: 0l);
        }
 
        Boolean isUpdated = entity.getIsUpdated();
        if (isUpdated != null) {
            stmt.bindLong(9, isUpdated ? 1l: 0l);
        }
 
        Boolean isDeleted = entity.getIsDeleted();
        if (isDeleted != null) {
            stmt.bindLong(10, isDeleted ? 1l: 0l);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SensorContactNumber readEntity(Cursor cursor, int offset) {
        SensorContactNumber entity = new SensorContactNumber( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // fkContact
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // numberId
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // contactId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // type
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // number
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // timestamp
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0, // isNew
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // isUpdated
            cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0 // isDeleted
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SensorContactNumber entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFkContact(cursor.getLong(offset + 1));
        entity.setNumberId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setContactId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setType(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setNumber(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTimestamp(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setIsNew(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
        entity.setIsUpdated(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setIsDeleted(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(SensorContactNumber entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(SensorContactNumber entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "sensorContactNumberList" to-many relationship of SensorContact. */
    public List<SensorContactNumber> _querySensorContact_SensorContactNumberList(long fkContact) {
        synchronized (this) {
            if (sensorContact_SensorContactNumberListQuery == null) {
                QueryBuilder<SensorContactNumber> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FkContact.eq(null));
                sensorContact_SensorContactNumberListQuery = queryBuilder.build();
            }
        }
        Query<SensorContactNumber> query = sensorContact_SensorContactNumberListQuery.forCurrentThread();
        query.setParameter(0, fkContact);
        return query.list();
    }

}
