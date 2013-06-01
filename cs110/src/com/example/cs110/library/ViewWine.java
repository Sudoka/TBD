package com.example.cs110.library;

import com.example.cs110.DBAdapter;
import com.example.cs110.MainActivity;
import com.example.cs110.R;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class ViewWine extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		DBAdapter db;
		db = new DBAdapter(this);
		Intent intent = getIntent();
	    db.open();
/*	    Cursor c = db.getWine(Integer.parseInt(intent.getStringExtra("rowId")));*/
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_wine);
		EditText display = (EditText) findViewById(R.id.wine);
        display.setText(intent.getStringExtra("rowId"));
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
	      Intent intent=new Intent(this, SearchWinesActivity.class);
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
}
