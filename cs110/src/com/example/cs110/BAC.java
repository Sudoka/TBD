//Test 1
package com.example.cs110;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class BAC extends Activity {
	
	/*public final static String weight="com.example.MyApp.weight";
	public final static String numOfDrinks="com.example.MyApp.numOfDrinks";
	public final static String male="com.example.MyApp.male";
	public final static String hours="com.example.MyApp.hours";*/


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bac);
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
    
    	
    public void calcBAC(View view){
    	double rate;
    	EditText drinks = (EditText) findViewById(R.id.editNumOfDrinks);
    	EditText weight = (EditText) findViewById(R.id.editWeight);
        EditText hours = (EditText) findViewById(R.id.editHours);
        TextView result = (TextView) findViewById(R.id.result);
        TextView warning= (TextView) findViewById(R.id.BACwarning);
        RadioButton r=(RadioButton) findViewById(R.id.male);
    	boolean male=r.isChecked();

    	//calculates BAC
    	//TODO This doesn't calculate the BAC correctly. Figure out why
    	
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
    		double r;
    		if (male) r=.68; else r=.55;
    		double bac=(drinks*0.06*100*(1.055/weight)*r)-(0.015*hours);
    		if (bac<0) return 0; else return bac;
    	}
    	
    	
    	
    	
    	

}

