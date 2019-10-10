package com.raviks.selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGSeleniumBasic {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	@Test(priority=8,groups="Ravi")
	public void executeTest1() {
		System.out.println("Test1");
	}

	@Test(priority=7,groups="Paapu")
	public void executeTest2() {
		System.out.println("Test2");
	}
	
	@Test(priority=6,groups="Ravi")
	public void executeTest3() {
		System.out.println("Test1");
	}

	@Test(priority=5,groups="Paapu")
	public void executeTest4() {
		System.out.println("Test2");
	}
	
	@Test(priority=4,groups="Ravi")
	public void executeTest5() {
		System.out.println("Test1");
	}

	@Test(priority=3,groups="Paapu")
	public void executeTest6() {
		System.out.println("Test2");
	}
	
	@Test(priority=2,groups="Ravi")
	public void executeTest7() {
		System.out.println("Test1");
	}

	@Test(priority=1,groups="Paapu")
	public void executeTest8() {
		System.out.println("Test2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}

}
