package app.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

public class Exercise extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercise_view);
		
		 LinearLayout ll = new LinearLayout(this);
		    ll.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		    ll.setOrientation(LinearLayout.VERTICAL);

		 final TextView  tv = new TextView(this);
		    tv.setText("Animation");

		    final TranslateAnimation   moveLefttoRight = new TranslateAnimation(0, 200, 0, 0);
		    moveLefttoRight.setDuration(1000);
		    moveLefttoRight.setFillAfter(true);

		   Button button = new Button(this);
		    button.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		    button.setText("PressMe");
		    button.setOnClickListener(new OnClickListener() {

		        public void onClick(View v) {
		            tv.startAnimation(moveLefttoRight);
		        }

		    });

		    ll.addView(tv);
		    ll.addView(button);
		    setContentView(ll);
	}

	

	

}
