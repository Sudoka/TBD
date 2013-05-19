//Test 1
package com.example.cs110;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

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
    
    	
    public void calcBAC(){
    	double rate;
    	EditText drinks = (EditText) findViewById(R.id.editNumOfDrinks);
    	EditText weight = (EditText) findViewById(R.id.editWeight);
        EditText hours = (EditText) findViewById(R.id.editHours);
        EditText result = (EditText) findViewById(R.id.result);
        RadioButton r=(RadioButton) findViewById(R.id.male);
    	boolean male=r.isChecked();
    	if (male)
    	{
    		rate=.73;
    	}
    	else
    	{
    		rate=.66;
    	}
    	//calculates BAC
    	//TODO This doesn't calculate the BAC correctly. Figure out why
    	
    	double fullBAC = (Double.parseDouble(drinks.getText().toString())*.13*rate*5.14/(Double.parseDouble(weight.getText().toString()))-(Double.parseDouble(hours.getText().toString())));
    	result.setText(String.valueOf(fullBAC));
    	if (fullBAC<0)
    	{
    		result.setText(String.valueOf(0));
    	}
    }
    	
    	
    	
    	
    	
    	

}

