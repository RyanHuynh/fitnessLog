package app.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
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
		addExerciseEntry();
		configureAddExerciseButton();
		dbA.close();
	}
	
	//Populate list of exercise from database.
	public void addExerciseEntry()
	{
		TableLayout tl = (TableLayout) findViewById(R.id.exerciseList);
		Cursor c = dbA.getExerciseListByCategory("Chest");
		c.moveToFirst();
		while(!c.isAfterLast())
		{
			TableRow tr = new TableRow(this);
			
			TextView exerciseName = new TextView(this);
			exerciseName.setText(c.getString(c.getColumnIndex("name")));
			
			EditText input = new EditText(this);
			
			Spinner rep = new Spinner(this);
			ArrayAdapter<CharSequence> adp = ArrayAdapter.createFromResource(this, R.array.rep_set, android.R.layout.simple_list_item_1);
			adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        rep.setAdapter(adp);
	        
	        tr.addView(exerciseName);
	        tr.addView(input);
	        tr.addView(rep);
	        tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	        c.moveToNext();
		}
	}
	
	//Configure the add exercise button
	public void configureAddExerciseButton(){
		Button addExercise = (Button) findViewById(R.id.addExercise);
		addExercise.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				dbA.db.execSQL("INSERT INTO Exercise(name)  Values (\"JUST TEST !!\")");
				
			Cursor c = dbA.db.rawQuery("select * from Exercise", null);
				c.moveToLast();
				Log.d("Result", c.getString(c.getColumnIndex("name")));
				
				
			}
		});
		
	}
}
