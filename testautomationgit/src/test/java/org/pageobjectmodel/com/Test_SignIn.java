package org.pageobjectmodel.com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Test_SignIn {
	
	private WebDriver driver;
	Page_SignIn signInPage;

	@Before
	public void setUp() throws Exception {
		signInPage = new Page_SignIn(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void signInTest() throws InterruptedException {
		signInPage.signInUser();
		Thread.sleep(2000);
		assertEquals("Thank you for Loggin.",signInPage.signInMessage());
		signInPage.click(signInPage.flightsLocator);
		Thread.sleep(5000);
		
		assertEquals(signInPage.selectDropdownList_Passenger(), "2");
		assertEquals(signInPage.selectDropdownList_DepartingFrom(), "Paris");
		assertEquals(signInPage.selectDropdownList_OnMonth(), "December");
		assertEquals(signInPage.selectDropdownList_OnDay(), "16");
		assertEquals(signInPage.selectDropdownList_ArrivingIn(), "London");
		assertEquals(signInPage.selectDropdownList_ReturningMonth(), "December");
		assertEquals(signInPage.selectDropdownList_ReturningDay(), "31");
		assertEquals(signInPage.selectDropdownList_Airline(), "Blue Skies Airlines");
		signInPage.click(signInPage.flightsBtnContinueLocator);
		signInPage.findElement(signInPage.flightsFinderLocator);
		Thread.sleep(2000);
	}

}
