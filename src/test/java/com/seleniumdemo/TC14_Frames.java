package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC14_Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//switch frame 1st
		WebElement fram1 = driver.findElement(By.xpath("//*[@src='frame_1.html']"));
		driver.switchTo().frame(fram1);
		
		driver.findElement(By.name("mytext1")).sendKeys("testing");
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		WebElement fram2 = driver.findElement(By.xpath("//*[@src='frame_2.html']"));
		driver.switchTo().frame(fram2);
		
		driver.findElement(By.name("mytext2")).sendKeys("second Frame");
		
		driver.switchTo().defaultContent();
		//nested
		WebElement fram3 = driver.findElement(By.xpath("//*[@src='frame_3.html']"));
		driver.switchTo().frame(fram3);
		
		driver.findElement(By.name("mytext3")).sendKeys("3rd name");
		
		Thread.sleep(1000);
		WebElement inner = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(inner);
		
		driver.findElement(By.id("i6")).click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
	}

}
