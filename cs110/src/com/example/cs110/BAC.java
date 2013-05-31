//Test 1
package com.example.cs110;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class BAC extends Activity {
	private TextView gender;
	private RadioButton male;
	private RadioButton female;
	private TextView weight;
	private TextView hours;
	private TextView drinks;
	private Button BAC;
	private TextView warning;
	/*public final static String weight="com.example.MyApp.weight";
	public final static String numOfDrinks="com.example.MyApp.numOfDrinks";
	public final static String male="com.example.MyApp.male";
	public final static String hours="com.example.MyApp.hours";*/


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bac);
		
		// initialize font
        Typeface font = Typeface.createFromAsset(getAssets(), "bless.otf");
        
        // find buttons
        gender = (TextView) findViewById(R.id.textView1); 
        male = (RadioButton) findViewById(R.id.male); 
        female = (RadioButton) findViewById(R.id.female); 
        weight = (TextView) findViewById(R.id.weight); 
        hours = (TextView) findViewById(R.id.hours); 
        drinks = (TextView) findViewById(R.id.numDrinks); 
        BAC = (Button) findViewById(R.id.goBACButton); 
        warning = (TextView) findViewById(R.id.BACwarning); 
        
        // set button fonts
        gender.setTypeface(font);
        male.setTypeface(font);
        female.setTypeface(font);
        weight.setTypeface(font);
        hours.setTypeface(font);
        drinks.setTypeface(font);
        BAC.setTypeface(font);
        warning.setTypeface(font);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
    public void goEntry(View view){
    	Intent intent=new Intent (this, MainActivity.class);
    	startActivity (intent);
    }
    
    @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.action_back:
	      Intent intent=new Intent(this, Tools.class);
	      startActivity(intent);
	      break;
	    case R.id.action_home:
		  Intent intent2=new Intent(this, MainActivity.class);
		  startActivity(intent2);
	      break;

	    default:
	      break;
	    }

	    return true;
	  }
    
    public void calcBAC(View view){
    	EditText drinks = (EditText) findViewById(R.id.editNumOfDrinks);
    	EditText weight = (EditText) findViewById(R.id.editWeight);
        EditText hours = (EditText) findViewById(R.id.editHours);
        TextView result = (TextView) findViewById(R.id.result);
        TextView warning= (TextView) findViewById(R.id.BACwarning);
        RadioButton r=(RadioButton) findViewById(R.id.male);
    	boolean male=r.isChecked();

    	//calculates BAC
    	
    	int d=Integer.parseInt(drinks.getText().toString());
    	int w=Integer.parseInt(weight.getText().toString());
    	int h=Integer.parseInt(hours.getText().toString());
    	
    	double fullBAC = calculateBAC(w,d,h,male);
    	String BACstring=String.format("%.3g%n", fullBAC);
    	result.setText(BACstring);
    	//TODO fix the warning system
    	/*if (fullBAC<.08)
    	{
    		warning.setText("DO NOT DRIVE");
    		warning.setTextColor(0xFF0000);
    		return;
    	}
    	else if (fullBAC>0)
    	{
    		warning.setText("Impaired");
    		warning.setTextColor(0xFFFF00);
    	}
    	else
    	{
    		warning.setText("Sober");
    		warning.setTextColor(0x00FF00);
    	}*/

    }
    	private double calculateBAC(int weight, int drinks, int hours, boolean male)
    	{
    		//TODO Fucker still doesnt calculate the right number.
    		double r;
    		if (male) r=.73; else r=.66;
    		//double bac=(drinks*0.06*100*(1.055/(weight*r))-(0.015*hours));
    		double bac=drinks*.6*5.14/weight*r -.015*hours;
    		if (bac<0.001) return 0.0; else return bac;
    	}
    	
    	
    	
    	
    	

}
