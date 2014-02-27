package com.example.checkyourself;

public class LoginValidation 
{
	public boolean checkCredentials(String username, String password)
	{
        boolean result;
        
        if(username.equals("admin") && password.equals("pass123"))
        {
        	result = true;
        }
        else if(password.equals(NewUser.users.get(username)))
        {
        	result = true;
        }
        else
        	result =  false;
      
        return result;
		
	}

	public boolean doesExist (String username) {
        
        if(username.equals("admin"))
        {
        	return true;
        }
        else
        	return false;
 
    }
}
