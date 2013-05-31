package com.example.cs110;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Quiz_Result extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
	    String message = intent.getStringExtra("com.example.cs110.MESSAGE");
		setContentView(R.layout.activity_quiz_result);
		TextView scoreView=(TextView) findViewById(R.id.scoreDisplay);
	    scoreView.setText(message);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.activity_quiz_result, menu);
		return true;
	}
	
	public void goEducation(View view){
    	Intent intent=new Intent (this, Education.class);
    	startActivity (intent);
    }

}
