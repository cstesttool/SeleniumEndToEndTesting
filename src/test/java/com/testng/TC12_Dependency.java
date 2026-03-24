package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12_Dependency {

	@Test
	public void login() {
		System.out.println("Login method");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "login")//alwaysRun = true
	public void createUser() {
		System.out.println("Create User method");
	}
	
	@Test(dependsOnMethods = "createUser")
	public void deleteUser() {
		System.out.println("delete user method");
	}
	
	@Test(dependsOnMethods = {"createUser", "login"})
	public void multipeMethod() {
		System.out.println("Multiple user method");
	}
}
