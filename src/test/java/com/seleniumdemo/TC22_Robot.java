package com.seleniumdemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC22_Robot {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//alert
		driver.findElement(By.id("alertBtn")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		//scroll down
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
		//enter text in text box
		driver.findElement(By.id("name")).click();
		Thread.sleep(1000);
		typeText(robot,"testing");
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void typeText(Robot robot, String text) {
		for(char ch : text.toCharArray()) {
			int keycode = KeyEvent.getExtendedKeyCodeForChar(ch);
			robot.keyPress(keycode);
			robot.keyRelease(keycode);
		}
	}
}
