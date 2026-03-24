package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TC06_BeforeClass {

	@BeforeGroups("smoke")
	public void beforeGroup() {
		System.out.println("Before Group");
	}
	
	@AfterGroups("smoke")
	public void aftergroup() {
		System.out.println("After Group");
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("Class level setup");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("Class level tearDown");
	}
	
	@Test()
	public void addToCartTest() {
		System.out.println("add to cart Test");
	}
	
	@Test()
	public void inValidLoginTest() {
		System.out.println("InValid Login Test");
	}
	
	@Test(groups = "smoke")
	public void addToCartTest1() {
		System.out.println("add to cart Test1");
	}
	
	@Test(groups = "regression")
	public void inValidLoginTest1() {
		System.out.println("InValid Login Test1");
	}
}
