package app.model;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;





import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

public class dbAdapter {
	public static final String KEY_ID ="id";
	public static final String KEY_CATEGORY = "category";
	public static final String KEY_NAME = "name";
	public static final String KEY_REP = "rep";
	public static final String KEY_SET = "set";
	public static final String KEY_UNIT ="unit";
	public static final String KEY_DATE ="date";
	
	private static final String DATABASE_NAME ="fitLog";
	private static final String DATABASE_TABLE_EXERCISE = "Exercise";
	private static final String DATABASE_TABLE_TRAINNING = "Trainning";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_PATH = "/data/data/app.view/databases/";
	
	 private final Context context;
	
	private static final String TABLE_CREATE_EXERCISE = 
			"CREATE TABLE if not exists Exercise (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , category VARCHAR, name VARCHAR)";
	private static final String TABLE_CREATE_TRAINNING = 
			"CREATE TABLE if not exists Trainning (id INTEGER, rep INTEGER, set VARCHAR, unit VARCHAR, " +
			"date VARCHAR, FOREIGN KEY (id) REFERENCES Exercise(id))";
	
	
	
	public static SQLiteDatabase db;
	private DatabaseHelper DBHelper;
	
	public dbAdapter(Context ctx){
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	
	public class DatabaseHelper extends SQLiteOpenHelper{
		 
		//The Android's default system path of your application database.
		private static final String DB_PATH = "/data/data/app.view/databases/";
		private static final String DB_NAME = "fitLog";
		private SQLiteDatabase myDataBase;
	
		 
		/**
		  * Constructor
		  * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
		  * @param context
		  */
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}	
		 
		/**
		  * Creates a empty database on the system and rewrites it with your own database.
		  * */
		public void createDataBase() throws IOException{
			boolean dbExist = checkDataBase();
		 
			if(dbExist){
				
			}else{
				//By calling this method and empty database will be created into the default system path
				//of your application so we are gonna be able to overwrite that database with our database.
				DBHelper.getWritableDatabase();
				try {
					copyDataBase();
				} catch (IOException e) {
					throw new Error("Error copying database");
				}
			}
		}
		 
		/**
		  * Check if the database already exist to avoid re-copying the file each time you open the application.
		  * @return true if it exists, false if it doesn't
		  */
		private boolean checkDataBase(){
			/*SQLiteDatabase checkDB = null;
			try{
				String myPath = DB_PATH + DB_NAME;
				checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
				}catch(SQLiteException e){
					throw new Error("DATABASE IS NOT EXIST!!!!");
				}
			if(checkDB != null){
				checkDB.close();
			}
			return checkDB != null ? true : false;*/
			
			File dbFile= context.getDatabasePath(DB_NAME);
		    return dbFile.exists();
		}
		 
		/**
		  * Copies your database from your local assets-folder to the just created empty database in the
		  * system folder, from where it can be accessed and handled.
		  * This is done by transfering bytestream.
		  * */
		private void copyDataBase() throws IOException{
		 
			//Open your local db as the input stream
			InputStream myInput = context.getAssets().open(DB_NAME + ".sqlite");
			 
			// Path to the just created empty db
			String outFileName = DB_PATH + DB_NAME;
			 
			//Open the empty db as the output stream
			OutputStream myOutput = new FileOutputStream(outFileName);
			 
			//transfer bytes from the inputfile to the outputfile
			byte[] buffer = new byte[1024];
			int length;
			while ((length = myInput.read(buffer))>0){
			myOutput.write(buffer, 0, length);
			}
			 
			//Close the streams
			myOutput.flush();
			myOutput.close();
			myInput.close();
		 
		}
		 
		public void openDataBase() throws SQLException{
		 
		//Open the database
			String myPath = DB_PATH + DB_NAME;
			db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
		
		}
		 
		@Override
		public synchronized void close() {
			if(myDataBase != null)
				myDataBase.close();
			super.close();
		}
		 
		@Override
		public void onCreate(SQLiteDatabase db) {
		 
		}
		 
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 
		}
	}
	 public dbAdapter open() throws SQLException 
	    {
		 try {
			 
				DBHelper.createDataBase();
				  
				 } catch (IOException ioe) {
				  
				 throw new Error("Unable to create database");
				  
				 }
				  
				try {
				  
				 DBHelper.openDataBase();
				  
				 }catch(SQLException sqle){
				  
				 throw sqle;
				  
				 }
			return this;
	    }
	 
	 public void close(){
		 DBHelper.close();
	 }
	 
	 public Cursor getExerciseListByCategory(String group)
	 {
		 Cursor c = db.rawQuery("Select id, name " +
		 			 			"From Exercise natural join Category " +
		 			 			"Where \"group\" = '" + group + "'", null);
		 return c;
	 }
}