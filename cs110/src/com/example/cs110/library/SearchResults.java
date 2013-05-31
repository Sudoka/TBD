package com.example.cs110.library;

import com.example.cs110.MainActivity;
import com.example.cs110.R;
import com.example.cs110.R.layout;
import com.example.cs110.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;

public class SearchResults {
  private String s1;
  public SearchResults(String s1) { 
		
		s1 = s1.toLowerCase();
  }
  
  public void getNarrowedResults() {
		Cursor c = MainActivity.db1.getAllWines();
		c.moveToFirst();
		while(c.moveToNext()) {
			for(int i = 1; i <=3; i++) {
				String s2 = c.getString(i).toLowerCase();
				if(s1.equals(s2));
			}
		}

  }
}