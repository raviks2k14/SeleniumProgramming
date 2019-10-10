package com.raviks.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertBoxSelenium {

	WebDriver driver;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ravikumarks/Documents/Practice/SeleniumPractise/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void handleAlertBox() throws InterruptedException {
		driver.findElement(By.name("cusid")).sendKeys("123");
		driver.findElement(By.name("res")).click();

		Thread.sleep(5000);

		driver.findElement(By.name("cusid")).sendKeys("456");
		driver.findElement(By.name("submit")).click();

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		Thread.sleep(5000);

		alert.dismiss();

		driver.findElement(By.name("cusid")).clear();
		driver.findElement(By.name("cusid")).sendKeys("789");
		driver.findElement(By.name("submit")).click();

		Thread.sleep(5000);

		alert.accept();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
