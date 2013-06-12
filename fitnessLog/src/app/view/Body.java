package app.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.Intent;

public class Body extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.body);
		
		configureImage();
	}

	private void configureImage() {
		Button image = (Button) findViewById(R.id.submitButton);
		image.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent action = new Intent(Body.this,UpdateView.class);
				startActivity(action);
			}
		});
		
	}

}
