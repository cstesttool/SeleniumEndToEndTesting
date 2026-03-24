package com.seleniumdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC05_CssSelector {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(5000);
		//# ID
		//driver.findElement(By.cssSelector("#name")).sendKeys("testing");
		//Class Name
		List<WebElement> elements = driver.findElements(By.cssSelector(".form-control"));
		System.out.println(elements.size());
		
		//tagName
		List<WebElement> tags = driver.findElements(By.cssSelector("input"));
		System.out.println("List of tag count :: "+tags.size());
		
		//attribute value
		//driver.findElement(By.cssSelector("input[placeholder='Enter Name']")).sendKeys("testing");
		//dynamic css
		List<WebElement> dynamic_start = driver.findElements(By.cssSelector("[placeholder^='Enter']"));
		System.out.println("List of dynamic_start count :: "+dynamic_start.size());
		
		//driver.findElement(By.cssSelector("[placeholder$='Name']")).sendKeys("testing");
		
		//driver.findElement(By.cssSelector("[placeholder*='er EMa']")).sendKeys("testing");
		//driver.findElement(By.cssSelector(".form-group > input[id='name']")).sendKeys("testing");
		//driver.findElement(By.cssSelector(".form-group input[id='email']")).sendKeys("testing");
		driver.findElement(By.cssSelector("label[for='textbox'] ~ input[id='phone']")).sendKeys("testing");
		driver.findElement(By.cssSelector("label[for='textbox'] + input[id='email']")).sendKeys("testing");
		
		String text = driver.findElement(By.cssSelector("[name='BookTable'] tbody tr:nth-child(2) td:nth-child(1)")).getText();
		System.out.println(text);
		driver.findElement(By.cssSelector("input[class='form-control'][id='name']")).sendKeys("testing");
		Thread.sleep(2000);
		driver.quit();
	}

}
