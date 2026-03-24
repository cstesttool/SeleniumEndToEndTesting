package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_textbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement element = driver.findElement(By.xpath("//*[@placeholder='First Name1']"));
		element.clear();
		element.sendKeys("testing");
		Thread.sleep(1000);
		System.out.println(element.getAttribute("value"));
		System.out.println(element.isDisplayed());
		System.out.println(element.isEnabled());
		Thread.sleep(2000);
		driver.quit();
	}

}
