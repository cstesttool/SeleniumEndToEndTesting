package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04_xpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("testing");
		//driver.findElement(By.xpath("//input[@id='name' or @placeholder='Enter Name']")).sendKeys("testing");
		//driver.findElement(By.xpath("//input[@id='name' or @placeholder='Enter Name1']")).sendKeys("testing");
		//driver.findElement(By.xpath("//input[@id='name1' or @placeholder='Enter Name1']")).sendKeys("testing");
		//driver.findElement(By.xpath("//input[@id='name' and @placeholder='Enter Name1']")).sendKeys("testing");
		//driver.findElement(By.xpath("//input[@id='name' and @placeholder='Enter Name']")).sendKeys("testing");
		
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).sendKeys("testing");
		//driver.findElement(By.xpath("//button[contains(text(),'START')]")).click();
		//driver.findElement(By.xpath("//button[starts-with(@onclick,'toggle')]")).click();
		//driver.findElement(By.xpath("//button[text()='START']")).click();
		driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("testing");
		////input[@id='name']/following::input
		//input[@id='name']/following::input[@id='phone']
		//input[@id='name']/following-sibling::input
		//input[@id='phone']/preceding-sibling::input
		//input[@id='name']/preceding::input
		Thread.sleep(1000);
		driver.quit();
	}
}
