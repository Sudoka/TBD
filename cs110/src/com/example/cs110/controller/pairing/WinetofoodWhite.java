package com.example.cs110.controller.pairing;


import com.example.cs110.MainActivity;
import com.example.cs110.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class WinetofoodWhite extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winetofood_white);
		// Show the Up button in the action bar.
		setupActionBar();
	}
	public void pickChardonnay(View view){
		EditText display = (EditText) findViewById(R.id.White);

  	display.setText(getResources().getString(R.string.chardonnay));

	}
	public void pickSauvBlanc(View view){
		EditText display = (EditText) findViewById(R.id.White);

  	display.setText(getResources().getString(R.string.sauvignon));

	}
	public void goHome(View view){
		Intent intent=new Intent (this,MainActivity.class);
    	startActivity(intent);

	}
	public void pickChenin(View view){
		EditText display = (EditText) findViewById(R.id.White);

  	display.setText(getResources().getString(R.string.chenin));

	}
	public void pickGewur(View view){
		EditText display = (EditText) findViewById(R.id.White);

  	display.setText(getResources().getString(R.string.gewur));

	}
	public void pickRiesling(View view){
		EditText display = (EditText) findViewById(R.id.White);

  	display.setText(getResources().getString(R.string.riesling));

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
