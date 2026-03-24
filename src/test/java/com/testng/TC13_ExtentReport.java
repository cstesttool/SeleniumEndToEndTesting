package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13_ExtentReport {

	@Test
	public void loginTest() {
		System.out.println("login test execution");
		Assert.assertTrue(true);
	}
	
	@Test
	public void failedTest() {
		
		Assert.assertTrue(false);
	}
}
