package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC07_BeforeSuite {

	@BeforeSuite
	public void setupSuite() {
		System.out.println("before Suite");
	}
	
	@BeforeClass
	public void setupClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void setupMethod() {
		System.out.println("Before Method Level");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@AfterMethod
	public void teamDownMethod() {
		System.out.println("After method level");
	}
	
	@AfterClass
	public void teamClass() {
		System.out.println("After Class");
	}
	@AfterSuite
	public void tearDownSuite() {
		System.out.println("after suite");
	}
}
