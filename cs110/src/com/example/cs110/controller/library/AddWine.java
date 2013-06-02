package com.example.cs110.controller.library;

import com.example.cs110.R;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class AddWine extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_wine);
	}

	
	public void addWine(View view){
		EditText wine_name = (EditText) findViewById(R.id.editNumOfDrinks);
    	EditText wine_region = (EditText) findViewById(R.id.editWeight);
        EditText wine_description = (EditText) findViewById(R.id.editHours);
        TextView result = (TextView) findViewById(R.id.result);
        TextView warning= (TextView) findViewById(R.id.BACwarning);
        RadioButton r=(RadioButton) findViewById(R.id.male);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_wine, menu);
		return true;
	}

}
