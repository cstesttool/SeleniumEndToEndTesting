package com.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ClassB {	
	
	@BeforeGroups("smoke")
	public void beforeGroup() {
		System.out.println("Before Group - login page");
	}
	
	
	@AfterGroups("smoke")
	public void afterGroup() {
		System.out.println("After Group - logout");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method - login page");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method - logout");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
}
