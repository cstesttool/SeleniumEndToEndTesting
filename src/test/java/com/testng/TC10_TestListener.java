package com.testng;

import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(MyListener.class)
public class TC10_TestListener extends BaseClass {

	@Test
	public void passTset() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void failTest() {
		//Assert.assertTrue(false);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google1");
	}
}
