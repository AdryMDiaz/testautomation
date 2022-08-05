package org.automationpracticepom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIndex {
	
	//Elements Page Index
	@FindBy(className = "login")
	private WebElement signInLocator;
	
	@FindBy (xpath = "//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[contains(text(),\"T-shirts\")]")
	private WebElement labelT_Shirts;

	public PageIndex(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void signIn () {
		signInLocator.click();
	}
	
	public void selectTShirts () {
		labelT_Shirts.click();
	}
}
