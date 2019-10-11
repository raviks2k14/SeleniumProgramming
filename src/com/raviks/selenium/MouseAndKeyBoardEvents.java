package com.raviks.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseAndKeyBoardEvents {
	WebDriver driver;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ravikumarks/Documents/Practice/SeleniumPractise/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void mouseHoverLink() throws InterruptedException {
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		Action action = actions.moveToElement(
				driver.findElement(By.linkText("Home"))).build();
		action.perform();
	}

	@Test(priority = 2)
	public void keyDownEvent() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement textUserName = driver.findElement(By.name("userName"));
		Thread.sleep(5000);
		actions.moveToElement(textUserName).click()
				.keyDown(textUserName, Keys.SHIFT)
				.sendKeys(textUserName, "Hello")
				.keyUp(textUserName, Keys.SHIFT).doubleClick(textUserName)
				.perform();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
