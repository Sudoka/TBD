//Test 1
package com.example.cs110;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
    	int d,w,h;
    	try{
    		d=Integer.parseInt(drinks.getText().toString());
    	}
    	catch(Exception e)
    	{
    		d=0;
    	}
    	try{
    		w=Integer.parseInt(weight.getText().toString());
    	}
    	catch (Exception e)
    	{
    		w=0;
    	}
    	try{
    		h=Integer.parseInt(hours.getText().toString());
    	}
    	catch (Exception e)
    	{
    		h=0;
    	}
    	double fullBAC = calculateBAC(w,d,h,male);
    	String BACstring=String.format("%.3g%n", fullBAC);
    	if (w==0){BACstring="0.00";}
    	result.setText(BACstring);
    	//TODO fix the warning system
<<<<<<< HEAD
    	if (fullBAC>.08)
    	{
    		warning.setText("DO NOT DRIVE");
    		warning.setTextColor(Color.RED);
    		return;
    	}
    	else if (fullBAC>0.01)
    	{
    		warning.setText("Impaired");
    		warning.setTextColor(Color.YELLOW);
    	}
    	else
    	{
    		warning.setText("Sober");
    		warning.setTextColor(Color.GREEN);
=======
    	if (fullBAC>=.08)
    	{
    		Toast.makeText(this, "DO NOT DRIVE.", 
            		Toast.LENGTH_LONG).show();
    	}
    	else if (fullBAC>0&&fullBAC<.08)
    	{
    		Toast.makeText(this, "GIRL YOU TIPSY!\n¯\\_(-.-)_/¯", 
            		Toast.LENGTH_LONG).show();
    	}
    	else
    	{
    		Toast.makeText(this, "SOMETHING IS WRONG. YOU ARE SOBER.", 
            		Toast.LENGTH_LONG).show();
>>>>>>> e83511399e872a11eb5aeaa3eafea5f73c0fb597
    	}

    }
    	private double calculateBAC(int weight, int drinks, int hours, boolean male)
    	{
    		double r;
    		if (male) r=.73; else r=.66;
    		double bac=drinks*.6*5.14/(weight*r) -.015*hours;
    		if (bac<0.001) return 0.0; else return bac;
    	}
    	
    	
    	
    	
    	

}
