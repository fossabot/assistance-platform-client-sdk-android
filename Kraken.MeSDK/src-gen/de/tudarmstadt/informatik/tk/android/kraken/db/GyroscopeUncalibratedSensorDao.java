package de.tudarmstadt.informatik.tk.android.kraken.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.android.kraken.db.GyroscopeUncalibratedSensor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "gyroscope_uncalibrated_sensor".
*/
public class GyroscopeUncalibratedSensorDao extends AbstractDao<GyroscopeUncalibratedSensor, Long> {

    public static final String TABLENAME = "gyroscope_uncalibrated_sensor";

    /**
     * Properties of entity GyroscopeUncalibratedSensor.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property XNoDrift = new Property(1, float.class, "xNoDrift", false, "X_NO_DRIFT");
        public final static Property YNoDrift = new Property(2, float.class, "yNoDrift", false, "Y_NO_DRIFT");
        public final static Property ZNoDrift = new Property(3, float.class, "zNoDrift", false, "Z_NO_DRIFT");
        public final static Property XEstimatedDrift = new Property(4, float.class, "xEstimatedDrift", false, "X_ESTIMATED_DRIFT");
        public final static Property YEstimatedDrift = new Property(5, float.class, "yEstimatedDrift", false, "Y_ESTIMATED_DRIFT");
        public final static Property ZEstimatedDrift = new Property(6, float.class, "zEstimatedDrift", false, "Z_ESTIMATED_DRIFT");
        public final static Property Created = new Property(7, String.class, "created", false, "CREATED");
    };


    public GyroscopeUncalibratedSensorDao(DaoConfig config) {
        super(config);
    }
    
    public GyroscopeUncalibratedSensorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"gyroscope_uncalibrated_sensor\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"X_NO_DRIFT\" REAL NOT NULL ," + // 1: xNoDrift
                "\"Y_NO_DRIFT\" REAL NOT NULL ," + // 2: yNoDrift
                "\"Z_NO_DRIFT\" REAL NOT NULL ," + // 3: zNoDrift
                "\"X_ESTIMATED_DRIFT\" REAL NOT NULL ," + // 4: xEstimatedDrift
                "\"Y_ESTIMATED_DRIFT\" REAL NOT NULL ," + // 5: yEstimatedDrift
                "\"Z_ESTIMATED_DRIFT\" REAL NOT NULL ," + // 6: zEstimatedDrift
                "\"CREATED\" TEXT NOT NULL );"); // 7: created
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_gyroscope_uncalibrated_sensor__id ON gyroscope_uncalibrated_sensor" +
                " (\"_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"gyroscope_uncalibrated_sensor\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, GyroscopeUncalibratedSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindDouble(2, entity.getXNoDrift());
        stmt.bindDouble(3, entity.getYNoDrift());
        stmt.bindDouble(4, entity.getZNoDrift());
        stmt.bindDouble(5, entity.getXEstimatedDrift());
        stmt.bindDouble(6, entity.getYEstimatedDrift());
        stmt.bindDouble(7, entity.getZEstimatedDrift());
        stmt.bindString(8, entity.getCreated());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public GyroscopeUncalibratedSensor readEntity(Cursor cursor, int offset) {
        GyroscopeUncalibratedSensor entity = new GyroscopeUncalibratedSensor( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getFloat(offset + 1), // xNoDrift
            cursor.getFloat(offset + 2), // yNoDrift
            cursor.getFloat(offset + 3), // zNoDrift
            cursor.getFloat(offset + 4), // xEstimatedDrift
            cursor.getFloat(offset + 5), // yEstimatedDrift
            cursor.getFloat(offset + 6), // zEstimatedDrift
            cursor.getString(offset + 7) // created
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, GyroscopeUncalibratedSensor entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setXNoDrift(cursor.getFloat(offset + 1));
        entity.setYNoDrift(cursor.getFloat(offset + 2));
        entity.setZNoDrift(cursor.getFloat(offset + 3));
        entity.setXEstimatedDrift(cursor.getFloat(offset + 4));
        entity.setYEstimatedDrift(cursor.getFloat(offset + 5));
        entity.setZEstimatedDrift(cursor.getFloat(offset + 6));
        entity.setCreated(cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(GyroscopeUncalibratedSensor entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(GyroscopeUncalibratedSensor entity) {
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
    
}
