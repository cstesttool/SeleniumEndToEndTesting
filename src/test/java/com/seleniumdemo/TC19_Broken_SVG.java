package com.seleniumdemo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC19_Broken_SVG {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		for(WebElement img: images) {
			String imageUrl = img.getAttribute("src");
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
				connection.connect();
				int responseCode = connection.getResponseCode();
				if(responseCode != 200){
					System.out.println(imageUrl + " -- Broken Image( "+responseCode+" )");
				}
			}catch(Exception e) {
				System.out.println("Exception for URL: "+imageUrl);
			}
		}
		
		driver.get("https://www.w3schools.com/graphics/svg_circle.asp");
		Thread.sleep(3000);
		
		WebElement circle = driver.findElement(By.xpath("(//*[local-name()='svg']//*[local-name()='circle'])[1]"));
		System.out.println(circle.getAttribute("fill"));
		System.out.println(circle.getAttribute("r"));
		System.out.println(circle.getAttribute("cx"));
		System.out.println(circle.getAttribute("cy"));
		
		driver.quit();
	}

}
