package org.pageobjectmodel.com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Test_Register {
	
	private WebDriver driver;
	Page_Register registerPage;

	@Before
	public void setUp() throws Exception {
		registerPage = new Page_Register(driver);
		driver = registerPage.chromeDriverConnection();
		registerPage.visit("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void registerTest() throws InterruptedException {
		registerPage.registerUser();
		Thread.sleep(2000);
		assertEquals("Note: Your user name is qualityadmin.",registerPage.registerMessage());
		registerPage.click(registerPage.homeLinkLocator);
		Thread.sleep(10000);
	}

}
