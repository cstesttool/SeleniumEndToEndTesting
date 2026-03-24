package com.testng;

import org.testng.annotations.Test;

public class TC11_Failed {

	@Test
	//(retryAnalyzer = RetryFailedTest.class)
	public void testMethod() {
		System.out.println("Execution");
		assert false;
	}
}
