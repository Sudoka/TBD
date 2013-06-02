package com.example.cs110;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Quiz extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
	}
	
	public void goEtiquetteQuiz(View view)
	{
		/*Intent intent = new Intent(this,EtiquetteQuiz.class)
		startActivity(intent);*/
	}
	
	public void goRegionsQuiz(View view){
    	/*Intent intent=new Intent (this, RegionsQuiz.class);
    	startActivity (intent);*/
    }
	public void goHistoryQuiz(View view){
    	/*Intent intent=new Intent (this, HistoryQuiz.class);
    	startActivity (intent);*/
    }
	public void goTypesQuiz(View view){
    	/*Intent intent=new Intent (this, TypesQuiz.class);
    	startActivity (intent);*/
    }
	public void goPricingQuiz(View view){
    	/*Intent intent=new Intent(this, PricingQuiz.class);
    	startActivity (intent);*/
    }
	
	public void goProductionQuiz(View view){
		/*Intent intent = new Intent (this, ProductionQuiz.class);
		startActivity (intent);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

}
