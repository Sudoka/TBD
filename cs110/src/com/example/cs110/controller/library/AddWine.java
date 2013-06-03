package com.example.cs110.controller.library;

import com.example.cs110.MainActivity;
import com.example.cs110.R;
import com.example.cs110.Tools;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;
import com.example.cs110.model.data.DBAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class AddWine extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_wine);
	}
	 @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.action_back:
	      Intent intent=new Intent(this, WineLibrariesActivity.class);
	      startActivity(intent);
	      break;
	    case R.id.action_home:
		  Intent intent2=new Intent(this, MainActivity.class);
		  startActivity(intent2);
	      break;

	    default:
	      break;
	    }

	    return true;
	  }
	
	public void addWine(View view){
		EditText wine_name = (EditText) findViewById(R.id.wine_name);
    	EditText wine_region = (EditText) findViewById(R.id.wineregion);
        EditText wine_description = (EditText) findViewById(R.id.winedsc);
        RadioButton red = (RadioButton) findViewById(R.id.red);
        RadioButton white = (RadioButton) findViewById(R.id.white);
        RadioButton rose = (RadioButton) findViewById(R.id.rose);
        CheckBox wishlist = (CheckBox) findViewById(R.id.wishlist);
        CheckBox favorites = (CheckBox) findViewById(R.id.favorite);

        
        String color;
        if(red.isChecked()){
        	color="Red";
        }
        else if(rose.isChecked()){
        
        	color="Rose";
        }
        else {color="White";}
        int onWish = wishlist.isChecked()?1:0;
        int onFav = favorites.isChecked()?1:0;
        if((wine_name.getText().toString().isEmpty()||wine_region.getText().toString().isEmpty()||wine_description.getText().toString().isEmpty())){
        	Toast.makeText(this, "SOMETHING IS EMPTY", 
            		Toast.LENGTH_LONG).show();
        }
        else
        {
        DBAdapter db;
		db = new DBAdapter(this);
	    db.open();
	    db.insertWine(wine_name.getText().toString(), color, wine_region.getText().toString(), wine_description.getText().toString()
	    		, onFav, onWish);
	    db.close();
	    favorites.setChecked(false);
	    wishlist.setChecked(false);
	    red.setChecked(false);
	    white.setChecked(false);
	    rose.setChecked(false);
	    wine_name.setText("");
	    wine_description.setText("");
	    wine_region.setText("");
        }
        
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
