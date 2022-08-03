package org.automationpractice.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class TestAuthentication {
	private WebDriver driver;
	PageAuthentication pageAuthentication;

	@Before
	public void setUp() throws Exception {
		pageAuthentication = new PageAuthentication(driver);
		driver = pageAuthentication.chromeDriverConnection();
		pageAuthentication.visit("http://automationpractice.com/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		pageAuthentication.createAccount();
		Thread.sleep(2000);
		pageAuthentication.accountCreation();
		Thread.sleep(10000);

	}

}
