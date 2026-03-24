package com.testng;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener  implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started:  "+ result.getName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed:  "+ result.getName());
	}
	
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed ::: "+ result.getName());
		//screenshot logic here	
		String name = result.getName();
		try {
			ScreenshotUtil.captureScreenshot(BaseClass.driver, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot captured for failed test: "+ name);
	}
	
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped ::: "+ result.getName());
	}
}
