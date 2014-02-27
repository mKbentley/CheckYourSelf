package com.example.checkyourself;

import java.util.Hashtable;

public class NewUser 
{
	//private String username;
	//private String password;
	private String firstName;
	private String lastName;
	
	static Hashtable<String, String> users = new Hashtable<String, String>();
	
	public NewUser(String username, String password, String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		users.put(username, password);
	}
}
