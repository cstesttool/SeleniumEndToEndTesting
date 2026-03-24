package com.testng;

import org.testng.annotations.Test;

@Test
//(enabled=false)
public class TC04_LoginTests {

	@Test(groups= {"smoke"})
	public void validLoginTest() {
		System.out.println("Valid Login Test");
	}
	
	@Test(groups= {"smoke", "regression"})
	public void addToCartTest() {
		System.out.println("add to cart Test");
	}
	
	@Test(groups= {"sanity"})
	public void inValidLoginTest() {
		System.out.println("InValid Login Test");
	}
	
	@Test(groups= {"regression"})
	public void forgotPasswordTest() {
		System.out.println("forgot Password Test");
	}
	
	@Test(dependsOnGroups = "regression")
	public void dependOnGroup() {
		System.out.println("forgot Password Test");
	}
}
