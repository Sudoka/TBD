package com.example.cs110;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TypesQuiz extends Activity {
	
	static int number=0;
	public static int score=0;
	DBAdapter db;
	Cursor c;
	public final static String SCORE_MESSAGE = "com.example.cs110.MESSAGE";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_types_quiz);
		db = new DBAdapter(this);
		db.open();
		c = db.getAllWines();
        getRandomWine();
        nextQuestion();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.types_quiz1, menu);
		return true;
	}

	private void getRandomWine()
	{
		Random r=new Random();
		int index=r.nextInt(c.getCount());
		c.moveToPosition(index);
	}
	
	/*
	 * Sets the cursor to a new wine
	 * Updates the wine display
	 * Updates the question number
	 */
	private void nextQuestion()
	{
		TextView scoreDisplay=(TextView) findViewById(R.id.scoreDisplay);
		TextView wineDisplay=(TextView) findViewById(R.id.wineDisplay);
		TextView questionDisplay=(TextView) findViewById(R.id.questionDisplay);
		
		if (9 < number)
		{
			Intent intent=new Intent (this, QuizResult.class);
	    	String message=scoreDisplay.getText().toString();
	    	intent.putExtra(SCORE_MESSAGE,message);
	    	startActivity (intent);
		}
		else
		{
			getRandomWine();
			String wine=c.getString(1);
			wineDisplay.setText(wine);
			number++;
			questionDisplay.setText("Question " + number + "/10");
		}
	}
	
	/*
	 * Checks if the answer is right, then updates the score display
	 */
	public void checkAnswer(View view)
	{
		Button b = (Button) view;
		String buttonColor = b.getText().toString();
		String color = c.getString(2);
		boolean isRight = buttonColor.equalsIgnoreCase(color);
		
		TextView scoreDisplay=(TextView) findViewById(R.id.scoreDisplay);
		
    	if (isRight)
    	{
    		score++;
    		scoreDisplay.setText("Score: "+score);
    	}
    	
		nextQuestion();
		
		/*switch(view.getId())
    	{
    	case R.id.whiteButton://if white,
    		score++;
    		break;
    	case R.id.redButton://if red,
    		score++;
    		break;
    	default:
    		break;
    	}*/
    	
	}
}
