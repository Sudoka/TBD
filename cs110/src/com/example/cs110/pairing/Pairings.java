package com.example.cs110.pairing;

import com.example.cs110.R;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Pairings extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pairings);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pairings, menu);
		return true;
	}
	
	public void goFood(View view){
    	Intent intent=new Intent (this,FoodtoWine.class);
    	startActivity(intent);
    }
	public void goWine(View view){
    	Intent intent=new Intent (this,WinetoFood.class);
    	startActivity(intent);
    }

}
