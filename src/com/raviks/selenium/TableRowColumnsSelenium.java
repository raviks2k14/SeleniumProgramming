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

public class TableRowColumnsSelenium {

	WebDriver driver;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ravikumarks/Documents/Practice/SeleniumPractise/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/table.html");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void printTableDataWithVaryingRows() throws InterruptedException {

		WebElement mytable = driver.findElement(By
				.xpath("/html/body/table/tbody"));
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));

		for (int r = 0; r < rows_table.size(); r++) {
			List<WebElement> columns_row = rows_table.get(r).findElements(
					By.tagName("td"));

			for (int c = 0; c < columns_row.size(); c++) {
				String column_content = columns_row.get(c).getText();
				System.out.println("Row[" + r + "], Column[" + c + "] : "
						+ column_content);
			}
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
