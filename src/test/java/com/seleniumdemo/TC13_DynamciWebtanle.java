package com.seleniumdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC13_DynamciWebtanle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//first time value
		verifyChromeCPU(driver);
		driver.navigate().refresh();
		Thread.sleep(2000);
		verifyChromeCPU(driver);
		driver.quit();
	}
	
	public static void verifyChromeCPU(WebDriver driver) {
		//headers
				List<WebElement> headers = driver.findElements(By.cssSelector("#headers th"));
				int cpuColumnIndex = -1;
				for(int i = 0; i< headers.size(); i++) {
					if(headers.get(i).getText().equalsIgnoreCase("CPU (%)")) {
						cpuColumnIndex = i;
						break;
					}
				}
				
				if(cpuColumnIndex == -1) {
					System.out.println("CPU (%) column is not found");
					//driver.quit();
					return;			
				}
				
				List<WebElement> rows = driver.findElements(By.cssSelector("#rows tr"));
				for(WebElement row: rows) {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					String processName = cells.get(0).getText();
					if(processName.equalsIgnoreCase("Chrome")) {
						String cpuValue = cells.get(cpuColumnIndex).getText();
						String cpu = driver.findElement(By.xpath("//*[@class='chrome-cpu']")).getText();
						if(cpuValue.equalsIgnoreCase(cpu)) {
							System.out.println("CPU (%) value found "+cpu);
							break;
						}
					}			
				}
	}

}
