package app.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.database.Cursor;
import app.model.dbAdapter;

public class UpdateView extends Activity {
	
	dbAdapter dbA = new dbAdapter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_view);
		
		dbA.open();
		Cursor c = dbA.getExerciseListByCategory("Back");
		c.moveToFirst();
		Log.d("result",c.getString(c.getColumnIndex("name")));
		//dbA.close();
	                
	}
}
