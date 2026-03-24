package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginData {

	@DataProvider(name="loginData")
	public Object[][] getData(){
		return new Object[][] {
			{"user1", "pass1"},
			{"user2", "pass2"},
			{"user3", "pass3"},
		};
	}
	
	@DataProvider(name="loginData1", parallel = true)
	public Object[][] getData1(){
		return new Object[][] {
			{"Admin", "admin123"},
			{"Admin", "admin1234"}
		};
	}
	
	@Test(dataProvider = "loginData")
	public void loginTest(String userName, String password) {
		System.out.println("UserName:::: "+ userName);
		System.out.println("Password :::: "+password);
	}
}
