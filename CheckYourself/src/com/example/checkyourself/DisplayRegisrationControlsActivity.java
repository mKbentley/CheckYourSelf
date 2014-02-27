package com.example.checkyourself;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayRegisrationControlsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_regisration_controls);
		// Show the Up button in the action bar.
		setupActionBar();
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
	
	public void sendNewUser(View view) throws IOException
	{	
		EditText user_name = (EditText) findViewById(R.id.edit_desiredusername);
		String username = user_name.getText().toString();
		
		EditText pass_word = (EditText) findViewById(R.id.edit_desiredpassword);
		String password = pass_word.getText().toString();
		
		EditText first_name = (EditText) findViewById(R.id.edit_firstname);
		String firstName = first_name.getText().toString();
		
		EditText last_name = (EditText) findViewById(R.id.edit_lastname);
		String lastName = first_name.getText().toString();
		
		//NewUser user = new NewUser(username, password, firstName, lastName);
		LoginValidation validate = new LoginValidation();
		
		if(!validate.doesExist(username))
		{
			NewUser user = new NewUser(username, password, firstName, lastName);
			
			Intent intent = new Intent(this, DisplayLoginControlsActivity.class);
			startActivity(intent);
			
			TextView textView = new TextView(this);
		    textView.setTextSize(20);
		    textView.setText("Registration successful!");
		    
		    setContentView(textView);
		}
		else
		{
			Intent intent = new Intent(this, DisplayRegisrationControlsActivity.class);
			startActivity(intent);
			
		    TextView textView = new TextView(this);
		    textView.setTextSize(20);
		    textView.setText("Sorry, that username is taken. Please try again.");

		    // Set the text view as the activity layout
		    setContentView(textView);
		}
	}


}
