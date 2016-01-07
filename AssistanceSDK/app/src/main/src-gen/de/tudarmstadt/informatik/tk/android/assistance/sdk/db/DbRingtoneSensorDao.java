package de.tudarmstadt.informatik.tk.android.assistance.sdk.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbRingtoneSensor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ringtone_sensor".
*/
public class DbRingtoneSensorDao extends AbstractDao<DbRingtoneSensor, Long> {

    public static final String TABLENAME = "ringtone_sensor";

    /**
     * Properties of entity DbRingtoneSensor.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Mode = new Property(1, Integer.class, "mode", false, "MODE");
        public final static Property Created = new Property(2, String.class, "created", false, "CREATED");
    };


    public DbRingtoneSensorDao(DaoConfig config) {
        super(config);
    }
    
    public DbRingtoneSensorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ringtone_sensor\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"MODE\" INTEGER," + // 1: mode
                "\"CREATED\" TEXT NOT NULL );"); // 2: created
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_ringtone_sensor__id ON ringtone_sensor" +
                " (\"_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ringtone_sensor\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DbRingtoneSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer mode = entity.getMode();
        if (mode != null) {
            stmt.bindLong(2, mode);
        }
        stmt.bindString(3, entity.getCreated());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DbRingtoneSensor readEntity(Cursor cursor, int offset) {
        DbRingtoneSensor entity = new DbRingtoneSensor( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // mode
            cursor.getString(offset + 2) // created
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DbRingtoneSensor entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMode(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setCreated(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DbRingtoneSensor entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DbRingtoneSensor entity) {
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