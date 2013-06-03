package com.example.cs110;

import com.example.cs110.model.data.UserAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class UserStats extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_stats);
		
		UserAdapter udb = new UserAdapter(this);
		udb.open();
		Cursor u = udb.getAllUsers();
			if(u.moveToFirst()){
				TextView answeredView=(TextView) findViewById(R.id.answeredDisplay);
				answeredView.setText(u.getString(2));
				TextView scoreView=(TextView) findViewById(R.id.scoreTotal);
				scoreView.setText(u.getString(3));
			}
	    udb.close();
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
	    Intent intent=new Intent(this, MainActivity.class);
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
