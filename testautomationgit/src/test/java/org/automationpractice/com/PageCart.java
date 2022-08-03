package org.automationpractice.com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageCart extends ClaseBase{
	//Elements Login
	By signInLocator = By.xpath("//a[contains(text(), \"Sign in\")]");
	//By signInLocator = By.xpath("//*[@title='Log in to your customer account']"))
	By loginMailLocator = By.id("email");
	//By loginMailLocator = By.cssSelector("#email"));
	By loginPasswordLocator = By.id("passwd");
	//By loginPasswordLocator = By.cssSelector("#passwd"));
	By btnLoginLocator = By.id("SubmitLogin");
	//By btnLoginLocator = By.cssSelector("#SubmitLogin"));
	//By categoryTShirts = By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]");
	//Elements Cart
	By categoryTShirtsLocator = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[contains(text(),\"T-shirts\")]");
	By imgProductLocator = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
	//By addProduct1 = By.xpath("//span[contains(text(),'Add to cart')]");
	By addProductLocator = By.cssSelector(".ajax_add_to_cart_button.btn.btn-default");
	//Elements pop-up
	//By btnProceedToCheckout = By.cssSelector("a.btn.btn-default.button.button-medium > span:nth-child(1)");
	By btnProceedToCheckout = By.xpath("//span[contains(text(),'Proceed to checkout')]");
	//Elements Summary Cart
	By summaryCartLocator = By.xpath("//h1[contains(text(),'Shopping-cart summary')]");
	By btnConfirmToCheckout = By.xpath("//p//span[contains(text(),'Proceed to checkout')]");
	//Elements addresses
	By addressesLocator = By.xpath("//h1[contains(text(),'Addresses')]");
	By btnToCheckout = By.xpath("//button/span[contains(text(),'Proceed to checkout')]");
	//Elements Shipping
	By agreeTermsLocator = By.id("cgv");
	By btnProcessCarrier = By.name("processCarrier");
	//Elements Payment
	By btnPayCheck = By.xpath("//a[@title=\"Pay by check.\"]");
	By btnConfirmOrder = By.xpath("//span[contains(text(),'I confirm my order')]");
	//Elements Confirmation
	By confirmLocator = By.xpath("//h1[contains(text(),'Order confirmation')]");
	By alertLocator = By.className("alert");
	By signOutLocator = By.xpath("//a[contains(text(),\"Sign out\")]");
	
	public PageCart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void authentication () {
		click(signInLocator);
		if (isDisplayed(loginMailLocator)) {
			type("pepis@gmail.com", loginMailLocator);
			type("123456", loginPasswordLocator);
			click(btnLoginLocator);
		} else {
			System.out.println("Authentication failed");

		}
	}
	
	public void addCart () {
		WebElement menuCategories = findElement(categoryTShirtsLocator);
		click(menuCategories);
	}
	
	public void summaryCart () {
		if (isDisplayed(summaryCartLocator)) {
			click(btnConfirmToCheckout);
			click(btnToCheckout);
			click(agreeTermsLocator);
			click(btnProcessCarrier);
			click(btnPayCheck);
			click(btnConfirmOrder);
		} else {
			System.out.println("Summary Cart was no present");
		}
	}
	
	public void confirmOrder () {
		if (isDisplayed(confirmLocator)) {
			WebElement msgConfirmation = findElement(alertLocator);
			Assert.assertTrue(msgConfirmation.isDisplayed());
			click(signOutLocator);
		} else {
			System.out.println("Your order isn't complete");
		}
	}
}
