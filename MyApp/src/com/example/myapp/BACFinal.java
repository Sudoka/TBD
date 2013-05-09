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

	    // Get variables from where they're stored
	    Intent intent = getIntent();
	    int weight = intent.getIntExtra(BAC.weight,0);
	    int numOfDrinks=intent.getIntExtra(BAC.numOfDrinks,0);
	    boolean isMale=intent.getBooleanExtra(BAC.male, true);
	    int hours=intent.getIntExtra(BAC.hours, 0);
	    
	    String message="BAC: "+calcBAC(weight,isMale,numOfDrinks,hours);

	    // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(message);

	    // Set the text view as the activity layout
	    setContentView(textView);
	}
    /*
     * Takes in weight, gender, drinks consumed, and hours since having consumed alcohol
     * and returns the blood alcohol
     */
    		

	 public static double calcBAC(int weight, boolean male,int drinks,int hours){
	    	double r;
	    	if (male)
	    	{
	    		r=.73;
	    	}
	    	else
	    	{
	    		r=.66;
	    	}
	    	//calculates BAC
	    	//TODO This doesn't calculate the BAC correctly. Figure out why
	    	double fullBAC= ((drinks*.13)*r*5.14/weight)-(.015*hours);
	    	if (fullBAC<0)
	    	{
	    		return 0;
	    	}
	    	
	    	//rounds it to three decimal points
	    	return Math.round(fullBAC*1e3)/1e3;
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bacfinal, menu);
		return true;
	}

}
