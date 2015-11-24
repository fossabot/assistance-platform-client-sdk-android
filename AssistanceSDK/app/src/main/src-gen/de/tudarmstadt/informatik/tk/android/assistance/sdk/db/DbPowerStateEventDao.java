package de.tudarmstadt.informatik.tk.android.assistance.sdk.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbPowerStateEvent;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "power_state_event".
*/
public class DbPowerStateEventDao extends AbstractDao<DbPowerStateEvent, Long> {

    public static final String TABLENAME = "power_state_event";

    /**
     * Properties of entity DbPowerStateEvent.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property IsCharging = new Property(1, Boolean.class, "isCharging", false, "IS_CHARGING");
        public final static Property Percent = new Property(2, Float.class, "percent", false, "PERCENT");
        public final static Property Created = new Property(3, String.class, "created", false, "CREATED");
        public final static Property ChargingState = new Property(4, Integer.class, "chargingState", false, "CHARGING_STATE");
        public final static Property ChargingMode = new Property(5, Integer.class, "chargingMode", false, "CHARGING_MODE");
        public final static Property PowerSaveMode = new Property(6, Boolean.class, "powerSaveMode", false, "POWER_SAVE_MODE");
    };


    public DbPowerStateEventDao(DaoConfig config) {
        super(config);
    }
    
    public DbPowerStateEventDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"power_state_event\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"IS_CHARGING\" INTEGER," + // 1: isCharging
                "\"PERCENT\" REAL," + // 2: percent
                "\"CREATED\" TEXT NOT NULL ," + // 3: created
                "\"CHARGING_STATE\" INTEGER," + // 4: chargingState
                "\"CHARGING_MODE\" INTEGER," + // 5: chargingMode
                "\"POWER_SAVE_MODE\" INTEGER);"); // 6: powerSaveMode
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_power_state_event__id ON power_state_event" +
                " (\"_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"power_state_event\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DbPowerStateEvent entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Boolean isCharging = entity.getIsCharging();
        if (isCharging != null) {
            stmt.bindLong(2, isCharging ? 1L: 0L);
        }
 
        Float percent = entity.getPercent();
        if (percent != null) {
            stmt.bindDouble(3, percent);
        }
        stmt.bindString(4, entity.getCreated());
 
        Integer chargingState = entity.getChargingState();
        if (chargingState != null) {
            stmt.bindLong(5, chargingState);
        }
 
        Integer chargingMode = entity.getChargingMode();
        if (chargingMode != null) {
            stmt.bindLong(6, chargingMode);
        }
 
        Boolean powerSaveMode = entity.getPowerSaveMode();
        if (powerSaveMode != null) {
            stmt.bindLong(7, powerSaveMode ? 1L: 0L);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DbPowerStateEvent readEntity(Cursor cursor, int offset) {
        DbPowerStateEvent entity = new DbPowerStateEvent( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0, // isCharging
            cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2), // percent
            cursor.getString(offset + 3), // created
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // chargingState
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // chargingMode
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0 // powerSaveMode
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DbPowerStateEvent entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIsCharging(cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0);
        entity.setPercent(cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2));
        entity.setCreated(cursor.getString(offset + 3));
        entity.setChargingState(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setChargingMode(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setPowerSaveMode(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DbPowerStateEvent entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DbPowerStateEvent entity) {
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