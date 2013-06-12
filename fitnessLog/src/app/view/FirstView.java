package app.view;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstView extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		//Main menu buttons
		Button updateB = (Button)findViewById(R.id.updateButton);
		updateB.setOnClickListener(this);
		
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent actionChoice = new Intent(FirstView.this,Body.class);
		startActivity(actionChoice);
	}

}
