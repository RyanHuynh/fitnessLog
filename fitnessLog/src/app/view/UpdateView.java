package app.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.app.Activity;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import app.model.dbAdapter;

public class UpdateView extends Activity {
	
	dbAdapter dbA = new dbAdapter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_view);
		
		tagAnimation();
	
		
		/*dbA.open();
		addExerciseEntry();
		configureAddExerciseButton();
		dbA.close();*/
	}
	
	private void tagAnimation()
	{
		Bundle extra = getIntent().getExtras();
		ArrayList<String> list = extra.getStringArrayList("TAG_MAP");
		AnimationDrawable animation = new AnimationDrawable();
		for(String tagName: list)
		{
			if(tagName.equals("Shoulder"))
				animation.addFrame(getResources().getDrawable(R.drawable.shoulder_text), 3000);
			else if(tagName.equals("Back"))
				animation.addFrame(getResources().getDrawable(R.drawable.back_text), 3000);
			else if(tagName.equals("Upper Back"))
				animation.addFrame(getResources().getDrawable(R.drawable.upperback_text), 3000);
		}
		ImageView textAnimation = (ImageView) findViewById(R.id.textAnimation);
		textAnimation.setBackground(animation);
		animation.setOneShot(false);
		animation.start();
		
	}
}
