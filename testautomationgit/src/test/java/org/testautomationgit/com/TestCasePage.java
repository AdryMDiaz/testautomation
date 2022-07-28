package org.testautomationgit.com;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCasePage {
	
private WebDriver driver;
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");
	By registerMailLocator = By.id("email");
	By registerPasswordLocator = By.name("password");
	By registerConfirmPasswordLocator = By.cssSelector("input[name=\"confirmPassword\"]");
	By registerBtnLocator = By.name("submit");
	By homeLinkLocator = By.linkText("Home");
	
	By signinLocator = By.name("userName");
	By signinpasswordLocator = By.name("password");
	By signBtnLocator = By.name("submit");
	By flightsLocator = By.linkText("Flights");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	//Case 1: Registro de usuario
	@Test
	public void registerUsertest() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		
		if (driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(registerMailLocator).sendKeys("qualityadmin");
			driver.findElement(registerPasswordLocator).sendKeys("quality");
			driver.findElement(registerConfirmPasswordLocator).sendKeys("quality");
			driver.findElement(registerBtnLocator).click();
		} else {
			System.out.print("Register page was not found");
		}
		
		List<WebElement> fontsRegister = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is qualityadmin.", fontsRegister.get(5).getText());
		
		driver.findElement(homeLinkLocator).click();
	}
	
	// Case 2: Ingreso con el usuario creado anteriormente
	@Test
	public void signInUserTest () throws InterruptedException {
		if (driver.findElement(signinLocator).isDisplayed()) {
			driver.findElement(signinLocator).sendKeys("qualityadmin");
			driver.findElement(signinpasswordLocator).sendKeys("quality");
			driver.findElement(signBtnLocator).click();
			Thread.sleep(2000);
		} else {
			System.out.print("Sign-On Page was not found");
		}
		
		List<WebElement> fontsSignIn = driver.findElements(By.tagName("font"));
		assertEquals("Thank you for Loggin.", fontsSignIn.get(3).getText());
		
		driver.findElement(flightsLocator).click();
	}

}
