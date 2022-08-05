package org.automationpracticepom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAddress {
	
	//Elements addresses
	@FindBy (xpath = "//h1[contains(text(),'Addresses')]")
	WebElement addressesLocator;
	
	@FindBy (xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement btnToCheckout;

	public PageAddress(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void confirmAddress () {
		if (addressesLocator.isDisplayed()) {
			btnToCheckout.click();
		} else {
			System.out.println("Your delivery Address is not found");
		}
	}
}
