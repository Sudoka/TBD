package com.example.cs110;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter 
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TYPE = "type";
    public static final String KEY_ORIGIN = "origin";    
    private static final String TAG = "DBAdapter";
    
    private static final String DATABASE_NAME = "wine";
    private static final String DATABASE_TABLE = "wines";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
        "create table wines (_id integer primary key autoincrement, "
        + "name text not null, type text not null, " 
        + "origin text not null);";
        
    private final Context context; 
    
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS wines");
            onCreate(db);
        }
    }    
    
    //opens the database
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //closes the database
    public void close() 
    {
        DBHelper.close();
    }
    
    //insert a wine into the database
    public long insertWine(String name, String type, String origin) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_TYPE, type);
        initialValues.put(KEY_ORIGIN, origin);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //deletes a particular wine
    public boolean deleteWine(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + 
        		"=" + rowId, null) > 0;
    }

    //retrieves all the wines
    public Cursor getAllWines() 
    {
        return db.query(DATABASE_TABLE, new String[] {
        		KEY_ROWID, 
        		KEY_NAME,
        		KEY_TYPE,
                KEY_ORIGIN}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }

    //retrieves a particular wine
    public Cursor getWine(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_ROWID,
                		KEY_NAME, 
                		KEY_TYPE,
                		KEY_ORIGIN
                		}, 
                		KEY_ROWID + "=" + rowId, 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //updates a wine
    public boolean updateWine(long rowId, String name, 
    String type, String origin) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_TYPE, type);
        args.put(KEY_ORIGIN, origin);
        return db.update(DATABASE_TABLE, args, 
                         KEY_ROWID + "=" + rowId, null) > 0;
    }
}