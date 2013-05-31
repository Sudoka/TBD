package com.example.cs110.pairing;

import com.example.cs110.R;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class WinetoFood extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wineto_food);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wineto_food, menu);
		return true;
	}
	public void goWhite(View view){
    	Intent intent=new Intent (this,WinetofoodWhite.class);
    	startActivity(intent);
    }
	public void goRed(View view){
    	Intent intent=new Intent (this,WinetofoodRed.class);
    	startActivity(intent);
    }
	public void goOther(View view){
    	Intent intent=new Intent (this,WinetofoodOther.class);
    	startActivity(intent);
    }
}
