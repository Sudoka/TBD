package com.example.cs110;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class RegionsLearn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regions_learn);
	}
	
	public void goToQuiz(View view) {
		Intent intent = new Intent(this, Quiz.class);
		startActivity(intent);
	}
	
	public void goToEducation(View view) {
		Intent intent = new Intent(this, Education.class);
		startActivity(intent);
	}
	
	public void loadUrl(View view)
	{
		WebView webview = new WebView(this);
		webview.loadUrl("http://en.wikipedia.org/wiki/List_of_wine-producing_regions");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.regions_learn, menu);
		return true;
	}

}
