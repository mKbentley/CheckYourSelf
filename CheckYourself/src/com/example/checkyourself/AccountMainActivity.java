package com.example.checkyourself;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AccountMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_account_controls);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_main, menu);
		return true;
	}

	// Called when the user clicks the Registration button
		public void sendAccountResgistration (View view)
		{
			Intent intent = new Intent(this, DisplayAccountRegistrationControls.class);
			startActivity(intent);

		}

		// Called when the user clicks the Login button
		public void sendAccounts (View view)
		{
			Intent intent = new Intent(this, ViewAccountsActivity.class);
			startActivity(intent);

		}

	}
