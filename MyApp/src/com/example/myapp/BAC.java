package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class BAC extends Activity {
	
	public final static String weight="com.example.MyApp.weight";
	public final static String numOfDrinks="com.example.MyApp.numOfDrinks";
	public final static String male="com.example.MyApp.male";
	public final static String hours="com.example.MyApp.hours";


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
    
    public void goBACFinal(View view){
    	Intent intent=new Intent (this, BACFinal.class);
    	//TODO- Handle error if editWeight's message isn't just numbers. Javascripty don't-let-them-hit-the-button-until-it-works?
    	EditText editText1= (EditText) findViewById(R.id.editWeight);
    	String message1=editText1.getText().toString();
    	intent.putExtra(weight,Integer.parseInt(message1));
    	

    	//TODO Figure out how to extract the kind of alcohol from the database
    	// Then multiply alcohol content by drink, and pass that one along
    	
    	EditText editText2= (EditText) findViewById(R.id.editNumOfDrinks);
    	String message2=editText2.getText().toString();
    	intent.putExtra(numOfDrinks,Integer.parseInt(message2));
    	
    	/*EditText editText3= (EditText) findViewById(R.id.editHours);
    	String message3=editText3.getText().toString();
    	intent.putExtra(hours,Integer.parseInt(message3));*/
    	
    	RadioButton r=(RadioButton) findViewById(R.id.male);
    	boolean isMale=r.isChecked();
    	intent.putExtra(male,isMale);
    	
    	    	
    	startActivity(intent);
    	
    	
    	
    	
    	
    }
    /*
     * Takes in weight, gender, ounces of alcohol consumed, and hours since having consumed alcohol
     * and returns the blood alcohol
     */
    		
    public static double calcBAC(int weight, boolean male,int drinks,double hours){
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
    	double fullBAC= ((drinks*.13)*r*5.14/weight)-.015*hours;
    	
    	//rounds it to three decimal points
    	return Math.round(fullBAC*1e3)/1e3;
    }
}
