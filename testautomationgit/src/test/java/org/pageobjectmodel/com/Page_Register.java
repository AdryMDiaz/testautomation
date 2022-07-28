package org.pageobjectmodel.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_Register extends ClaseBase{
	
	//Elmentos página REGISTER
		By registerLinkLocator = By.linkText("REGISTER");
		By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");
		By registerMailLocator = By.id("email");
		By registerPasswordLocator = By.name("password");
		By registerConfirmPasswordLocator = By.cssSelector("input[name=\"confirmPassword\"]");
		By registerBtnLocator = By.name("submit");
		By registerMessage = By.tagName("font");
		By homeLinkLocator = By.linkText("Home");

	public Page_Register(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser() throws InterruptedException {
		click(registerLinkLocator);
		Thread.sleep(2000);
		if (isDisplayed(registerPageLocator)) {
			type("qualityadmin", registerMailLocator);
			type("quality", registerPasswordLocator);
			type("quality", registerConfirmPasswordLocator);
			
			click(registerBtnLocator);
		} else {
			System.out.print("Register page was not found");
		}
	}
	
	public String registerMessage() {
		List<WebElement> fonts = findElements(registerMessage);
		return getText(fonts.get(5));
	}

}
