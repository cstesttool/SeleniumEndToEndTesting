package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TC16_Actions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//Click action
		WebElement sunday = driver.findElement(By.id("sunday"));
		WebElement monday = driver.findElement(By.id("monday"));
		//Actions
		Actions action = new Actions(driver);
		action.click(sunday).perform();
		//action
		
		Action act = action.click(monday).build();
		act.perform();
		
		//drag and drop actions
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		action.dragAndDrop(source, target).perform();
		Thread.sleep(1000);
		System.out.println("Target Message :::: "+target.getText());
		
		//double click
		WebElement dbclick = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		action.doubleClick(dbclick).perform();
		Thread.sleep(1000);
		String text = driver.findElement(By.id("field2")).getAttribute("value");
		System.out.println("double click text::: "+ text);
		
		//hover
		WebElement hovers = driver.findElement(By.xpath("//button[text()='Point Me']"));
		action.moveToElement(hovers).perform();
		String mobile = driver.findElement(By.xpath("//a[text()='Mobiles']")).getText();
		System.out.println(mobile);
		Thread.sleep(1000);
		//right click
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");		
		Thread.sleep(3000);
		WebElement right = driver.findElement(By.xpath("//*[text()='right click me']"));
		Actions actions = new Actions(driver);
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Paste']")).click();
	}

}
