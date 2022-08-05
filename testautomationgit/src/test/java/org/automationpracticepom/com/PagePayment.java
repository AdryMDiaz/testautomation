package org.automationpracticepom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePayment {
	
	//Elements Payment
	@FindBy (xpath = "//h1[contains(text(),'Please choose your payment method')]")
	WebElement paymentMethodLocator;
	
	@FindBy (xpath = "//a[@title=\"Pay by check.\"]")
	WebElement btnPayCheck;
	
	//Elements Confirmation
	@FindBy(xpath = "//h1[contains(text(),'Order confirmation')]")
	WebElement confirmLocator;
	
	@FindBy (className = "alert")
	WebElement alertLocator;
	
	@FindBy (xpath = "//a[contains(text(),\\\"Sign out\\\")]")
	WebElement signOutLocator;
		
		public PagePayment(WebDriver driver) {
			PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
		
		public void chooseMethodOPayment() {
			if (paymentMethodLocator.isDisplayed()) {
				btnPayCheck.click();
			} else {
				System.out.println("Payment Method no choose");
			}
		}
		
		public boolean orderConfirmation (String confirmation) {
			System.out.println(confirmation);
			System.out.println(alertLocator.getText());
			return confirmation.equals(alertLocator.getText());	
		}
}
