package com.example.cs110;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Locations extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locations);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	public void goMap(View view){
		String uri = "google.navigation:q=MCNAMARA+TERMINAL+ROMULUS+MI+48174";
	    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
	    startActivity(i); 
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

}
