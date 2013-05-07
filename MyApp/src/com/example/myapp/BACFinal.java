package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class BACFinal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		
	    super.onCreate(savedInstanceState);

	    // Get the message from the intent
	    Intent intent = getIntent();
	    //Message isn't updated
	    int weight = intent.getIntExtra(BAC.weight,0);
	    int numOfDrinks=intent.getIntExtra(BAC.numOfDrinks,0);
	    boolean isMale=intent.getBooleanExtra(BAC.male, true);
	    int hours=intent.getIntExtra(BAC.hours, 0);
	    
	    String message="BAC: "+BAC.calcBAC(weight,isMale,numOfDrinks,2);

	    // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(message);

	    // Set the text view as the activity layout
	    setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bacfinal, menu);
		return true;
	}

}
