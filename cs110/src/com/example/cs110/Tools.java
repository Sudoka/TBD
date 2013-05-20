package com.example.cs110;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
//test
public class Tools extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tools);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tools, menu);
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
    
    public void goWineLibraries(View view) {
    	Intent intent=new Intent (this, WineLibraries.class);
    	startActivity(intent);
    }
}
