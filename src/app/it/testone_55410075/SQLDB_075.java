package app.it.testone_55410075;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.integer;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLDB_075 extends SQLiteOpenHelper {
	private String strUser, strName, strScore, strGrade;
	private static final String DATABASE_NAME = "kobboonmydata075";
	private static final String TABLE_KOBBOON = "kobboon";
	private static final int DATABASE_VERSION = 1;

	public SQLDB_075(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_KOBBOON
				+ "(UserID INTEGER PRIMARY KEY," + "Name   TEXT(100),"
				+ "Score  TEXT(100)," + "Grade  TEXT(100));");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS  " + TABLE_KOBBOON);
		onCreate(db);

	}

	public long InsertData(String strUser, String strName, String strScore,
			String strGrade) {
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("UserID",strUser);
			values.put("Name",strName);
			values.put("Score",strScore);
			values.put("Grade",strGrade);
			long l = db.insert(TABLE_KOBBOON, null, values);
			db.close();
			return l ;
		} catch (Exception e) {

			return -1;

		}

	}
	public ArrayList<HashMap<String, String>> SelectAllData() {
		try {
			ArrayList<HashMap<String, String>> arrayList =  
				     new ArrayList<HashMap<String, String>>(); 
			HashMap<String, String> map; 
			   SQLiteDatabase db; 
			   db = this.getReadableDatabase(); 
			   
			   
			   String strSQl = "SELECT * FROM  "+ TABLE_KOBBOON; 
			   
			   Cursor cursor  =   db.rawQuery(strSQl, null); 
			   if(cursor!=null){
				   if (cursor.moveToFirst()){
					   
					   do {
						   map= new HashMap<String, String>(); 
						   map.put("UserID", cursor.getString(0)); 
						   map.put("Name", cursor.getString(1)); 
						   map.put("Score", cursor.getString(2)); 
						   map.put("Grade", cursor.getString(3)); 
						 
						   arrayList.add(map);  
						   
					} while (cursor.moveToNext());
				   }
			   }
			   cursor.close();
			   db.close(); 
			   return arrayList; 
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}


}
