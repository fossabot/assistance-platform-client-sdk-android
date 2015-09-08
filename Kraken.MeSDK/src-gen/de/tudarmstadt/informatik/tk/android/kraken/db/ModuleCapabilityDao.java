package de.tudarmstadt.informatik.tk.android.kraken.db;

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

import de.tudarmstadt.informatik.tk.android.kraken.db.ModuleCapability;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "module_capability".
*/
public class ModuleCapabilityDao extends AbstractDao<ModuleCapability, Long> {

    public static final String TABLENAME = "module_capability";

    /**
     * Properties of entity ModuleCapability.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Type = new Property(1, String.class, "type", false, "TYPE");
        public final static Property Frequency = new Property(2, Double.class, "frequency", false, "FREQUENCY");
        public final static Property Required = new Property(3, boolean.class, "required", false, "REQUIRED");
        public final static Property Created = new Property(4, String.class, "created", false, "CREATED");
        public final static Property Module_id = new Property(5, Long.class, "module_id", false, "MODULE_ID");
    };

    private DaoSession daoSession;

    private Query<ModuleCapability> module_ModuleCapabilityListQuery;

    public ModuleCapabilityDao(DaoConfig config) {
        super(config);
    }
    
    public ModuleCapabilityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"module_capability\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TYPE\" TEXT NOT NULL ," + // 1: type
                "\"FREQUENCY\" REAL," + // 2: frequency
                "\"REQUIRED\" INTEGER NOT NULL ," + // 3: required
                "\"CREATED\" TEXT NOT NULL ," + // 4: created
                "\"MODULE_ID\" INTEGER);"); // 5: module_id
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_module_capability__id ON module_capability" +
                " (\"_id\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_module_capability_TYPE ON module_capability" +
                " (\"TYPE\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_module_capability_MODULE_ID ON module_capability" +
                " (\"MODULE_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"module_capability\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ModuleCapability entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getType());
 
        Double frequency = entity.getFrequency();
        if (frequency != null) {
            stmt.bindDouble(3, frequency);
        }
        stmt.bindLong(4, entity.getRequired() ? 1L: 0L);
        stmt.bindString(5, entity.getCreated());
 
        Long module_id = entity.getModule_id();
        if (module_id != null) {
            stmt.bindLong(6, module_id);
        }
    }

    @Override
    protected void attachEntity(ModuleCapability entity) {
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
    public ModuleCapability readEntity(Cursor cursor, int offset) {
        ModuleCapability entity = new ModuleCapability( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // type
            cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2), // frequency
            cursor.getShort(offset + 3) != 0, // required
            cursor.getString(offset + 4), // created
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // module_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ModuleCapability entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setType(cursor.getString(offset + 1));
        entity.setFrequency(cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2));
        entity.setRequired(cursor.getShort(offset + 3) != 0);
        entity.setCreated(cursor.getString(offset + 4));
        entity.setModule_id(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ModuleCapability entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ModuleCapability entity) {
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
    
    /** Internal query to resolve the "moduleCapabilityList" to-many relationship of Module. */
    public List<ModuleCapability> _queryModule_ModuleCapabilityList(Long module_id) {
        synchronized (this) {
            if (module_ModuleCapabilityListQuery == null) {
                QueryBuilder<ModuleCapability> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Module_id.eq(null));
                module_ModuleCapabilityListQuery = queryBuilder.build();
            }
        }
        Query<ModuleCapability> query = module_ModuleCapabilityListQuery.forCurrentThread();
        query.setParameter(0, module_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getModuleDao().getAllColumns());
            builder.append(" FROM module_capability T");
            builder.append(" LEFT JOIN module T0 ON T.\"MODULE_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ModuleCapability loadCurrentDeep(Cursor cursor, boolean lock) {
        ModuleCapability entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Module module = loadCurrentOther(daoSession.getModuleDao(), cursor, offset);
        entity.setModule(module);

        return entity;    
    }

    public ModuleCapability loadDeep(Long key) {
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
    public List<ModuleCapability> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ModuleCapability> list = new ArrayList<ModuleCapability>(count);
        
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
    
    protected List<ModuleCapability> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ModuleCapability> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
