package com.amazon.app;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.app.page.AmazonHomePage;
import com.amazon.app.utility.ExcelUtility;
import com.amazon.app.utility.Utility;
import com.amazon.app.utility.Xls_Reader;
@Listeners(com.amazon.app.extendReportListner.ExtendReport.class)

public class AmazonTest  {

	public static WebDriver dir;
	public AmazonHomePage homepg;
	String title;
	ArrayList<String> data;
	Iterator<String> itr;
	int rowCount;
	String name;
	Xls_Reader reader;

	
	@BeforeTest
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\jar\\chromedriver.exe");
		dir = new ChromeDriver();
		dir.manage().window().maximize();
		String path = System.getProperty("user.dir");

		// call read file method to read a file
		/*
		 * data = ExcelUtility.readFile(path, "demo.xlsx", "Test", "TestData");
		 * System.out.println("The data is :" + data.toString());
		 */
		reader = new Xls_Reader(path + "\\demo.xlsx");
		rowCount = reader.getRowCount("Test");
	}

	@Test
	public void testAddtoCart() throws IOException {

		// itr = data.iterator();
		homepg = new AmazonHomePage(dir);

		// while (itr.hasNext()) {
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			name = reader.getCellData("Test", "TestData", rowNum);
			dir.get("https://www.amazon.com");

			homepg.setSearchInput(name);
			homepg.clickSearchBtn();
			homepg.clicklink();
			homepg.clickAddtoCartbtn();
			title = homepg.getPageTitle();
			System.out.println("Page title-->" + title);
//			Assert.assertTrue(title.contains("Amazon.com Shopping Cart"),
//					"TestCase failed :Page title mismatch");
//
//			Assert.assertTrue(homepg.getValueofCart().equalsIgnoreCase("1"));
//			homepg.clickProceedtocheckout();
//			title = homepg.getPageTitle();
//			System.out.println("Page title-->" + title);
		//Assert.assertTrue(title.contains("Amazon Sign In"),
			//		"TestCase failed :Page title mismatch");
		}
		// }
		dir.quit();

	
	}
	/*@AfterTest
	public void terDown(){
		dir.quit();
	}
*/
}