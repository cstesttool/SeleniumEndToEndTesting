package com.seleniumdemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC09_RadioAndCheck {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("male")).click();
		System.out.println("Male radio button is selected ::: "+driver.findElement(By.id("male")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.id("female")).click();
		System.out.println("Male radio button is selected ::: "+driver.findElement(By.id("male")).isSelected());
		Thread.sleep(1000);
		//for loop
		List<WebElement> radioButton = driver.findElements(By.cssSelector("[type='radio']"));
		for(WebElement radio: radioButton) {
			String value = radio.getAttribute("value");
			if("female".equalsIgnoreCase(value)) {
				if(!radio.isSelected()) {
					radio.click();
					System.out.println("Gender value ::: "+ value);
				}								
				break;
			}
			
		}
		
		//check box
		driver.findElement(By.id("tuesday")).click();
		System.out.println("Male radio button is selected ::: "+driver.findElement(By.id("tuesday")).isSelected());
		Thread.sleep(1000);
		// for
		
		List<WebElement> checkboxs = driver.findElements(By.cssSelector("[type='checkbox']"));
		/*
		 * for(WebElement check: checkboxs) { //check.click();
		 * 
		 * String value = check.getAttribute("value");
		 * 
		 * if("tuesday".equalsIgnoreCase(value)) { if(!check.isSelected()) {
		 * check.click(); System.out.println("Gender value ::: "+ value); }
		 * 
		 * break; }
		 * 
		 * }
		 */
		String[] daysToSelect = {"sunday", "wednesday", "saturday"};
		for(WebElement element: checkboxs) {
			String value = element.getAttribute("value");
			for(String target: daysToSelect) {
				if(target.equalsIgnoreCase(value) && !element.isSelected()) {
					element.click();
					System.out.println("checked value::: "+ value);
				}
				
				
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
