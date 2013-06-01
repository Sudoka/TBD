/*
 * To Copy-Paste this, Make sure to change the questions under getQuestionText, as well as the variable "String answer" on
 * Line 25ish. also, Change setContentView, and getMenuInflater
 */


package com.example.cs110;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PairingQuiz extends Activity {

	static int number=0;
	public static int score=0;
	String answer="Pork";//HERE
	DBAdapter db;
	Cursor c;
	public final static String SCORE_MESSAGE = "com.example.cs110.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pairing_quiz);
		
		db = new DBAdapter(this);
		db.open();
		c = db.getAllWines();
        getRandomWine();
        nextQuestion();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pairing_quiz, menu);
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
			getQuestionText(number);
			
			//String wine=c.getString(1);
			//wineDisplay.setText(wine);
			
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
		String buttonText = b.getText().toString();
		//answer = getQuestionText(number);
		boolean isRight = answer.equalsIgnoreCase(buttonText);
		answer = getQuestionText(number);
		System.out.println("START");
		System.out.println("Number: " +number);
		System.out.println("Answer: "+answer);
		System.out.println("Clicked Button: "+buttonText);
		System.out.println(isRight);
		System.out.println("END");
		
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
	
	public String getQuestionText(int number)
	{
		TextView scoreDisplay=(TextView) findViewById(R.id.scoreDisplay);
		TextView wineDisplay=(TextView) findViewById(R.id.wineDisplay);
		TextView questionDisplay=(TextView) findViewById(R.id.questionDisplay);
		
		Button b1=(Button) findViewById(R.id.Button1);
		Button b2=(Button) findViewById(R.id.Button2);
		Button b3=(Button) findViewById(R.id.Button3);
		Button b4=(Button) findViewById(R.id.Button4);
		
		
		String answer;
		switch(number)
		{
		case 0:
			wineDisplay.setText("Merlot");
			answer="Pork";
			b1.setText("Pork");
			b2.setText("Vegetables");
			b3.setText("Seafood");
			b4.setText("Rabbit");
			break;
		case 1:
			wineDisplay.setText("Pinot Noir");
			answer="Beef";
			b1.setText("Pizza");
			b2.setText("Vegetables");
			b3.setText("Pasta");
			b4.setText("Beef");
			break;
		case 2:
			wineDisplay.setText("Zinfandel");
			answer="Lamb";
			b1.setText("Chicken");
			b2.setText("Vegetables");
			b3.setText("Seafood");
			b4.setText("Lamb");
			break;
		case 3:
			wineDisplay.setText("Cabernet Sauvignon");
			answer="Duck";
			b1.setText("Vegetables");
			b2.setText("Rabbit");
			b3.setText("Pizza");
			b4.setText("Duck");
			break;
		case 4:
			wineDisplay.setText("Riesling");
			answer="Crab";
			b1.setText("Pork");
			b2.setText("Beef");
			b3.setText("Crab");
			b4.setText("Lamb");
			break;
		case 5:
			wineDisplay.setText("Chardonnay");
			answer="Poultry";
			b1.setText("Vegetables");
			b2.setText("Crab");
			b3.setText("Poultry");
			b4.setText("Lamb");
			break;
		case 6:
			wineDisplay.setText("Sauvignon Blanc");
			answer="Seafood";
			b1.setText("Seafood");
			b2.setText("Lamb");
			b3.setText("Pizza");
			b4.setText("Lamb");
			break;
		case 7:
			wineDisplay.setText("Gewurztraminer");
			answer="Spicy Food";
			b1.setText("Spicy Food");
			b2.setText("Vegetables");
			b3.setText("Seafood");
			b4.setText("Lamb");
			break;
		case 8:
			wineDisplay.setText("Blanc de Blanc");
			answer="Caviar";
			b1.setText("Poultry");
			b2.setText("Caviar");
			b3.setText("Vegetables");
			b4.setText("Veal");
			break;
		case 9:
			wineDisplay.setText("Rose wines");
			answer="Pork";
			b1.setText("Caviar");
			b2.setText("Pork");
			b3.setText("Crab");
			b4.setText("Beef");
			break;

		default:
			wineDisplay.setText("Chardonnay");
			answer="";
			break;
		
		}
		return answer;
		
	}

}
