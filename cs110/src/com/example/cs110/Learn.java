package com.example.cs110;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Learn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn);
	}
	
	public void goEtiquetteLearn(View view){
		Intent intent = new Intent (this, EtiquetteLearn.class);
		startActivity(intent);
	}
	
	public void goRegionsLearn(View view){
    	Intent intent=new Intent (this, RegionsLearn.class);
    	startActivity (intent);
    }
	
	public void goTypesLearn(View view){
    	Intent intent=new Intent (this, TypesLearn.class);
    	startActivity (intent);
    }
	
	public void goProductionLearn(View view){
		Intent intent = new Intent (this, ProductionLearn.class);
		startActivity (intent);
	}
	
	public void goFoodPairingsLearn(View view){
		Intent intent = new Intent (this, FoodPairingsLearn.class);
		startActivity(intent);
	}
	
	public void goHistoryLearn(View view){
    	Intent intent=new Intent (this, HistoryLearn.class);
    	startActivity (intent);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.learn, menu);
		return true;
	}

}
