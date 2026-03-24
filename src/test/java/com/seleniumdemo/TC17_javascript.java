package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC17_javascript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement submitbtn = driver.findElement(By.id("submitbtn"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", submitbtn);
		//sending information into textbox
		
		//WebElement name = driver.findElement(By.xpath("//*[@placeholder='First Name']"));
		//js.executeScript("arguments[0].value='testing';", name);
		
		//scroll by pixel
		//js.executeScript("window.scrollBy(0,200)");
		
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		js.executeScript("arguments[0].scrollIntoView(true);", submitbtn);
		
		String title = js.executeScript("return document.title").toString();
		String domain = js.executeScript("return document.domain").toString();
		System.out.println(title);
		System.out.println(domain);
	}

}
