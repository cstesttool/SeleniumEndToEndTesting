package com.seleniumdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC10_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(2000);
		WebElement single_ele = driver.findElement(By.id("country"));
		Select select = new Select(single_ele);
		
		//visible text
		select.selectByVisibleText("India");
		Thread.sleep(1000);
		//select by value
		select.selectByValue("uk");
		Thread.sleep(1000);
		//select by index
		select.selectByIndex(4);
		
		//multiple dropdown
		WebElement mult_ele = driver.findElement(By.id("colors"));
		Select select1 = new Select(mult_ele);
		Thread.sleep(1000);
		if(select1.isMultiple()) {
			select1.selectByIndex(3);
			select1.selectByIndex(1);
			select1.selectByIndex(2);
			Thread.sleep(1000);
			List<WebElement> options = select1.getAllSelectedOptions();
			for(WebElement myopt: options) {
				System.out.println("Selected Options ::: "+myopt.getText());
			}
		}
		
		//without - select tag
		driver.get("file:///C:/Users/lokesh_gorantla/Documents/index.html");
		Thread.sleep(1000);
		driver.findElement(By.id("fruit-button")).click();
		Thread.sleep(500);
		List<WebElement> options = driver.findElements(By.cssSelector("#fruit-listbox .dropdown-item"));
		for(WebElement opt: options) {
			if(opt.getText().equals("Cherry")) {
				opt.click();
				break;
			}
		}
	}

}
