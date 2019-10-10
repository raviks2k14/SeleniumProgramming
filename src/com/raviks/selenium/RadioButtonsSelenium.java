package com.raviks.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsSelenium {

	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ravikumarks/Documents/Practice/SeleniumPractise/chromedriver");
		webDriver = new ChromeDriver();
		webDriver.get("http://demo.guru99.com/test/ajax.html");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts()
				.pageLoadTimeout(40, TimeUnit.MILLISECONDS);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
	}

	@Test
	public void printRadioButtonNames() throws InterruptedException {
		List<WebElement> elements = webDriver.findElements(By.name("name"));
		System.out.println("Number of elements:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Radio button text:"
					+ elements.get(i).getAttribute("value"));
		}
	}

	@Test
	public void clickRadio() throws InterruptedException {
		WebElement element = webDriver.findElement(By.id("yes"));
		element.click();
		Thread.sleep(20000);
		webDriver.findElement(By.id("buttoncheck")).click();
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}
