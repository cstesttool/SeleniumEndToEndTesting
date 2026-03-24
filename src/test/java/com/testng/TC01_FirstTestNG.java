package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_FirstTestNG {

	@Test
	public void demo_title() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void demo_url() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
}
