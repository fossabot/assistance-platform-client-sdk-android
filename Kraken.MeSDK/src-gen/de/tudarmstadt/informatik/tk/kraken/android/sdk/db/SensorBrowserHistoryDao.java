package de.tudarmstadt.informatik.tk.kraken.android.sdk.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.tudarmstadt.informatik.tk.kraken.android.sdk.db.SensorBrowserHistory;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SENSOR_BROWSER_HISTORY.
*/
public class SensorBrowserHistoryDao extends AbstractDao<SensorBrowserHistory, Long> {

    public static final String TABLENAME = "SENSOR_BROWSER_HISTORY";

    /**
     * Properties of entity SensorBrowserHistory.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property HistoryId = new Property(1, Long.class, "historyId", false, "HISTORY_ID");
        public final static Property Url = new Property(2, String.class, "url", false, "URL");
        public final static Property Title = new Property(3, String.class, "title", false, "TITLE");
        public final static Property LastVisited = new Property(4, Long.class, "lastVisited", false, "LAST_VISITED");
        public final static Property Visits = new Property(5, Integer.class, "visits", false, "VISITS");
        public final static Property Bookmark = new Property(6, Boolean.class, "bookmark", false, "BOOKMARK");
        public final static Property Timestamp = new Property(7, Long.class, "timestamp", false, "TIMESTAMP");
        public final static Property IsNew = new Property(8, Boolean.class, "isNew", false, "IS_NEW");
        public final static Property IsUpdated = new Property(9, Boolean.class, "isUpdated", false, "IS_UPDATED");
        public final static Property IsDeleted = new Property(10, Boolean.class, "isDeleted", false, "IS_DELETED");
    };


    public SensorBrowserHistoryDao(DaoConfig config) {
        super(config);
    }
    
    public SensorBrowserHistoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SENSOR_BROWSER_HISTORY' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'HISTORY_ID' INTEGER," + // 1: historyId
                "'URL' TEXT," + // 2: url
                "'TITLE' TEXT," + // 3: title
                "'LAST_VISITED' INTEGER," + // 4: lastVisited
                "'VISITS' INTEGER," + // 5: visits
                "'BOOKMARK' INTEGER," + // 6: bookmark
                "'TIMESTAMP' INTEGER," + // 7: timestamp
                "'IS_NEW' INTEGER," + // 8: isNew
                "'IS_UPDATED' INTEGER," + // 9: isUpdated
                "'IS_DELETED' INTEGER);"); // 10: isDeleted
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SENSOR_BROWSER_HISTORY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SensorBrowserHistory entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long historyId = entity.getHistoryId();
        if (historyId != null) {
            stmt.bindLong(2, historyId);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(3, url);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(4, title);
        }
 
        Long lastVisited = entity.getLastVisited();
        if (lastVisited != null) {
            stmt.bindLong(5, lastVisited);
        }
 
        Integer visits = entity.getVisits();
        if (visits != null) {
            stmt.bindLong(6, visits);
        }
 
        Boolean bookmark = entity.getBookmark();
        if (bookmark != null) {
            stmt.bindLong(7, bookmark ? 1l: 0l);
        }
 
        Long timestamp = entity.getTimestamp();
        if (timestamp != null) {
            stmt.bindLong(8, timestamp);
        }
 
        Boolean isNew = entity.getIsNew();
        if (isNew != null) {
            stmt.bindLong(9, isNew ? 1l: 0l);
        }
 
        Boolean isUpdated = entity.getIsUpdated();
        if (isUpdated != null) {
            stmt.bindLong(10, isUpdated ? 1l: 0l);
        }
 
        Boolean isDeleted = entity.getIsDeleted();
        if (isDeleted != null) {
            stmt.bindLong(11, isDeleted ? 1l: 0l);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SensorBrowserHistory readEntity(Cursor cursor, int offset) {
        SensorBrowserHistory entity = new SensorBrowserHistory( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // historyId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // url
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // title
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // lastVisited
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // visits
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0, // bookmark
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // timestamp
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // isNew
            cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0, // isUpdated
            cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0 // isDeleted
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SensorBrowserHistory entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setHistoryId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUrl(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTitle(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLastVisited(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setVisits(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setBookmark(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
        entity.setTimestamp(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setIsNew(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setIsUpdated(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0);
        entity.setIsDeleted(cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(SensorBrowserHistory entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(SensorBrowserHistory entity) {
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