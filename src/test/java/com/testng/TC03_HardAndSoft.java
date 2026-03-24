package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC03_HardAndSoft {

	@Test
	public void hardAssertion() throws InterruptedException {
		String actualtitle = "Google";
		String expectedTitle = "Google";
		Assert.assertEquals(actualtitle, expectedTitle);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Google");
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void softAssertion() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		
		String actualtitle = "Google";
		String expectedTitle = "Google1";
		soft.assertEquals(actualtitle, expectedTitle);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		soft.assertEquals(driver.getTitle(), "Google");
		Thread.sleep(1000);
		driver.quit();
		
		soft.assertAll();
	}
}
