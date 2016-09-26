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
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "module".
*/
public class DbModuleDao extends AbstractDao<DbModule, Long> {

    public static final String TABLENAME = "module";

    /**
     * Properties of entity DbModule.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property PackageName = new Property(1, String.class, "packageName", false, "PACKAGE_NAME");
        public static final Property Title = new Property(2, String.class, "title", false, "TITLE");
        public static final Property LogoUrl = new Property(3, String.class, "logoUrl", false, "LOGO_URL");
        public static final Property DescriptionShort = new Property(4, String.class, "descriptionShort", false, "DESCRIPTION_SHORT");
        public static final Property DescriptionFull = new Property(5, String.class, "descriptionFull", false, "DESCRIPTION_FULL");
        public static final Property Copyright = new Property(6, String.class, "copyright", false, "COPYRIGHT");
        public static final Property SupportEmail = new Property(7, String.class, "supportEmail", false, "SUPPORT_EMAIL");
        public static final Property Active = new Property(8, boolean.class, "active", false, "ACTIVE");
        public static final Property Created = new Property(9, String.class, "created", false, "CREATED");
        public static final Property UserId = new Property(10, Long.class, "userId", false, "USER_ID");
    }

    private DaoSession daoSession;

    private Query<DbModule> dbUser_DbModuleListQuery;

    public DbModuleDao(DaoConfig config) {
        super(config);
    }
    
    public DbModuleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"module\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PACKAGE_NAME\" TEXT NOT NULL UNIQUE ," + // 1: packageName
                "\"TITLE\" TEXT," + // 2: title
                "\"LOGO_URL\" TEXT," + // 3: logoUrl
                "\"DESCRIPTION_SHORT\" TEXT," + // 4: descriptionShort
                "\"DESCRIPTION_FULL\" TEXT," + // 5: descriptionFull
                "\"COPYRIGHT\" TEXT," + // 6: copyright
                "\"SUPPORT_EMAIL\" TEXT," + // 7: supportEmail
                "\"ACTIVE\" INTEGER NOT NULL ," + // 8: active
                "\"CREATED\" TEXT NOT NULL ," + // 9: created
                "\"USER_ID\" INTEGER);"); // 10: userId
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_module__id ON module" +
                " (\"_id\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_module_ACTIVE ON module" +
                " (\"ACTIVE\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_module_USER_ID ON module" +
                " (\"USER_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"module\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DbModule entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getPackageName());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String logoUrl = entity.getLogoUrl();
        if (logoUrl != null) {
            stmt.bindString(4, logoUrl);
        }
 
        String descriptionShort = entity.getDescriptionShort();
        if (descriptionShort != null) {
            stmt.bindString(5, descriptionShort);
        }
 
        String descriptionFull = entity.getDescriptionFull();
        if (descriptionFull != null) {
            stmt.bindString(6, descriptionFull);
        }
 
        String copyright = entity.getCopyright();
        if (copyright != null) {
            stmt.bindString(7, copyright);
        }
 
        String supportEmail = entity.getSupportEmail();
        if (supportEmail != null) {
            stmt.bindString(8, supportEmail);
        }
        stmt.bindLong(9, entity.getActive() ? 1L: 0L);
        stmt.bindString(10, entity.getCreated());
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(11, userId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DbModule entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getPackageName());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String logoUrl = entity.getLogoUrl();
        if (logoUrl != null) {
            stmt.bindString(4, logoUrl);
        }
 
        String descriptionShort = entity.getDescriptionShort();
        if (descriptionShort != null) {
            stmt.bindString(5, descriptionShort);
        }
 
        String descriptionFull = entity.getDescriptionFull();
        if (descriptionFull != null) {
            stmt.bindString(6, descriptionFull);
        }
 
        String copyright = entity.getCopyright();
        if (copyright != null) {
            stmt.bindString(7, copyright);
        }
 
        String supportEmail = entity.getSupportEmail();
        if (supportEmail != null) {
            stmt.bindString(8, supportEmail);
        }
        stmt.bindLong(9, entity.getActive() ? 1L: 0L);
        stmt.bindString(10, entity.getCreated());
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(11, userId);
        }
    }

    @Override
    protected final void attachEntity(DbModule entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DbModule readEntity(Cursor cursor, int offset) {
        DbModule entity = new DbModule( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // packageName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // logoUrl
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // descriptionShort
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // descriptionFull
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // copyright
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // supportEmail
            cursor.getShort(offset + 8) != 0, // active
            cursor.getString(offset + 9), // created
            cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10) // userId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DbModule entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPackageName(cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLogoUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescriptionShort(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDescriptionFull(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCopyright(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSupportEmail(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setActive(cursor.getShort(offset + 8) != 0);
        entity.setCreated(cursor.getString(offset + 9));
        entity.setUserId(cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DbModule entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DbModule entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DbModule entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "dbModuleList" to-many relationship of DbUser. */
    public List<DbModule> _queryDbUser_DbModuleList(Long userId) {
        synchronized (this) {
            if (dbUser_DbModuleListQuery == null) {
                QueryBuilder<DbModule> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UserId.eq(null));
                dbUser_DbModuleListQuery = queryBuilder.build();
            }
        }
        Query<DbModule> query = dbUser_DbModuleListQuery.forCurrentThread();
        query.setParameter(0, userId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getDbUserDao().getAllColumns());
            builder.append(" FROM module T");
            builder.append(" LEFT JOIN user T0 ON T.\"USER_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected DbModule loadCurrentDeep(Cursor cursor, boolean lock) {
        DbModule entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        DbUser dbUser = loadCurrentOther(daoSession.getDbUserDao(), cursor, offset);
        entity.setDbUser(dbUser);

        return entity;    
    }

    public DbModule loadDeep(Long key) {
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
    public List<DbModule> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<DbModule> list = new ArrayList<>(count);
        
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
    
    protected List<DbModule> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<DbModule> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
