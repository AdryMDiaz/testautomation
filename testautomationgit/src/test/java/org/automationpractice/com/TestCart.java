package org.automationpractice.com;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCart {
	
	private WebDriver driver;
	PageCart pageCart;

	@Before
	public void setUp() throws Exception {
		pageCart = new PageCart(driver);
		driver = pageCart.chromeDriverConnection();
		pageCart.visit("http://automationpractice.com/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		pageCart.authentication();
		Thread.sleep(1000);
		
		pageCart.addCart();
		Thread.sleep(1000);
		
		Actions action = new Actions(driver);
		WebElement selectImg = pageCart.findElement(pageCart.imgProductLocator);
		action.moveToElement(selectImg).moveToElement(pageCart.findElement(pageCart.addProductLocator)).click().build().perform();
		
		new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(pageCart.btnProceedToCheckout)).click();
		
		pageCart.summaryCart();
		Thread.sleep(1000);
		
		pageCart.confirmOrder();
		Thread.sleep(1000);
		//WebElement msgConfirmation = driver.findElement(By.className("alert"));
		//Assert.assertTrue(msgConfirmation.isDisplayed());
	}

}
