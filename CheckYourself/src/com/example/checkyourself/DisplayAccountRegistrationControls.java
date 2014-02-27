package com.example.checkyourself;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

public class DisplayAccountRegistrationControls extends Activity {
    public String accountName="Sorry no accounts exist at this time";
    SharedPreferences settings; 
    SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_create_account);
		// Show the Up button in the action bar.
		setupActionBar();
		settings = getSharedPreferences(accountName, MODE_PRIVATE);
		 editor = settings.edit();

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

	public void sendNewAccount(View view) throws IOException
	{	
		EditText account_name=(EditText) findViewById(R.id.account_name);
		String accountname = account_name.getText().toString();

		EditText eMail = (EditText) findViewById(R.id.email);
		String email = eMail.getText().toString();

		EditText social_security= (EditText) findViewById(R.id.social_securtiy);
		String socials = social_security.getText().toString();

		EditText driverId = (EditText) findViewById(R.id.driverID);
		String driver = driverId.getText().toString();
        
		EditText typeAccount=(EditText) findViewById(R.id.typeaccount);
		String accounttype=typeAccount.getText().toString();
		
		EditText uchecks=(EditText) findViewById(R.id.checks);
		String checks=uchecks.getText().toString();
		
		EditText ddeposit=(EditText) findViewById(R.id.direct);
		String direct=ddeposit.getText().toString();
		
		//NewUser user = new NewUser(username, password, firstName, lastName);
		AccountValidation validate = new AccountValidation();

		if(!validate.doesExist(accountname)&&validate.vaildEmail(email)&&validate.vaildDriver(driver)&&validate.vaildSS(socials)&&validate.vaidType(accounttype)&&validate.vaildYes(checks)&&validate.vaildYes(direct))
		{
			Intent intent = new Intent(this, ViewAccountsActivity.class);
			intent.putExtra("accountname", accountname);
			startActivity(intent);
			accountName=accountname;
			TextView textView = new TextView(this);
		    textView.setTextSize(20);
		    textView.setText("New Account Registration successful!");
		    setContentView(textView);
	
		}
		else
		{
			Intent intent = new Intent(this, DisplayAccountRegistrationControls.class);
			 startActivity(intent);
			 
			 TextView textView = new TextView(this);
			 textView.setTextSize(20);
			 textView.setText("Sorry one of the values was invalid");
		     setContentView(textView);
	
		}
		

	}


}