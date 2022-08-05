package org.automationpracticepom.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestCart {

	WebDriver driver;
	PageIndex pageIndex;
	PageSignIn pageSignIn;
	PageCart pageCart;
	PageSummary pageSummary;
	PageAddress pageAddress;
	PageShopping pageShopping;
	PagePayment pagePayment;
	PageConfirm pageConfirm;
	
	private void loadPages(WebDriver driver) {
		pageIndex = new PageIndex(driver);
		pageSignIn = new PageSignIn(driver);
		pageCart = new PageCart(driver);
		pageSummary = new PageSummary(driver);
		pageAddress = new PageAddress(driver);
		pageShopping =  new PageShopping(driver);
		pagePayment = new PagePayment(driver);
		pageConfirm = new PageConfirm(driver);
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		loadPages(driver);
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		pageIndex.signIn();
		Thread.sleep(1000);
		
		pageSignIn.authentication("pepis@gmail.com", "123456");
		Thread.sleep(1000);
		
		pageIndex.selectTShirts();
		Thread.sleep(1000);
		
		pageCart.addCart();
		new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(pageCart.btnProceedToCheckout)).click();
		Thread.sleep(1000);
		
		pageSummary.confirmCart();
		Thread.sleep(1000);
		
		pageAddress.confirmAddress();
		Thread.sleep(1000);
		
		pageShopping.confirmShipping();
		Thread.sleep(1000);
		
		pagePayment.chooseMethodOPayment();
		Thread.sleep(1000);
		
		pageConfirm.orderSummary();
		Thread.sleep(1000);
		
		pagePayment.orderConfirmation("Your order on My Store is complete.");
		Thread.sleep(1000);
		}
}
