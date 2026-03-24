package com.testng;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

	ExtentReports extent = ExtentManager.getReportInstance();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started:  "+ result.getName());
		test = extent.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed:  "+ result.getName());
		test.pass("test passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed ::: "+ result.getName());
		test.fail(result.getThrowable());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped ::: "+ result.getName());
		test.skip("test skipped");
	}
	
	public void onFinish(org.testng.ITestContext context) {
		extent.flush();
	}
}
