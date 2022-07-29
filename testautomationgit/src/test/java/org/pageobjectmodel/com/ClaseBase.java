package org.pageobjectmodel.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClaseBase {
	//String url = "http://demo.guru99.com/test/newtours/";
	
	//declaraci�n del objeto
	private WebDriver driver;
	
	//constructor de la clase
	public ClaseBase(WebDriver driver) {
		this.driver = driver;
	}
	
	//M{etodo de conexi�n con Chrome
	public WebDriver chromeDriverConnection () {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	//Creaci�n de M�todos y acciones
	public WebElement findElement (By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	public Boolean isDisplayed (By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit (String url) {
		driver.get(url);
	}
}
