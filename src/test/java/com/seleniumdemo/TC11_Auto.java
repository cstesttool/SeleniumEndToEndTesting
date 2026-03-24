package com.seleniumdemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC11_Auto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-cy='closeModal']")).click();
		//actions
		Actions actions = new Actions(driver);
		actions.moveByOffset(10,10).click().perform();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement fromCity = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromCity")));
		fromCity.click();
		
		WebElement from = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
		from.sendKeys("mum");
		
		
		By SuggestionsLocator = By.xpath("//ul[@role='listbox']//li");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(SuggestionsLocator));
		
		List<WebElement> suggestion = driver.findElements(SuggestionsLocator);
		//for each loop
		for(WebElement options: suggestion) {
			String text = options.getText();
			System.out.println(text);
			if(text.contains("Chhatrapati Shivaji International Airport")) {
				options.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
	}

}
