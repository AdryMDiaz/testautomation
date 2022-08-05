package org.automationpracticepom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSummary {
	
	//Elements Summary Cart
	@FindBy (xpath = "//h1[contains(text(),'Shopping-cart summary')]")
	WebElement summaryCartLocator;
	
	@FindBy (xpath = "//p//span[contains(text(),'Proceed to checkout')]")
	WebElement btnConfirmToCheckout;
	
	public PageSummary(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void confirmCart() {
		if (summaryCartLocator.isDisplayed()) {
			btnConfirmToCheckout.click();
		} else {
			System.out.println("Your shopping cart is void");
		}
	}
}
