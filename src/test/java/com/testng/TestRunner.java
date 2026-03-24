package com.testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features/tags.feature",
		glue="StepDefintions",
		tags="@sanity",
		//tags="@smoke and @functional",
		//tags="@sanity and @functional",
		//tags="@sanity and not @functional",
	    //tags="@sanity or @functional",
		plugin= {"pretty", //"html:target/cucumber-report.html"
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
