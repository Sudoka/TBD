package com.example.cs110;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class WineLibrariesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wine_libraries);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.action_back:
	      Intent intent=new Intent(this, Tools.class);
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
	
	
	public void goDigitalCellar(View view){
    	Intent intent=new Intent (this,DigitalCellarActivity.class);
    	startActivity(intent);
    }
	public void goFavorites(View view){
    	Intent intent=new Intent (this,FavoritesActivity.class);
    	startActivity(intent);
    }
	public void goWishlist(View view){
    	Intent intent=new Intent (this,WishlistActivity.class);
    	startActivity(intent);
    }
	public void goSearchWines(View view){
    	Intent intent=new Intent (this,SearchWinesActivity.class);
    	startActivity(intent);
    }
}
