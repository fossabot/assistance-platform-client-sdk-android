package de.tudarmstadt.informatik.tk.assistance.sdk.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbNetworkTrafficSensor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "network_traffic_sensor".
*/
public class DbNetworkTrafficSensorDao extends AbstractDao<DbNetworkTrafficSensor, Long> {

    public static final String TABLENAME = "network_traffic_sensor";

    /**
     * Properties of entity DbNetworkTrafficSensor.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property AppName = new Property(1, String.class, "appName", false, "APP_NAME");
        public final static Property RxBytes = new Property(2, Long.class, "rxBytes", false, "RX_BYTES");
        public final static Property TxBytes = new Property(3, Long.class, "txBytes", false, "TX_BYTES");
        public final static Property Background = new Property(4, Boolean.class, "background", false, "BACKGROUND");
        public final static Property Longitude = new Property(5, Double.class, "longitude", false, "LONGITUDE");
        public final static Property Latitude = new Property(6, Double.class, "latitude", false, "LATITUDE");
        public final static Property Created = new Property(7, String.class, "created", false, "CREATED");
        public final static Property DeviceId = new Property(8, Long.class, "deviceId", false, "DEVICE_ID");
    };

    private DaoSession daoSession;


    public DbNetworkTrafficSensorDao(DaoConfig config) {
        super(config);
    }
    
    public DbNetworkTrafficSensorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"network_traffic_sensor\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"APP_NAME\" TEXT," + // 1: appName
                "\"RX_BYTES\" INTEGER," + // 2: rxBytes
                "\"TX_BYTES\" INTEGER," + // 3: txBytes
                "\"BACKGROUND\" INTEGER," + // 4: background
                "\"LONGITUDE\" REAL," + // 5: longitude
                "\"LATITUDE\" REAL," + // 6: latitude
                "\"CREATED\" TEXT NOT NULL ," + // 7: created
                "\"DEVICE_ID\" INTEGER);"); // 8: deviceId
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_network_traffic_sensor__id ON network_traffic_sensor" +
                " (\"_id\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_network_traffic_sensor_DEVICE_ID ON network_traffic_sensor" +
                " (\"DEVICE_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"network_traffic_sensor\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DbNetworkTrafficSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String appName = entity.getAppName();
        if (appName != null) {
            stmt.bindString(2, appName);
        }
 
        Long rxBytes = entity.getRxBytes();
        if (rxBytes != null) {
            stmt.bindLong(3, rxBytes);
        }
 
        Long txBytes = entity.getTxBytes();
        if (txBytes != null) {
            stmt.bindLong(4, txBytes);
        }
 
        Boolean background = entity.getBackground();
        if (background != null) {
            stmt.bindLong(5, background ? 1L: 0L);
        }
 
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(6, longitude);
        }
 
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(7, latitude);
        }
        stmt.bindString(8, entity.getCreated());
 
        Long deviceId = entity.getDeviceId();
        if (deviceId != null) {
            stmt.bindLong(9, deviceId);
        }
    }

    @Override
    protected void attachEntity(DbNetworkTrafficSensor entity) {
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
    public DbNetworkTrafficSensor readEntity(Cursor cursor, int offset) {
        DbNetworkTrafficSensor entity = new DbNetworkTrafficSensor( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // appName
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // rxBytes
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // txBytes
            cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0, // background
            cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5), // longitude
            cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6), // latitude
            cursor.getString(offset + 7), // created
            cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8) // deviceId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DbNetworkTrafficSensor entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAppName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRxBytes(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setTxBytes(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setBackground(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
        entity.setLongitude(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setLatitude(cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6));
        entity.setCreated(cursor.getString(offset + 7));
        entity.setDeviceId(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DbNetworkTrafficSensor entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DbNetworkTrafficSensor entity) {
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
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getDbDeviceDao().getAllColumns());
            builder.append(" FROM network_traffic_sensor T");
            builder.append(" LEFT JOIN device T0 ON T.\"DEVICE_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected DbNetworkTrafficSensor loadCurrentDeep(Cursor cursor, boolean lock) {
        DbNetworkTrafficSensor entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        DbDevice dbDevice = loadCurrentOther(daoSession.getDbDeviceDao(), cursor, offset);
        entity.setDbDevice(dbDevice);

        return entity;    
    }

    public DbNetworkTrafficSensor loadDeep(Long key) {
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
    public List<DbNetworkTrafficSensor> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<DbNetworkTrafficSensor> list = new ArrayList<DbNetworkTrafficSensor>(count);
        
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
    
    protected List<DbNetworkTrafficSensor> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<DbNetworkTrafficSensor> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
