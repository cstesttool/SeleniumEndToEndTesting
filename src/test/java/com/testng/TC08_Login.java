package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC08_Login {

	@Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
	public void loginTest(String userName, String password) {
		System.out.println("UserName:::: "+ userName);
		System.out.println("Password :::: "+password);
	}
	
	@Test(dataProvider = "loginData1", dataProviderClass = LoginData.class)
	public void loginTest1(String userName, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
