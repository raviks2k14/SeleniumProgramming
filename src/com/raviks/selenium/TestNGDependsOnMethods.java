package com.raviks.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGDependsOnMethods {

	WebDriver webDriver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/ravikumarks/Documents/Practice/SeleniumPractise/chromedriver");
		webDriver = new ChromeDriver();
		webDriver.get("https://www.google.com");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.MILLISECONDS);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);	
	}

	@Test(priority=2)
	public void executeTest1() {
		String title = webDriver.getTitle();
		Assert.assertEquals(title, "Google");
	}

	@Test(priority=1, dependsOnMethods="executeTest1")
	public void executeTest2() {
		System.out.println("Test2");
	}

	@AfterClass
	public void tearDown() {
		webDriver.quit();
	}

}
