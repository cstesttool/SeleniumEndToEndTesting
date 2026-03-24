package com.testng;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	
	public static File captureScreenshot(WebDriver driver, String testName) throws IOException {
		File folder = new File(System.getProperty("user.dir")+"/screenshot");
		if(!folder.exists()){
			folder.mkdir();
		}
		//Full page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String projectPath = System.getProperty("user.dir");
		
		File destionation = new File(projectPath+"/screenshot/Failed_"+timestamp+".png");
		
		Files.copy(source.toPath(), destionation.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		return destionation;
	}
}
