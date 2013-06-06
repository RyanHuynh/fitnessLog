package app.view;

import android.os.Bundle;
import android.view.View;
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
		ImageButton image = (ImageButton) findViewById(R.id.body);
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
