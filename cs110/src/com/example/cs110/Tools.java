package com.example.cs110;


import com.example.cs110.library.WineLibrariesActivity;
import com.example.cs110.pairing.Pairings;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//test
public class Tools extends Activity {

	private TextView title;
	private Button libraries;
	private Button BAC;
	private Button locations;
	private Button pairings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tools);
		
		// initialize font
        Typeface font = Typeface.createFromAsset(getAssets(), "bless.otf");
        
        // find buttons
        title = (TextView) findViewById(R.id.textView1); 
        libraries = (Button) findViewById(R.id.button_WineLibraries); 
        BAC = (Button) findViewById(R.id.bacButton); 
        locations = (Button) findViewById(R.id.locationButton); 
        pairings = (Button) findViewById(R.id.pairingsButton); 
        
        // set button fonts
        title.setTypeface(font);
        libraries.setTypeface(font);
        BAC.setTypeface(font);
        locations.setTypeface(font);
        pairings.setTypeface(font);
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
