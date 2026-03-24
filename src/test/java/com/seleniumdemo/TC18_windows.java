package com.seleniumdemo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC18_windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Winddow:::: "+parentWindow);
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Thread.sleep(1000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window: allWindows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				System.out.println("Title:: "+driver.findElement(By.tagName("h3")).getText());
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
