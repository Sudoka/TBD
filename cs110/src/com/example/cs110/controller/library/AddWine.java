package com.example.cs110.controller.library;

import com.example.cs110.R;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AddWine extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_wine);
	}

	
	public void addWine(View view){
    	
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_wine, menu);
		return true;
	}

}
