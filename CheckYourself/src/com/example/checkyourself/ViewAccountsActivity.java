package com.example.checkyourself;

import java.util.ArrayList;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ViewAccountsActivity extends Activity  {
     private String accountName="Sorry no accounts at this time";
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_accounts);
		try{
		Intent intent = getIntent();
		if(intent!=null){
		Bundle extra=intent.getExtras();
	    accountName=extra.getString("accountname");
	    drawAccounts();
		}
		Log.i("accountname", accountName);
		
		}
	catch(NullPointerException e ){
		accountName="Sorry no accounts at this time";
	}
		drawAccounts();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_accounts, menu);
		return true;
	}
	
	 protected void drawAccounts() {
        	TextView textView =(TextView)findViewById(R.id.textView1);
		    textView.setTextSize(20);
		    int Skyblue=Color.rgb(135, 206, 235);
		    textView.setTextColor(Skyblue);
		    textView.setText(accountName);
		    
        }
		

	}
    
