package de.tudarmstadt.informatik.tk.android.kraken.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.android.kraken.db.MagneticFieldUncalibratedSensor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "magnetic_field_uncalibrated_sensor".
*/
public class MagneticFieldUncalibratedSensorDao extends AbstractDao<MagneticFieldUncalibratedSensor, Long> {

    public static final String TABLENAME = "magnetic_field_uncalibrated_sensor";

    /**
     * Properties of entity MagneticFieldUncalibratedSensor.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property XNoHardIron = new Property(1, float.class, "xNoHardIron", false, "X_NO_HARD_IRON");
        public final static Property YNoHardIron = new Property(2, float.class, "yNoHardIron", false, "Y_NO_HARD_IRON");
        public final static Property ZNoHardIron = new Property(3, float.class, "zNoHardIron", false, "Z_NO_HARD_IRON");
        public final static Property XEstimatedIronBias = new Property(4, float.class, "xEstimatedIronBias", false, "X_ESTIMATED_IRON_BIAS");
        public final static Property YEstimatedIronBias = new Property(5, float.class, "yEstimatedIronBias", false, "Y_ESTIMATED_IRON_BIAS");
        public final static Property ZEstimatedIronBias = new Property(6, float.class, "zEstimatedIronBias", false, "Z_ESTIMATED_IRON_BIAS");
        public final static Property Created = new Property(7, String.class, "created", false, "CREATED");
    };


    public MagneticFieldUncalibratedSensorDao(DaoConfig config) {
        super(config);
    }
    
    public MagneticFieldUncalibratedSensorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"magnetic_field_uncalibrated_sensor\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"X_NO_HARD_IRON\" REAL NOT NULL ," + // 1: xNoHardIron
                "\"Y_NO_HARD_IRON\" REAL NOT NULL ," + // 2: yNoHardIron
                "\"Z_NO_HARD_IRON\" REAL NOT NULL ," + // 3: zNoHardIron
                "\"X_ESTIMATED_IRON_BIAS\" REAL NOT NULL ," + // 4: xEstimatedIronBias
                "\"Y_ESTIMATED_IRON_BIAS\" REAL NOT NULL ," + // 5: yEstimatedIronBias
                "\"Z_ESTIMATED_IRON_BIAS\" REAL NOT NULL ," + // 6: zEstimatedIronBias
                "\"CREATED\" TEXT NOT NULL );"); // 7: created
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_magnetic_field_uncalibrated_sensor__id ON magnetic_field_uncalibrated_sensor" +
                " (\"_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"magnetic_field_uncalibrated_sensor\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MagneticFieldUncalibratedSensor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindDouble(2, entity.getXNoHardIron());
        stmt.bindDouble(3, entity.getYNoHardIron());
        stmt.bindDouble(4, entity.getZNoHardIron());
        stmt.bindDouble(5, entity.getXEstimatedIronBias());
        stmt.bindDouble(6, entity.getYEstimatedIronBias());
        stmt.bindDouble(7, entity.getZEstimatedIronBias());
        stmt.bindString(8, entity.getCreated());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MagneticFieldUncalibratedSensor readEntity(Cursor cursor, int offset) {
        MagneticFieldUncalibratedSensor entity = new MagneticFieldUncalibratedSensor( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getFloat(offset + 1), // xNoHardIron
            cursor.getFloat(offset + 2), // yNoHardIron
            cursor.getFloat(offset + 3), // zNoHardIron
            cursor.getFloat(offset + 4), // xEstimatedIronBias
            cursor.getFloat(offset + 5), // yEstimatedIronBias
            cursor.getFloat(offset + 6), // zEstimatedIronBias
            cursor.getString(offset + 7) // created
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MagneticFieldUncalibratedSensor entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setXNoHardIron(cursor.getFloat(offset + 1));
        entity.setYNoHardIron(cursor.getFloat(offset + 2));
        entity.setZNoHardIron(cursor.getFloat(offset + 3));
        entity.setXEstimatedIronBias(cursor.getFloat(offset + 4));
        entity.setYEstimatedIronBias(cursor.getFloat(offset + 5));
        entity.setZEstimatedIronBias(cursor.getFloat(offset + 6));
        entity.setCreated(cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MagneticFieldUncalibratedSensor entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MagneticFieldUncalibratedSensor entity) {
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
