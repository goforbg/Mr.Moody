package com.androar.mr_moody;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MoodsDB {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_MOOD = "_mood";
    public static final String KEY_REASON = "_reason";
    public static final String KEY_TIME = "_time";

    public static final String DATABASE_NAME = "MoodsDB.db";
    public static final String DATABASE_TABLE = "MoodsTable";
    private int DATABASE_VERSION = 1;

    private DBHelper ourhelper;
    private final Context ourcontext;
    private SQLiteDatabase ourDatabase;

    public MoodsDB (Context context) {
        ourcontext = context;
    }

    private class DBHelper extends SQLiteOpenHelper {

        private DBHelper (Context context) {
            super (context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE );
            onCreate(sqLiteDatabase);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            //CREATE TABLE MoodsTable (_id INTEGER PRIMARY KEY AUTOINCREMENT, KEY_MOOD TEXT NOT NULL, KEY_TIME TEXT NOT NULL,
            //        KEY_REASON TEXT NOT NULL);

            String sqlCode = "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + KEY_MOOD + " TEXT NOT NULL,"
                    + KEY_TIME + " TEXT NOT NULL,"
                    + KEY_REASON + " TEXT NOT NULL " + ") ";

            sqLiteDatabase.execSQL(sqlCode);
            Log.i("time", "created db aravind");

        }

    }

    public MoodsDB open () throws SQLException {
        ourhelper = new DBHelper (ourcontext);
        ourDatabase = ourhelper.getWritableDatabase();

        return this;
    }

    public void close() {
        ourhelper.close();
    }


    public long createEntry (String mood, String reason, String time)
    {
        ContentValues cv = new ContentValues();
        cv.put (KEY_MOOD, mood);
        cv.put (KEY_REASON, reason);
        cv.put (KEY_TIME, time);
        return ourDatabase.insert (DATABASE_TABLE, null, cv);
    }

    public String getDBMood()
    {
        Cursor c = ourDatabase.rawQuery(" SELECT *  FROM " + DATABASE_TABLE , null);
        int iMood = c.getColumnIndex(KEY_MOOD);
        String result = "";
        for (c.moveToFirst() ; !c.isAfterLast(); c.moveToNext()) {
            result = result + c.getString(iMood);
        }
        return result;
    }

    public String getDBReason()
    {
        /*String [] columns = new String[] {KEY_ROWID, KEY_MOOD, KEY_REASON, KEY_TIME};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null,
                null, null,null );
        String result ="";
        int iRowID = c.getColumnIndex(KEY_ROWID);
        int iMood = c.getColumnIndex(KEY_MOOD);
        int iReason = c.getColumnIndex(KEY_REASON);
        int iTime = c.getColumnIndex(KEY_TIME);

        for (c.moveToFirst() ; !c.isAfterLast(); c.moveToNext()) {
            result = result + c.getString(iReason);
        }

        c.close();

        return result; */

        Cursor c = ourDatabase.rawQuery(" SELECT *  FROM " + DATABASE_TABLE , null);
        int iReason = c.getColumnIndex(KEY_REASON);
        String result = "";
        for (c.moveToFirst() ; !c.isAfterLast(); c.moveToNext()) {
            result = result + c.getString(iReason);
        }
        return result;
    }

    public String getDBTime()
    {
        Cursor c = ourDatabase.rawQuery(" SELECT *  FROM " + DATABASE_TABLE , null);
        int iTime = c.getColumnIndex(KEY_TIME);
        String result = "";
        for (c.moveToFirst() ; !c.isAfterLast(); c.moveToNext()) {
            result = result + c.getString(iTime);
        }
        return result;
    }

    public long deleteEntry (String rowId) {
        return ourDatabase.delete (DATABASE_TABLE, KEY_ROWID + "=?", new String[] {rowId});
    }

}
