package org.pageobjectmodel.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_SignIn extends ClaseBase{
	//Elementos página SIGN-ON
		By signInUserLocator = By.name("userName");
		By signInpasswordLocator = By.name("password");
		By signInBtnLocator = By.name("submit");
		By sigInMessage = By.tagName("font");
		By flightsLocator = By.linkText("Flights");

	public Page_SignIn(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void signInUser () {
		if (isDisplayed(signInUserLocator)) {
			type("qualityadmin", signInUserLocator);
			type("quality", signInpasswordLocator);
			
			click(signInBtnLocator);
		} else {
			System.out.print("username texbox was not present");
		}
	}
	
	public String signInMessage () {
		List<WebElement> fonts = findElements(sigInMessage);
		return getText(fonts.get(3));
	}

}
