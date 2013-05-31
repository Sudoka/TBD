package com.example.cs110;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TypesQuiz extends Activity {
	static int number=1;
	public static int score=0;
	DBAdapter db;
	Cursor c;
	public final static String SCORE_MESSAGE = "com.example.cs110.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_types_quiz);
		System.out.println("This works");
        db = new DBAdapter(this);
        
        db.open();
        db.insertWine(
        		"Chardonnay",
        		"White",
        		"California");        
        db.insertWine(
        		"Pinot Noir",
        		"Red",
        		"Temecula");
        db.insertWine(
        		"Cabernet Sauvignon",
        		"Red",
        		"Napa");
        db.insertWine(
        		"Pinot Blanc",
        		"White",
        		"Bernardo Winery");
        db.insertWine(
        		"Merlot",
        		"Red",
        		"Spain");
        db.insertWine(
        		"Port",
        		"Red",
        		"Temecula");
        db.insertWine(
        		"Pinot Noir",
        		"Red",
        		"San Bernardino");
        db.insertWine(
        		"Muscat",
        		"White",
        		"France");
        db.insertWine(
        		"Cabernet Sauvignon",
        		"Red",
        		"Santa Ynez");
        db.insertWine(
        		"Pinot Noir",
        		"Red",
        		"Willow Creek");

        c = db.getAllWines();
        getRandomWine();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.activity_types_quiz, menu);
		return true;
	}
	
	public void quizFlow(View view){
		Button b=(Button) findViewById(R.id.startButton);
		b.setVisibility(View.GONE);
		if (number<10)
		{
			//reset the page
			TextView scoreDisplay=(TextView) findViewById(R.id.scoreDisplay);
			TextView wineDisplay=(TextView) findViewById(R.id.wineDisplay);
			TextView quizDisplay=(TextView) findViewById(R.id.quizDisplay);
			getRandomWine();
			
			//Buttons, red and white
	    	//Button whiteButton = (Button) findViewById(R.id.whiteButton);
	    	//Button redButton = (Button) findViewById(R.id.redButton);
	    	switch(view.getId())
	    	{
	    	case R.id.whiteButton://if white,
	    		score++;
	    		break;
	    	case R.id.redButton://if red,
	    		score++;
	    		break;
	    	default:
	    		break;
	    	}
	    	scoreDisplay.setText(score+"/10");
	    	quizDisplay.setText((++number)+"/10");
			//either way, button calls quizFlow again
			//Should work?
		}
		else
		{
		    	Intent intent=new Intent (this, Quiz_Result.class);
		    	TextView score=(TextView) findViewById(R.id.scoreDisplay);
		    	String message=score.getText().toString();
		    	intent.putExtra(SCORE_MESSAGE,message);
		    	startActivity (intent);
		}
			 
		
	}
	/*
	 * Updates the cursor
	 */
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
		TextView quizDisplay=(TextView) findViewById(R.id.quizDisplay);
		
		if (number>=10)
		{
			Intent intent=new Intent (this, Quiz_Result.class);
	    	String message=scoreDisplay.getText().toString();
	    	intent.putExtra(SCORE_MESSAGE,message);
	    	startActivity (intent);
		}
		
		getRandomWine();
		String wine=c.getString(1);
		wineDisplay.setText(wine);
		number++;
		quizDisplay.setText("Question "+number+"/10");
		
		

	}
	/*
	 * Checks if the answer is right, then updates the score display
	 */
	public void checkAnswer(View view)
	{
		Button b=(Button) view;
		String buttonColor= b.getText().toString();
		String color=c.getString(2);
		boolean isRight=buttonColor.toLowerCase().equals(color.toLowerCase());
		
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
