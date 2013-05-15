package com.example.cs110;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE="com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void sendMessage (View view)
    {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
  /*  	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message); */
    	startActivity(intent);
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
    
}
