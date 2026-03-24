package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC09_Parameter {

	WebDriver driver;
	@Test
	@Parameters("browser")
	public void launchBrowser(String browser) {
		System.out.println("Browser Name is ::: "+browser);
	}
	
	@Test
	@Parameters({"browser", "url"})
	public void launchBrowser1(String browser, String url) {
		System.out.println("Browser Name is ::: "+browser);
		System.out.println("Browser URL is ::: "+url);
	}
	
	@Test
	@Parameters({"browser", "url"})
	public void setup(@Optional("chrome")String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		System.out.println("title :::: "+driver.getTitle());
		driver.quit();
	}
}
