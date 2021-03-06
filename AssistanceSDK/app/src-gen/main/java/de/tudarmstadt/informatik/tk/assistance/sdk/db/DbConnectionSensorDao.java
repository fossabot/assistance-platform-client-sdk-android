package de.tudarmstadt.informatik.tk.assistance.sdk.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "connection_sensor".
*/
public class DbConnectionSensorDao extends AbstractDao<DbConnectionSensor, Long> {

    public static final String TABLENAME = "connection_sensor";

    /**
     * Properties of entity DbConnectionSensor.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property IsWifi = new Property(1, Boolean.class, "isWifi", false, "IS_WIFI");
        public final static Property IsMobile = new Property(2, Boolean.class, "isMobile", false, "IS_MOBILE");
        public final static Property Created = new Property(3, String.class, "created", false, "CREATED");
        public final static Property DeviceId = new Property(4, Long.class, "deviceId", false, "DEVICE_ID");
    }

    private DaoSession daoSession;


    public DbConnectionSensorDao(DaoConfig config) {
        super(config);
    }
    
    public DbConnectionSensorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"connection_sensor\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"IS_WIFI\" INTEGER," + // 1: isWifi
                "\"IS_MOBILE\" INTEGER," + // 2: isMobile
                "\"CREATED\" TEXT NOT NULL ," + // 3: created
                "\"DEVICE_ID\" INTEGER);"); // 4: deviceId
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_connection_sensor__id ON connection_sensor" +
                " (\"_id\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_connection_sensor_DEVICE_ID ON connection_sensor" +
                " (\"DEVICE_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"connection_sensor\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DbConnectionSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Boolean isWifi = entity.getIsWifi();
        if (isWifi != null) {
            stmt.bindLong(2, isWifi ? 1L: 0L);
        }
 
        Boolean isMobile = entity.getIsMobile();
        if (isMobile != null) {
            stmt.bindLong(3, isMobile ? 1L: 0L);
        }
        stmt.bindString(4, entity.getCreated());
 
        Long deviceId = entity.getDeviceId();
        if (deviceId != null) {
            stmt.bindLong(5, deviceId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DbConnectionSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Boolean isWifi = entity.getIsWifi();
        if (isWifi != null) {
            stmt.bindLong(2, isWifi ? 1L: 0L);
        }
 
        Boolean isMobile = entity.getIsMobile();
        if (isMobile != null) {
            stmt.bindLong(3, isMobile ? 1L: 0L);
        }
        stmt.bindString(4, entity.getCreated());
 
        Long deviceId = entity.getDeviceId();
        if (deviceId != null) {
            stmt.bindLong(5, deviceId);
        }
    }

    @Override
    protected final void attachEntity(DbConnectionSensor entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DbConnectionSensor readEntity(Cursor cursor, int offset) {
        DbConnectionSensor entity = new DbConnectionSensor( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0, // isWifi
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0, // isMobile
            cursor.getString(offset + 3), // created
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4) // deviceId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DbConnectionSensor entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIsWifi(cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0);
        entity.setIsMobile(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0);
        entity.setCreated(cursor.getString(offset + 3));
        entity.setDeviceId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DbConnectionSensor entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DbConnectionSensor entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DbConnectionSensor entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getDbDeviceDao().getAllColumns());
            builder.append(" FROM connection_sensor T");
            builder.append(" LEFT JOIN device T0 ON T.\"DEVICE_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected DbConnectionSensor loadCurrentDeep(Cursor cursor, boolean lock) {
        DbConnectionSensor entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        DbDevice dbDevice = loadCurrentOther(daoSession.getDbDeviceDao(), cursor, offset);
        entity.setDbDevice(dbDevice);

        return entity;    
    }

    public DbConnectionSensor loadDeep(Long key) {
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
    public List<DbConnectionSensor> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<DbConnectionSensor> list = new ArrayList<DbConnectionSensor>(count);
        
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
    
    protected List<DbConnectionSensor> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<DbConnectionSensor> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
