package com.seleniumdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC21_FileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		String projectPath = System.getProperty("user.dir");
		String file = projectPath + "\\images\\image.jpg";
		String file2 = projectPath + "\\images\\image1.avif";
		
		//WebElement upload = driver.findElement(By.id("filesToUpload"));
		//upload.sendKeys(file);
		WebElement upload = driver.findElement(By.id("filesToUpload"));
		upload.sendKeys(file + "\n"+file2);
		List<WebElement> files = driver.findElements(By.cssSelector("#fileList li"));
		for(WebElement file1: files) {
			System.out.println(file1.getText());
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
