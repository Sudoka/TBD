package com.example.cs110;

import com.example.cs110.pairing.Pairings;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class FoodPairingsLearn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_pairings_learn);
	}
	
	public void goToQuiz(View view) {
		Intent intent = new Intent(this, Quiz.class);
		startActivity(intent);
	}
	
	public void goToEducation(View view) {
		Intent intent = new Intent(this, Education.class);
		startActivity(intent);
	}
	
	public void PairingsList(View view) {
		Intent intent = new Intent(this, Pairings.class);
		startActivity(intent);
	}
	
	public void loadUrl(View view)
	{
		WebView webview = new WebView(this);
		webview.loadUrl("https://en.wikipedia.org/wiki/Food_%26_Wine");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.food_pairings_learn, menu);
		return true;
	}

}
