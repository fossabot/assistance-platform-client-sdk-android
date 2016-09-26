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
 * DAO for table "foreground_sensor".
*/
public class DbForegroundSensorDao extends AbstractDao<DbForegroundSensor, Long> {

    public static final String TABLENAME = "foreground_sensor";

    /**
     * Properties of entity DbForegroundSensor.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property PackageName = new Property(1, String.class, "packageName", false, "PACKAGE_NAME");
        public static final Property AppName = new Property(2, String.class, "appName", false, "APP_NAME");
        public static final Property ClassName = new Property(3, String.class, "className", false, "CLASS_NAME");
        public static final Property ActivityLabel = new Property(4, String.class, "activityLabel", false, "ACTIVITY_LABEL");
        public static final Property Color = new Property(5, String.class, "color", false, "COLOR");
        public static final Property Url = new Property(6, String.class, "url", false, "URL");
        public static final Property EventType = new Property(7, Integer.class, "eventType", false, "EVENT_TYPE");
        public static final Property Keystrokes = new Property(8, Integer.class, "keystrokes", false, "KEYSTROKES");
        public static final Property Created = new Property(9, String.class, "created", false, "CREATED");
        public static final Property DeviceId = new Property(10, Long.class, "deviceId", false, "DEVICE_ID");
    }

    private DaoSession daoSession;


    public DbForegroundSensorDao(DaoConfig config) {
        super(config);
    }
    
    public DbForegroundSensorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"foreground_sensor\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PACKAGE_NAME\" TEXT," + // 1: packageName
                "\"APP_NAME\" TEXT," + // 2: appName
                "\"CLASS_NAME\" TEXT," + // 3: className
                "\"ACTIVITY_LABEL\" TEXT," + // 4: activityLabel
                "\"COLOR\" TEXT," + // 5: color
                "\"URL\" TEXT," + // 6: url
                "\"EVENT_TYPE\" INTEGER," + // 7: eventType
                "\"KEYSTROKES\" INTEGER," + // 8: keystrokes
                "\"CREATED\" TEXT NOT NULL ," + // 9: created
                "\"DEVICE_ID\" INTEGER);"); // 10: deviceId
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_foreground_sensor__id ON foreground_sensor" +
                " (\"_id\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_foreground_sensor_DEVICE_ID ON foreground_sensor" +
                " (\"DEVICE_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"foreground_sensor\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DbForegroundSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String packageName = entity.getPackageName();
        if (packageName != null) {
            stmt.bindString(2, packageName);
        }
 
        String appName = entity.getAppName();
        if (appName != null) {
            stmt.bindString(3, appName);
        }
 
        String className = entity.getClassName();
        if (className != null) {
            stmt.bindString(4, className);
        }
 
        String activityLabel = entity.getActivityLabel();
        if (activityLabel != null) {
            stmt.bindString(5, activityLabel);
        }
 
        String color = entity.getColor();
        if (color != null) {
            stmt.bindString(6, color);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(7, url);
        }
 
        Integer eventType = entity.getEventType();
        if (eventType != null) {
            stmt.bindLong(8, eventType);
        }
 
        Integer keystrokes = entity.getKeystrokes();
        if (keystrokes != null) {
            stmt.bindLong(9, keystrokes);
        }
        stmt.bindString(10, entity.getCreated());
 
        Long deviceId = entity.getDeviceId();
        if (deviceId != null) {
            stmt.bindLong(11, deviceId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DbForegroundSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String packageName = entity.getPackageName();
        if (packageName != null) {
            stmt.bindString(2, packageName);
        }
 
        String appName = entity.getAppName();
        if (appName != null) {
            stmt.bindString(3, appName);
        }
 
        String className = entity.getClassName();
        if (className != null) {
            stmt.bindString(4, className);
        }
 
        String activityLabel = entity.getActivityLabel();
        if (activityLabel != null) {
            stmt.bindString(5, activityLabel);
        }
 
        String color = entity.getColor();
        if (color != null) {
            stmt.bindString(6, color);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(7, url);
        }
 
        Integer eventType = entity.getEventType();
        if (eventType != null) {
            stmt.bindLong(8, eventType);
        }
 
        Integer keystrokes = entity.getKeystrokes();
        if (keystrokes != null) {
            stmt.bindLong(9, keystrokes);
        }
        stmt.bindString(10, entity.getCreated());
 
        Long deviceId = entity.getDeviceId();
        if (deviceId != null) {
            stmt.bindLong(11, deviceId);
        }
    }

    @Override
    protected final void attachEntity(DbForegroundSensor entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DbForegroundSensor readEntity(Cursor cursor, int offset) {
        DbForegroundSensor entity = new DbForegroundSensor( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // packageName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // appName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // className
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // activityLabel
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // color
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // url
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // eventType
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // keystrokes
            cursor.getString(offset + 9), // created
            cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10) // deviceId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DbForegroundSensor entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPackageName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAppName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setClassName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setActivityLabel(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setColor(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUrl(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEventType(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setKeystrokes(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setCreated(cursor.getString(offset + 9));
        entity.setDeviceId(cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DbForegroundSensor entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DbForegroundSensor entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DbForegroundSensor entity) {
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
            builder.append(" FROM foreground_sensor T");
            builder.append(" LEFT JOIN device T0 ON T.\"DEVICE_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected DbForegroundSensor loadCurrentDeep(Cursor cursor, boolean lock) {
        DbForegroundSensor entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        DbDevice dbDevice = loadCurrentOther(daoSession.getDbDeviceDao(), cursor, offset);
        entity.setDbDevice(dbDevice);

        return entity;    
    }

    public DbForegroundSensor loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            }
            if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<DbForegroundSensor> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<DbForegroundSensor> list = new ArrayList<>(count);
        
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
    
    protected List<DbForegroundSensor> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<DbForegroundSensor> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
