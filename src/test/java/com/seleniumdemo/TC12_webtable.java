package com.seleniumdemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC12_webtable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement table = driver.findElement(By.name("BookTable"));
		
		//total rows
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int totalRows = rows.size();
		
		List<WebElement> headers = table.findElements(By.tagName("th"));
		int totalHeaders = headers.size();
		
		List<WebElement> cells = table.findElements(By.tagName("td"));
		int totalCells = cells.size();
		
		System.out.println("Total Rows ::: "+totalRows);
		System.out.println("Total Columns ::: "+totalHeaders);
		System.out.println("Total Cells ::: "+totalCells);
		
		//print specific cell value
		//table[@name='BookTable']/tbody/tr[2]/td[2]
		WebElement specificName = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[2]/td[2]"));
		System.out.println("Cell Name :::: "+specificName.getText());
		
		//print complete table
		for(int i = 2; i <= totalRows; i++) {
			for(int j = 1; j <= totalHeaders; j++) {
				String cellData = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+ i +"]/td["+j+"]")).getText();
				System.out.println(cellData + " | ");
			}
			System.out.println();
		}
		
		//pagination
		List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
		boolean productFound = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		for(int p = 0; p < pages.size(); p++) {
			pages.get(p).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pagination")));
			
			//WebElement table1 = driver.findElement(By.id("pagination"));
			List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
			for(WebElement row : rows1) {
				List<WebElement> cell = row.findElements(By.tagName("td"));
				String productName = cell.get(1).getText();
				System.out.println(productName);
				if(productName.equalsIgnoreCase("Gaming Console")) {
					WebElement checkbox = cell.get(cell.size()-1).findElement(By.tagName("input"));
					checkbox.click();
					System.out.println("Gaming Console");
					productFound = true;
					break;
				}
			}
			if(productFound) {
				break;
			}
			
		}
		Thread.sleep(3000);
		//driver.quit();
		
	}

}
