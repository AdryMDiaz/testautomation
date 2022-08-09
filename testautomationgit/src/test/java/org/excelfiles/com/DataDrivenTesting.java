package org.excelfiles.com;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting {
	private WebDriver driver;
	private WriteExcelFiles writeFile;
	private ReadExcelFiles readFile;
	
	private By searchLocator = By.id("search_query_top");
	private By btnSearchLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		writeFile = new WriteExcelFiles();
		readFile = new ReadExcelFiles();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws IOException {
		String filepath = "C:\\Users\\Paco_\\Documents\\Test_Automation\\test_automation.xlsx";
		String searchText = readFile.getCellValue(filepath, "Hoja1", 2, 0);
		driver.findElement(searchLocator).sendKeys(searchText);
		driver.findElement(btnSearchLocator).click();
		String resultText = driver.findElement(resultTextLocator).getText();
		System.out.println("Page result text: " + resultText);
		
		readFile.readExcel(filepath, "Hoja1");
		writeFile.writeCellValue(filepath, "Hoja1", 2, 1, resultText);
		
		readFile.readExcel(filepath, "Hoja1");
	}
}