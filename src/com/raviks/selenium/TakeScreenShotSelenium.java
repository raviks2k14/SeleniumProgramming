package com.raviks.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class TakeScreenShotSelenium {
	WebDriver driver;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ravikumarks/Documents/Practice/SeleniumPractise/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void takeScreenShot() throws IOException {
		TakesScreenshot scrnShot = ((TakesScreenshot) driver);
		File scrFile = scrnShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				"/Users/ravikumarks/Desktop/seleniumscreenshots/"
						+ System.currentTimeMillis() + ".png");
		FileUtils.copyFile(scrFile, destFile);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
