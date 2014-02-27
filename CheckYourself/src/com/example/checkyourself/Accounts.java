package com.example.checkyourself;

import java.util.Hashtable;

public class Accounts 
{
	//private String username;
	//private String password;
	private String firstName;
	private String lastName;
	
	static Hashtable<String, String> accounts = new Hashtable<String, String>();
	
	public Accounts(String username, String accountname, String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		accounts.put(username, accountname);
	}
}