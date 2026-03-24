package com.testng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;
	
	public static ExtentReports getReportInstance() {
		if(extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
			spark.config().setReportName("Automation test Report");
			spark.config().setDocumentTitle("TestNG Execution Report");
			
			extent =  new ExtentReports();
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Tester", "Lokesh");
		}
		return extent;
	}
}
