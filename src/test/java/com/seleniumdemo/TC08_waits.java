package com.seleniumdemo;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC08_waits {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		name.sendKeys("Testing wait");
		
		//fluent wait
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		//WebElement email = fluent.until(driver1 -> driver1.findElement(By.id("email")));
		//email.sendKeys("testing@gmail.com");
		WebElement email = fluent.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("testing@gmail.com");
		Thread.sleep(2000);
		driver.quit();
	}

}
