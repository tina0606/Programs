package com.capg.app.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WalletServiceValidation {

public boolean validName(String name) {
		
		if(!name.isEmpty())
			return true;
		else
			return false;
		
	}
	
	public boolean validGender(String gender) {
		
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")  )
			return true;
		else
			return false;
		
	}
	public boolean validUsername(String username) {
		
		if(!username.isEmpty())
			return true;
		else
			return false;
		
		
	}
	public boolean validPassword(String password) {
		
		if(!password.isEmpty() && password.length()>=5)
			return true;
		else
			return false;
		
	}
	public boolean validAge(int age) {
		
		if(age>=18)
			return true;
		else
			return false;
	}
	public boolean validphoneNo(long phoneNo) {
//		
//	
			return true;
//	
	}
	
	public boolean validAadhar(long aadharNo) {
		
	
		return true;
		
	}
	
	
	public boolean validType(String accType) {
		
		if(accType.equalsIgnoreCase("savings") || accType.equalsIgnoreCase("current"))
			return true;
		else
		return false;
	}
	
	
}

