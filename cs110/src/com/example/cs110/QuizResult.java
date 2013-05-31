package com.example.cs110;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class QuizResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz_result1);
		
		Intent intent = getIntent();
	    String message = intent.getStringExtra("com.example.cs110.MESSAGE");
		TextView scoreView=(TextView) findViewById(R.id.scoreDisplay);
	    scoreView.setText(message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz_result1, menu);
		return true;
	}

}
