package com.example.cs110.controller.pairing;


import com.example.cs110.MainActivity;
import com.example.cs110.R;
import com.example.cs110.R.id;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;
import com.example.cs110.R.string;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class WinetofoodOther extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winetofood_other);
		// Show the Up button in the action bar.
		setupActionBar();
	}
	public void pickPink(View view){
		EditText display = (EditText) findViewById(R.id.Other);

  	display.setText(getResources().getString(R.string.pink));

	}
	public void goHome(View view){
		Intent intent=new Intent (this,MainActivity.class);
    	startActivity(intent);

	}
	public void pickBrut(View view){
		EditText display = (EditText) findViewById(R.id.Other);

  	display.setText(getResources().getString(R.string.brut));

	}
	public void pickBlancdeNoir(View view){
		EditText display = (EditText) findViewById(R.id.Other);

  	display.setText(getResources().getString(R.string.blancdenoir));

	}
	public void pickBlancdeBlanc(View view){
		EditText display = (EditText) findViewById(R.id.Other);

  	display.setText(getResources().getString(R.string.blancdeblanc));

	}
	public void pickPinot(View view){
		EditText display = (EditText) findViewById(R.id.Other);

  	display.setText(getResources().getString(R.string.pinot));

	}
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foodtowine_meat, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

}