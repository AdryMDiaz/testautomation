package org.automationpracticepom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageConfirm {
	
	@FindBy (xpath = "//h3[contains(text(),'Check payment')]")
	WebElement checkPaymentLocator;
	
	@FindBy (xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement btnConfirmOrder;

	public PageConfirm(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void orderSummary () {
		if (checkPaymentLocator.isDisplayed()) {
			btnConfirmOrder.click();
		} else {
			System.out.println("You haven't chosen to pay by check");
		}
	}
}
