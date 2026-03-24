package com.testng;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TC05_Skip {

	@Test
	public void skip() {
		boolean condition = true;
		
		if(condition) {
			throw new SkipException("SKipping this test case");
		}
	}
}
