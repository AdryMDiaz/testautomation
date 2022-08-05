package org.automationpracticepom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSignIn {
	
	//Elements Page Login
	@FindBy(id = "email")
	WebElement loginMailLocator;
	
	@FindBy(id = "passwd")
	WebElement loginPasswordLocator;
	
	@FindBy(id = "SubmitLogin")
	WebElement btnLoginLocator;
		
	public PageSignIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	private void typeEmail (String email) {
		loginMailLocator.sendKeys(email);
	}
	
	private void typePassword (String passwd) {
		loginPasswordLocator.sendKeys(passwd);
	}
	
	private void clickLogin () {
		btnLoginLocator.click();
	}
	
	public void authentication (String email, String passwd) {
		if (loginMailLocator.isDisplayed()) { 
			typeEmail(email);
			typePassword(passwd);
			clickLogin();
		} else {
			System.out.println("Authentication failed");
		}
	}
	
	/*public void authentication (String email) {
		if (isDisplayed(loginMailLocator)) {
			type("pepis@gmail.com", loginMailLocator);
			type("123456", loginPasswordLocator);
			click(btnLoginLocator);
		} else {
			System.out.println("Authentication failed");

		}
	}*/
}
