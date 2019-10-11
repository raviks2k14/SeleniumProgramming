package com.raviks.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectBoxSeleniumExample {

	WebDriver driver;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ravikumarks/Documents/Practice/SeleniumPractise/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void handleSelectBox() throws InterruptedException {
		Select selectElement = new Select(
				driver.findElement(By.name("country")));

		selectElement.selectByIndex(1);

		Thread.sleep(5000);

		selectElement.selectByValue("INDIA");

		Thread.sleep(5000);

		selectElement.selectByVisibleText("ANTARCTICA");

		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
