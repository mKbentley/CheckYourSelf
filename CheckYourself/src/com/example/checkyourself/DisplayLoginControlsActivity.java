package com.example.checkyourself;

import java.io.IOException;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayLoginControlsActivity extends Activity 
{

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_login_controls);
		
		// Make sure we're running on Honeycomb (API level 11) or higher to use ActionBar APIs
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		{
			// Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) 
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_login_controls, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void sendCredentials(View vew) throws IOException
	{	
		EditText user_name = (EditText) findViewById(R.id.edit_userID);
		String username = user_name.getText().toString();
		
		EditText pass_word = (EditText) findViewById(R.id.edit_password);
		String password = pass_word.getText().toString();
		
		LoginValidation validate = new LoginValidation();
		
		if(validate.checkCredentials(username, password))
		{
			Intent intent = new Intent(this, AccountMainActivity.class);
			startActivity(intent);
		}
		else
		{
			Intent intent = new Intent(this, DisplayLoginControlsActivity.class);
			startActivity(intent);
			
		    TextView textView = new TextView(this);
		    textView.setTextSize(20);
		    textView.setText("Your username or password were incorrect. Please try again.");

		    // Set the text view as the activity layout
		    setContentView(textView);
		}
	}

}
