package com.seleniumdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03_Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demo.automationtesting.in/Register.html");
		//driver.get("https://demo.guru99.com/test/newtours/");
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(1000);
		//Id
		//driver.findElement(By.id("checkbox1")).click();
		//Name
		//driver.findElement(By.name("userName")).sendKeys("mercury");
		//class name
		//driver.findElement(By.className("form-control")).sendKeys("testing");
		List<WebElement> allClassNames = driver.findElements(By.className("form-control"));
		System.out.println("class count::: "+ allClassNames.size());
		
		for(WebElement element: allClassNames) {
			System.out.println("PlaceHolder: "+ element.getAttribute("placeholder"));
		}
		//LinkText
		//driver.findElement(By.linkText("REGISTER")).click();
		//driver.findElement(By.partialLinkText("REGI")).click();
		/*List<WebElement> element = driver.findElements(By.tagName("input"));
		System.out.println("tagName count::: "+ element.size());
		for(WebElement ele: element) {
			System.out.println("PlaceHolder: "+ ele.getAttribute("placeholder"));
		}*/
		//driver.findElement(By.xpath("//input[@placeholder=\"Enter Name\"]")).sendKeys("lokesh");
		//driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div[1]/input[1]")).sendKeys("lokesh");
		
		driver.findElement(By.cssSelector("[placeholder=\"Enter Name\"]")).sendKeys("testing");
		Thread.sleep(2000);
		driver.quit();
	}

}
