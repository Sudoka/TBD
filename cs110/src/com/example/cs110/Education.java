package com.example.cs110;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Education extends Activity {
	private TextView title;
	private Button etiquette;
	private Button regions;
	private Button types;
	private Button production;
	private Button pairings;
	private Button history;
	private Button pricing;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_education);
		
		// initialize font
        Typeface font = Typeface.createFromAsset(getAssets(), "bless.otf");
        
        // find buttons
        title = (TextView) findViewById(R.id.eduTitle); 
        etiquette = (Button) findViewById(R.id.etiquetteButton); 
        regions = (Button) findViewById(R.id.regionsButton); 
        types = (Button) findViewById(R.id.typesButton); 
        production = (Button) findViewById(R.id.productionButton); 
        pairings = (Button) findViewById(R.id.pairingsButton); 
        history = (Button) findViewById(R.id.historyButton); 
        pricing = (Button) findViewById(R.id.pricingsButton); 
        
        // set button fonts
        title.setTypeface(font);
        etiquette.setTypeface(font);
        regions.setTypeface(font);
        types.setTypeface(font);
        production.setTypeface(font);
        pairings.setTypeface(font);
        history.setTypeface(font);
        pricing.setTypeface(font);
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
    	Intent intent=new Intent (this, TypesQuiz.class);
    	startActivity (intent);
    }
	public void goPricing(View view){
    	Intent intent=new Intent(this, Pricing.class);
    	startActivity (intent);
    }
}
