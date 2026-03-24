package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class TC06_RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.id("email"));
		WebElement userName = driver.findElement(RelativeLocator.with(By.tagName("input")).above(email));
		userName.sendKeys("Testing above");
		WebElement phone = driver.findElement(RelativeLocator.with(By.tagName("input")).below(email));
		phone.sendKeys("123456");
		
		//to right and to left
		WebElement tuesday = driver.findElement(By.id("tuesday"));
		WebElement toRight = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(tuesday));
		toRight.click();
		WebElement toLeft = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(tuesday));
		toLeft.click();
		
		//Near
		WebElement near = driver.findElement(By.cssSelector("[for='male']"));
		WebElement near_input = driver.findElement(RelativeLocator.with(By.tagName("input")).near(near));
		near_input.click();
		Thread.sleep(5000);
		driver.quit();
	}

}
