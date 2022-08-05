package org.automationpracticepom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCart{
	WebDriver driver;
	//Elements Cart
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement imgProductLocator;
	
	@FindBy (css = ".ajax_add_to_cart_button.btn.btn-default")
	WebElement addProductLocator;
	//Elements pop-up
	@FindBy (xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement btnProceedToCheckout;
	
	public PageCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void addCart () {
		Actions action = new Actions(this.driver);
		action.moveToElement(imgProductLocator).moveToElement(addProductLocator).click().build().perform();
	}
}
