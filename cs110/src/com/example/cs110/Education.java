package com.example.cs110;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Education extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_education);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.education, menu);
		return true;
	}
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.action_back:
	      Intent intent=new Intent(this, MainActivity.class);
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
	
	public void goRegions(View view){
    	Intent intent=new Intent (this, Regions.class);
    	startActivity (intent);
    }
	public void goHistory(View view){
    	Intent intent=new Intent (this, History.class);
    	startActivity (intent);
    }
	public void goTypes(View view){
    	Intent intent=new Intent (this, TypesQuiz1.class);
    	startActivity (intent);
    }
	public void goPricing(View view){
    	Intent intent=new Intent(this, Pricing.class);
    	startActivity (intent);
    }
}
