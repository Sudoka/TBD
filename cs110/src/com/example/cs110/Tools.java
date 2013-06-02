package com.example.cs110;


import com.example.cs110.controller.library.WineLibrariesActivity;
import com.example.cs110.controller.pairing.Pairings;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tools extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tools);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
	
	public void goBAC(View view){
    	Intent intent=new Intent (this,BAC.class);
    	startActivity(intent);
    }

    public void goPairings(View view){
    	Intent intent=new Intent (this, Pairings.class);
    	startActivity (intent);
    }
    
    public void goLocations(View view){
    	Intent intent=new Intent (this, Locations.class);
    	startActivity (intent);
    }
    
    public void goWineLibraries(View view){
    	Intent intent=new Intent (this, WineLibrariesActivity.class);
    	startActivity (intent);
    }
    
}
