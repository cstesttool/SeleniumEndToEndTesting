package com.seleniumdemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC20_Screenshots {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		File folder = new File(System.getProperty("user.dir")+"/screenshot");
		if(!folder.exists()){
			folder.mkdir();
		}
		//Full page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String projectPath = System.getProperty("user.dir");
		
		File destionation = new File(projectPath+"/screenshot/google_"+timestamp+".png");
		
		Files.copy(source.toPath(), destionation.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		//SPecific element
		WebElement textbox = driver.findElement(By.id("APjFqb"));
		File source1 = textbox.getScreenshotAs(OutputType.FILE);
		
		File destionation1 = new File(projectPath+"/screenshot/textbox_"+timestamp+".png");
		
		Files.copy(source1.toPath(), destionation1.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
			
		driver.quit();
	}

}
