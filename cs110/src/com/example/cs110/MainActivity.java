package com.example.cs110;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
//import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE="com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBAdapter db = new DBAdapter(this);
        UserAdapter udb = new UserAdapter(this);
        
        db.open();
        udb.open();
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
        udb.insertUser(
        		"Bob",
        		"204",
        		"20");
        udb.insertUser(
        		"Dude",
        		"522",
        		"522");
        
        Cursor c = db.getAllWines();
        Cursor u = udb.getAllUsers();
        if (c.moveToFirst())  {      
            displayWine(c);
        	c.moveToNext();
        	c.moveToNext();
        	c.moveToNext();
        	displayWine(c);
        }
        else
            Toast.makeText(this, "No wine found", 
            		Toast.LENGTH_LONG).show();
        if (u.moveToFirst())  {      
            displayUser(u);
        	u.moveToNext();
        	displayUser(u);
        }
        else
            Toast.makeText(this, "No wine found", 
            		Toast.LENGTH_LONG).show();
        db.close();
        udb.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    

    
    public void goBAC(View view){
    	Intent intent=new Intent (this,BAC.class);
    	startActivity(intent);
    }
    
    public void goEntry(View view){
    	Intent intent=new Intent (this, MainActivity.class);
    	startActivity (intent);
    }
    
    public void goTools(View view){
    	Intent intent=new Intent (this, Tools.class);
    	startActivity (intent);
    }
    
    public void goSettings(View view){
    	Intent intent=new Intent (this, Settings.class);
    	startActivity (intent);
    }
    
    public void goEducation(View view){
    	Intent intent=new Intent (this, Education.class);
    	startActivity (intent);
    }
    
    //displays a wine
    public void displayWine(Cursor c)
    {
        Toast.makeText(this, 
                "id: " + c.getString(0) + "\n" +
                "WINE NAME: " + c.getString(1) + "\n" +
                "WINE TYPE: " + c.getString(2) + "\n" +
                "WINE ORIGIN:  " + c.getString(3),
                Toast.LENGTH_LONG).show();        
    } 
    
    //displays a user
    public void displayUser(Cursor c)
    {
        Toast.makeText(this, 
                "id: " + c.getString(0) + "\n" +
                "USER NAME: " + c.getString(1) + "\n" +
                "USER TOTAL QUESTIONS TAKEN: " + c.getInt(2) + "\n" +
                "WINE CORRECT ANSWERS:  " + c.getInt(3),
                Toast.LENGTH_LONG).show();        
    } 
    
}
