package de.tudarmstadt.informatik.tk.android.assistance.sdk.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbContactNumberSensor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "contact_number_sensor".
*/
public class DbContactNumberSensorDao extends AbstractDao<DbContactNumberSensor, Long> {

    public static final String TABLENAME = "contact_number_sensor";

    /**
     * Properties of entity DbContactNumberSensor.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property NumberId = new Property(1, Long.class, "numberId", false, "NUMBER_ID");
        public final static Property Type = new Property(2, String.class, "type", false, "TYPE");
        public final static Property Number = new Property(3, String.class, "number", false, "NUMBER");
        public final static Property IsNew = new Property(4, Boolean.class, "isNew", false, "IS_NEW");
        public final static Property IsUpdated = new Property(5, Boolean.class, "isUpdated", false, "IS_UPDATED");
        public final static Property IsDeleted = new Property(6, Boolean.class, "isDeleted", false, "IS_DELETED");
        public final static Property Created = new Property(7, String.class, "created", false, "CREATED");
        public final static Property ContactId = new Property(8, Long.class, "contactId", false, "CONTACT_ID");
    };

    private DaoSession daoSession;

    private Query<DbContactNumberSensor> dbContactSensor_DbContactNumberSensorListQuery;

    public DbContactNumberSensorDao(DaoConfig config) {
        super(config);
    }
    
    public DbContactNumberSensorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"contact_number_sensor\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NUMBER_ID\" INTEGER," + // 1: numberId
                "\"TYPE\" TEXT," + // 2: type
                "\"NUMBER\" TEXT," + // 3: number
                "\"IS_NEW\" INTEGER," + // 4: isNew
                "\"IS_UPDATED\" INTEGER," + // 5: isUpdated
                "\"IS_DELETED\" INTEGER," + // 6: isDeleted
                "\"CREATED\" TEXT NOT NULL ," + // 7: created
                "\"CONTACT_ID\" INTEGER);"); // 8: contactId
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_contact_number_sensor__id ON contact_number_sensor" +
                " (\"_id\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_contact_number_sensor_CONTACT_ID ON contact_number_sensor" +
                " (\"CONTACT_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"contact_number_sensor\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DbContactNumberSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long numberId = entity.getNumberId();
        if (numberId != null) {
            stmt.bindLong(2, numberId);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(3, type);
        }
 
        String number = entity.getNumber();
        if (number != null) {
            stmt.bindString(4, number);
        }
 
        Boolean isNew = entity.getIsNew();
        if (isNew != null) {
            stmt.bindLong(5, isNew ? 1L: 0L);
        }
 
        Boolean isUpdated = entity.getIsUpdated();
        if (isUpdated != null) {
            stmt.bindLong(6, isUpdated ? 1L: 0L);
        }
 
        Boolean isDeleted = entity.getIsDeleted();
        if (isDeleted != null) {
            stmt.bindLong(7, isDeleted ? 1L: 0L);
        }
        stmt.bindString(8, entity.getCreated());
 
        Long contactId = entity.getContactId();
        if (contactId != null) {
            stmt.bindLong(9, contactId);
        }
    }

    @Override
    protected void attachEntity(DbContactNumberSensor entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DbContactNumberSensor readEntity(Cursor cursor, int offset) {
        DbContactNumberSensor entity = new DbContactNumberSensor( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // numberId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // type
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // number
            cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0, // isNew
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // isUpdated
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0, // isDeleted
            cursor.getString(offset + 7), // created
            cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8) // contactId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DbContactNumberSensor entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNumberId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setType(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNumber(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIsNew(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
        entity.setIsUpdated(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setIsDeleted(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
        entity.setCreated(cursor.getString(offset + 7));
        entity.setContactId(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DbContactNumberSensor entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DbContactNumberSensor entity) {
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
    
    /** Internal query to resolve the "dbContactNumberSensorList" to-many relationship of DbContactSensor. */
    public List<DbContactNumberSensor> _queryDbContactSensor_DbContactNumberSensorList(Long contactId) {
        synchronized (this) {
            if (dbContactSensor_DbContactNumberSensorListQuery == null) {
                QueryBuilder<DbContactNumberSensor> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ContactId.eq(null));
                dbContactSensor_DbContactNumberSensorListQuery = queryBuilder.build();
            }
        }
        Query<DbContactNumberSensor> query = dbContactSensor_DbContactNumberSensorListQuery.forCurrentThread();
        query.setParameter(0, contactId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getDbContactSensorDao().getAllColumns());
            builder.append(" FROM contact_number_sensor T");
            builder.append(" LEFT JOIN contact_sensor T0 ON T.\"CONTACT_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected DbContactNumberSensor loadCurrentDeep(Cursor cursor, boolean lock) {
        DbContactNumberSensor entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        DbContactSensor dbContactSensor = loadCurrentOther(daoSession.getDbContactSensorDao(), cursor, offset);
        entity.setDbContactSensor(dbContactSensor);

        return entity;    
    }

    public DbContactNumberSensor loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<DbContactNumberSensor> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<DbContactNumberSensor> list = new ArrayList<DbContactNumberSensor>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<DbContactNumberSensor> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<DbContactNumberSensor> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}