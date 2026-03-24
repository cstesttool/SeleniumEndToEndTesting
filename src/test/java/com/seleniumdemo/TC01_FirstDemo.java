package com.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_FirstDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("Page Title::: "+ driver.getTitle());
		System.out.println("current URL::: "+ driver.getCurrentUrl());
		//System.out.println("Page Source::: "+ driver.getPageSource());
		driver.quit();
	}

}
