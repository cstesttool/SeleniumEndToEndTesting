package com.seleniumdemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC15_alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(3000);
		
		WebElement message = driver.findElement(By.id("result"));
		System.out.println("simple message ::: "+message.getText());
		
		
		WebElement confirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		confirm.click();
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		
		Thread.sleep(3000);
		System.out.println("Ok message ::: "+message.getText());
		
		confirm.click();
		Thread.sleep(1000);
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		
		Thread.sleep(3000);
		System.out.println("Ok message ::: "+message.getText());
		
		//prompt
		WebElement prompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		prompt.click();
		Thread.sleep(1000);
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("lokesh");
		alert3.accept();
		
		Thread.sleep(3000);
		System.out.println("Ok message ::: "+message.getText());
		driver.quit();
	}

}
