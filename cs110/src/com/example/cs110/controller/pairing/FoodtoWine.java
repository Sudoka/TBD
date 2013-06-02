package com.example.cs110.controller.pairing;

import com.example.cs110.R;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;



public class FoodtoWine extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foodto_wine);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tools, menu);
		return true;
	}
	
	public void goMeat(View view){
		Intent intent=new Intent (this,FoodtowineMeat.class);
    	startActivity(intent);
	}
	public void goPasta(View view){
		Intent intent=new Intent (this,FoodtowinePasta.class);
    	startActivity(intent);
	}
	
	
	public void goVeggie(View view){
		Intent intent=new Intent (this,Foodtowine_Veggie.class);
    	startActivity(intent);
	}
	public void goCheese(View view){
		Intent intent=new Intent (this,FoodtowineCheese.class);
    	startActivity(intent);
	}
	
}
