package de.tudarmstadt.informatik.tk.android.kraken.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.android.kraken.db.DbBrowserHistoryEvent;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "browser_history_event".
*/
public class DbBrowserHistoryEventDao extends AbstractDao<DbBrowserHistoryEvent, Long> {

    public static final String TABLENAME = "browser_history_event";

    /**
     * Properties of entity DbBrowserHistoryEvent.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property LastVisited = new Property(3, Long.class, "lastVisited", false, "LAST_VISITED");
        public final static Property Visits = new Property(4, Integer.class, "visits", false, "VISITS");
        public final static Property Bookmark = new Property(5, Boolean.class, "bookmark", false, "BOOKMARK");
        public final static Property IsNew = new Property(6, Boolean.class, "isNew", false, "IS_NEW");
        public final static Property IsUpdated = new Property(7, Boolean.class, "isUpdated", false, "IS_UPDATED");
        public final static Property IsDeleted = new Property(8, Boolean.class, "isDeleted", false, "IS_DELETED");
        public final static Property Created = new Property(9, String.class, "created", false, "CREATED");
    };


    public DbBrowserHistoryEventDao(DaoConfig config) {
        super(config);
    }
    
    public DbBrowserHistoryEventDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"browser_history_event\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"URL\" TEXT," + // 1: url
                "\"TITLE\" TEXT," + // 2: title
                "\"LAST_VISITED\" INTEGER," + // 3: lastVisited
                "\"VISITS\" INTEGER," + // 4: visits
                "\"BOOKMARK\" INTEGER," + // 5: bookmark
                "\"IS_NEW\" INTEGER," + // 6: isNew
                "\"IS_UPDATED\" INTEGER," + // 7: isUpdated
                "\"IS_DELETED\" INTEGER," + // 8: isDeleted
                "\"CREATED\" TEXT NOT NULL );"); // 9: created
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_browser_history_event__id ON browser_history_event" +
                " (\"_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"browser_history_event\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DbBrowserHistoryEvent entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        Long lastVisited = entity.getLastVisited();
        if (lastVisited != null) {
            stmt.bindLong(4, lastVisited);
        }
 
        Integer visits = entity.getVisits();
        if (visits != null) {
            stmt.bindLong(5, visits);
        }
 
        Boolean bookmark = entity.getBookmark();
        if (bookmark != null) {
            stmt.bindLong(6, bookmark ? 1L: 0L);
        }
 
        Boolean isNew = entity.getIsNew();
        if (isNew != null) {
            stmt.bindLong(7, isNew ? 1L: 0L);
        }
 
        Boolean isUpdated = entity.getIsUpdated();
        if (isUpdated != null) {
            stmt.bindLong(8, isUpdated ? 1L: 0L);
        }
 
        Boolean isDeleted = entity.getIsDeleted();
        if (isDeleted != null) {
            stmt.bindLong(9, isDeleted ? 1L: 0L);
        }
        stmt.bindString(10, entity.getCreated());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DbBrowserHistoryEvent readEntity(Cursor cursor, int offset) {
        DbBrowserHistoryEvent entity = new DbBrowserHistoryEvent( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // lastVisited
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // visits
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // bookmark
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0, // isNew
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0, // isUpdated
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // isDeleted
            cursor.getString(offset + 9) // created
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DbBrowserHistoryEvent entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLastVisited(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setVisits(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setBookmark(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setIsNew(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
        entity.setIsUpdated(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
        entity.setIsDeleted(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setCreated(cursor.getString(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DbBrowserHistoryEvent entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DbBrowserHistoryEvent entity) {
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
