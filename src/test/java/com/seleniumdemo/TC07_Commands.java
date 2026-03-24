package com.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC07_Commands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.get("https://testautomationpractice.blogspot.com/");
		//Thread.sleep(1000);
		//System.out.println("page source::: "+ driver.getPageSource());
		//System.out.println("Title ::"+ driver.getTitle());
		//System.out.println("url ::: "+ driver.getCurrentUrl());
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		Thread.sleep(1000);
		driver.navigate().back();
		System.out.println("Title ::"+ driver.getTitle());
		Thread.sleep(1000);
		driver.navigate().forward();
		System.out.println("Title ::"+ driver.getTitle());
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("Title ::"+ driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

}
