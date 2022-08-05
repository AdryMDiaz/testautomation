package org.automationpracticepom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageShopping {
	
	//Elements Shipping
	@FindBy (xpath = "//h1[contains(text(),'Shipping')]")
	WebElement shoppingLocator;
	
	@FindBy (id = "cgv")
	WebElement agreeTermsLocator;
	
	@FindBy (name = "processCarrier")
	WebElement btnProcessCarrier;

	public PageShopping(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void confirmShipping () {
		if (shoppingLocator.isDisplayed()) {
			agreeTermsLocator.click();
			btnProcessCarrier.click();
		} else {
			System.out.println("You must agree to the terms of service before continuing.");
		}
	}
}
