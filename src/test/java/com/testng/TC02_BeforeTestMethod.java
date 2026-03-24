package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC02_BeforeTestMethod {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test - Launch browser/DB connection");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method - login page");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test - clear browser/DB close");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method - logout");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
}
