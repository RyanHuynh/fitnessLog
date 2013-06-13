package app.view;

import java.util.HashMap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.widget.ViewSwitcher;

public class Body extends Activity implements View.OnClickListener{
	
	HashMap <String, Integer> tagMap = new HashMap<String,Integer>();
	Button shoulderTag;
	Button shoulderTag2;
	Button pecsTag;
	Button bicepTag;
	Button obliquesTag;
	Button hamstringTag;
	Button absTag;
	Button forearmTag;
	Button thighTag;
	Button soleusTag;
	Button upperbackTag;
	Button backTag;
	Button lowerbackTag;
	Button glutealTag;
	Button calfTag;
	Button tricepTag;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.body);
		
		//Initiation
		createTagMap();
		setup();
	}

	
	
	private void setup()
	{
		Button submit = (Button) findViewById(R.id.submitButton);
		submit.setOnClickListener(this);
		Button rotate = (Button) findViewById(R.id.rotateButton);
		rotate.setOnClickListener(this);
		
		//Shoulder
		shoulderTag = (Button) findViewById(R.id.shoulderButton);
		shoulderTag.setOnClickListener(this);
		shoulderTag2 = (Button) findViewById(R.id.shoulderButton2);
		shoulderTag2.setOnClickListener(this);
		
		//Pecs
		pecsTag = (Button) findViewById(R.id.pecsButton);
		pecsTag.setOnClickListener(this);
		
		//Biceps
		bicepTag = (Button) findViewById(R.id.bicepsButton);
		bicepTag.setOnClickListener(this);
		
		//Obliques
		obliquesTag = (Button) findViewById(R.id.obliquesButton);
		obliquesTag.setOnClickListener(this);
	
		//Forearm
		forearmTag = (Button) findViewById(R.id.forearmButton);
		forearmTag.setOnClickListener(this);
		
		//Abs
		absTag = (Button) findViewById(R.id.absButton);
		absTag.setOnClickListener(this);
		
		//Soleus
		soleusTag = (Button) findViewById(R.id.soleusButton);
		soleusTag.setOnClickListener(this);
		
		//Thighs
		thighTag = (Button) findViewById(R.id.thighsButton);
		thighTag.setOnClickListener(this);
		
		//Upper Back
		upperbackTag = (Button) findViewById(R.id.upperbackButton);
		upperbackTag.setOnClickListener(this);
	
		//Back
		backTag = (Button) findViewById(R.id.backButton);
		backTag.setOnClickListener(this);
		
		//Lower Back
		lowerbackTag = (Button) findViewById(R.id.lowerbackButton);
		lowerbackTag.setOnClickListener(this);
		
		//Gluteals
		glutealTag = (Button) findViewById(R.id.glutealsButton);
		glutealTag.setOnClickListener(this);
			
		//Calf
		calfTag = (Button) findViewById(R.id.calfButton);
		calfTag.setOnClickListener(this);
		
		//Hamstring
		hamstringTag = (Button) findViewById(R.id.hamstringButton);
		hamstringTag.setOnClickListener(this);
		
		//Tricep
		tricepTag = (Button) findViewById(R.id.tricepButton);
		tricepTag.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.submitButton:
				Intent action = new Intent(Body.this,UpdateView.class);
				startActivity(action);
				break;
			case R.id.rotateButton:
				ViewSwitcher view = (ViewSwitcher) findViewById(R.id.switcher);
				view.showNext();
				break;
			case R.id.shoulderButton :
			case R.id.shoulderButton2 :
				if(tagMap.get("Shoulder") == 0)
				{
						shoulderTag.setBackgroundResource(R.drawable.tagon);
						shoulderTag2.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Shoulder", 1);
				}
				else{
					shoulderTag.setBackgroundResource(R.drawable.tagoff);
					shoulderTag2.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Shoulder", 0);
				}
				break;
			case R.id.pecsButton:
				if(tagMap.get("Pecs") == 0)
				{
						pecsTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Pecs", 1);
				}
				else{
					pecsTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Pecs", 0);
				}
				break;
			case R.id.bicepsButton:
				if(tagMap.get("Biceps") == 0)
				{
						bicepTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Biceps", 1);
				}
				else{
					bicepTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Biceps", 0);
				}
				break;
			case R.id.obliquesButton:
				if(tagMap.get("Obliques") == 0)
				{
						obliquesTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Obliques", 1);
				}
				else{
					obliquesTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Obliques", 0);
				}
				break;
			case R.id.forearmButton:
				if(tagMap.get("Forearm") == 0)
				{
						forearmTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Forearm", 1);
				}
				else{
					forearmTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Forearm", 0);
				}
				break;
			case R.id.absButton:
				if(tagMap.get("Abs") == 0)
				{
						absTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Abs", 1);
				}
				else{
					absTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Abs", 0);
				}
				break;
			case R.id.soleusButton:
				if(tagMap.get("Soleus") == 0)
				{
						soleusTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Soleus", 1);
				}
				else{
					soleusTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Soleus", 0);
				}
				break;
			case R.id.thighsButton:
				if(tagMap.get("Thighs") == 0)
				{
						thighTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Thighs", 1);
				}
				else{
					thighTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Thighs", 0);
				}
				break;
			case R.id.upperbackButton:
				if(tagMap.get("Upper Back") == 0)
				{
					upperbackTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Upper Back", 1);
				}
				else{
					upperbackTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Upper BackS", 0);
				}
				break;
			case R.id.backButton:
				if(tagMap.get("Back") == 0)
				{
					backTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Back", 1);
				}
				else{
					backTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("BackS", 0);
				}
				break;
			case R.id.lowerbackButton:
				if(tagMap.get("Lower Back") == 0)
				{
					lowerbackTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Lower Back", 1);
				}
				else{
					lowerbackTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Lower Back", 0);
				}
				break;
			case R.id.glutealsButton:
				if(tagMap.get("Gluteals") == 0)
				{
					glutealTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Lower Back", 1);
				}
				else{
					glutealTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Gluteals", 0);
				}
				break;
			case R.id.calfButton:
				if(tagMap.get("Calf") == 0)
				{
					calfTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Calf", 1);
				}
				else{
					calfTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Calf", 0);
				}
				break;
			case R.id.hamstringButton:
				if(tagMap.get("Hamstring") == 0)
				{
					hamstringTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Hamstring", 1);
				}
				else{
					hamstringTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Hamstring", 0);
				}
				break;
			case R.id.tricepButton:
				if(tagMap.get("Tricep") == 0)
				{
					tricepTag.setBackgroundResource(R.drawable.tagon);
						tagMap.put("Tricep", 1);
				}
				else{
					tricepTag.setBackgroundResource(R.drawable.tagoff);
					tagMap.put("Tricep", 0);
				}
				break;
		}
	}
		
	
	
	//Each tag name will have 2 signal: 0 for off, 1 for on.
	private void createTagMap()
	{
		tagMap.put("Shoulder", 0);
		tagMap.put("Pecs", 0);
		tagMap.put("Obliques", 0);
		tagMap.put("Biceps", 0);
		tagMap.put("Abs", 0);
		tagMap.put("Thighs", 0);
		tagMap.put("Soleus", 0);
		tagMap.put("Forearm", 0);
		
		tagMap.put("Upper Back", 0);
		tagMap.put("Back", 0);
		tagMap.put("Lower Back", 0);
		tagMap.put("Hamstring", 0);
		tagMap.put("Tricep", 0);
		tagMap.put("Gluteals", 0);
		tagMap.put("Calf", 0);
	}
}
