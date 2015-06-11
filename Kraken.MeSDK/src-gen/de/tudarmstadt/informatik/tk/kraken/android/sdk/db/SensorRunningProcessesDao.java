package de.tudarmstadt.informatik.tk.kraken.android.sdk.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.kraken.android.sdk.db.SensorRunningProcesses;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SENSOR_RUNNING_PROCESSES.
*/
public class SensorRunningProcessesDao extends AbstractDao<SensorRunningProcesses, Long> {

    public static final String TABLENAME = "SENSOR_RUNNING_PROCESSES";

    /**
     * Properties of entity SensorRunningProcesses.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property RunningProcesses = new Property(1, String.class, "runningProcesses", false, "RUNNING_PROCESSES");
        public final static Property Timestamp = new Property(2, Long.class, "timestamp", false, "TIMESTAMP");
    };


    public SensorRunningProcessesDao(DaoConfig config) {
        super(config);
    }
    
    public SensorRunningProcessesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SENSOR_RUNNING_PROCESSES' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'RUNNING_PROCESSES' TEXT," + // 1: runningProcesses
                "'TIMESTAMP' INTEGER);"); // 2: timestamp
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SENSOR_RUNNING_PROCESSES'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SensorRunningProcesses entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String runningProcesses = entity.getRunningProcesses();
        if (runningProcesses != null) {
            stmt.bindString(2, runningProcesses);
        }
 
        Long timestamp = entity.getTimestamp();
        if (timestamp != null) {
            stmt.bindLong(3, timestamp);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SensorRunningProcesses readEntity(Cursor cursor, int offset) {
        SensorRunningProcesses entity = new SensorRunningProcesses( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // runningProcesses
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // timestamp
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SensorRunningProcesses entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setRunningProcesses(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTimestamp(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(SensorRunningProcesses entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(SensorRunningProcesses entity) {
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