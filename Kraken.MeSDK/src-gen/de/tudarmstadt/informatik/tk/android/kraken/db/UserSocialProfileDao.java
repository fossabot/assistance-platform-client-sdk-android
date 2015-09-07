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

import de.tudarmstadt.informatik.tk.android.kraken.db.UserSocialProfile;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "user_social_profile".
*/
public class UserSocialProfileDao extends AbstractDao<UserSocialProfile, Long> {

    public static final String TABLENAME = "user_social_profile";

    /**
     * Properties of entity UserSocialProfile.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Firstname = new Property(2, String.class, "firstname", false, "FIRSTNAME");
        public final static Property Lastname = new Property(3, String.class, "lastname", false, "LASTNAME");
        public final static Property Email = new Property(4, String.class, "email", false, "EMAIL");
        public final static Property Updated = new Property(5, String.class, "updated", false, "UPDATED");
        public final static Property Created = new Property(6, String.class, "created", false, "CREATED");
        public final static Property User_id = new Property(7, long.class, "user_id", false, "USER_ID");
    };

    private DaoSession daoSession;

    private Query<UserSocialProfile> user_UserSocialProfileListQuery;

    public UserSocialProfileDao(DaoConfig config) {
        super(config);
    }
    
    public UserSocialProfileDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"user_social_profile\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"FIRSTNAME\" TEXT," + // 2: firstname
                "\"LASTNAME\" TEXT," + // 3: lastname
                "\"EMAIL\" TEXT," + // 4: email
                "\"UPDATED\" TEXT," + // 5: updated
                "\"CREATED\" TEXT NOT NULL ," + // 6: created
                "\"USER_ID\" INTEGER NOT NULL );"); // 7: user_id
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_user_social_profile__id ON user_social_profile" +
                " (\"_id\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_user_social_profile_USER_ID ON user_social_profile" +
                " (\"USER_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"user_social_profile\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, UserSocialProfile entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String firstname = entity.getFirstname();
        if (firstname != null) {
            stmt.bindString(3, firstname);
        }
 
        String lastname = entity.getLastname();
        if (lastname != null) {
            stmt.bindString(4, lastname);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(5, email);
        }
 
        String updated = entity.getUpdated();
        if (updated != null) {
            stmt.bindString(6, updated);
        }
        stmt.bindString(7, entity.getCreated());
        stmt.bindLong(8, entity.getUser_id());
    }

    @Override
    protected void attachEntity(UserSocialProfile entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public UserSocialProfile readEntity(Cursor cursor, int offset) {
        UserSocialProfile entity = new UserSocialProfile( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // firstname
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // lastname
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // email
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // updated
            cursor.getString(offset + 6), // created
            cursor.getLong(offset + 7) // user_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, UserSocialProfile entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFirstname(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLastname(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEmail(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUpdated(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCreated(cursor.getString(offset + 6));
        entity.setUser_id(cursor.getLong(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(UserSocialProfile entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(UserSocialProfile entity) {
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
    
    /** Internal query to resolve the "userSocialProfileList" to-many relationship of User. */
    public List<UserSocialProfile> _queryUser_UserSocialProfileList(long user_id) {
        synchronized (this) {
            if (user_UserSocialProfileListQuery == null) {
                QueryBuilder<UserSocialProfile> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.User_id.eq(null));
                user_UserSocialProfileListQuery = queryBuilder.build();
            }
        }
        Query<UserSocialProfile> query = user_UserSocialProfileListQuery.forCurrentThread();
        query.setParameter(0, user_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(" FROM user_social_profile T");
            builder.append(" LEFT JOIN user T0 ON T.\"USER_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected UserSocialProfile loadCurrentDeep(Cursor cursor, boolean lock) {
        UserSocialProfile entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
         if(user != null) {
            entity.setUser(user);
        }

        return entity;    
    }

    public UserSocialProfile loadDeep(Long key) {
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
    public List<UserSocialProfile> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<UserSocialProfile> list = new ArrayList<UserSocialProfile>(count);
        
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
    
    protected List<UserSocialProfile> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<UserSocialProfile> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
