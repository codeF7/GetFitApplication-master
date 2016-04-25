package com.example.gabe.getfitapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyAdapter {

	private static final String TAG = "MyAdapter";
	public static final String KEY_ROWID = "_id";
	public static final String KEY_TASK = "task";
	public static final String KEY_DATE = "date";
	
	public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_TASK, KEY_DATE};
	

	public static final String DATABASE_NAME = "dbToDo";
	public static final String DATABASE_TABLE = "mainToDo";
	public static final int DATABASE_VERSION = 2;
		

	private static final String DATABASE_CREATE_SQL = 
			"CREATE TABLE " + DATABASE_TABLE 
			+ " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ KEY_TASK + " TEXT NOT NULL, "
			+ KEY_DATE + " TEXT"
			+ ");";
	
	private final Context context;
	private DatabaseHelper myDBHelper;
	private SQLiteDatabase db;


	public MyAdapter(Context ctx) {
		this.context = ctx;
		myDBHelper = new DatabaseHelper(context);
	}
	

	public MyAdapter open() {
		db = myDBHelper.getWritableDatabase();
		return this;
	}
	

	public long insertRow(String task, String date) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_TASK, task);
		initialValues.put(KEY_DATE, date);
		return db.insert(DATABASE_TABLE, null, initialValues);
	}
	

	public boolean deleteRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		return db.delete(DATABASE_TABLE, where, null) != 0;
	}
	
	public void deleteAll() {
		Cursor c = getAllRows();
		long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
		if (c.moveToFirst()) {
			do {
				deleteRow(c.getLong((int) rowId));				
			} while (c.moveToNext());
		}
		c.close();
	}

	public Cursor getAllRows() {
		String where = null;
		String whereArgs[] = null;
		String groupBy = null;
		String having = null;
		String order = null;
		Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS, where, whereArgs, groupBy, having, order, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase _db)
		{
			_db.execSQL(DATABASE_CREATE_SQL);
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion)
		{
			Log.w(TAG, "Upgrading application's database from version " + oldVersion
					+ " to " + newVersion + ", which will destroy all old data!");

			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

			onCreate(_db);
		}
	}


}

