package org.pageobjectmodel.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page_SignIn extends ClaseBase {
	// Elementos página SIGN-ON
	By signInUserLocator = By.name("userName");
	By signInpasswordLocator = By.name("password");
	By signInBtnLocator = By.name("submit");
	By signInMessage = By.tagName("font");
	By flightsLocator = By.linkText("Flights");

	// Elementos página FLIGHTS
	By flightsDropdownList_Passengers = By.name("passCount");
	By flightsDropdownList_DepartingFrom = By.name("fromPort");
	By flightsDropdownList_OnMonth = By.name("fromMonth");
	By flightsDropdownList_OnDay = By.name("fromDay");
	By flightsDropdownList_ArrivingIn = By.name("toPort");
	By flightsDropdownList_ReturningMonth = By.name("toMonth");
	By flightsDropdownList_ReturningDay = By.name("toDay");
	By flightsDropdownList_Airline = By.name("airline");
	By flightsBtnContinueLocator = By.name("findFlights");
	By flightsFinderLocator = By.xpath("//font[contains(text(),\"back\")]");

	public Page_SignIn(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void signInUser() {
		if (isDisplayed(signInUserLocator)) {
			type("qualityadmin", signInUserLocator);
			type("quality", signInpasswordLocator);

			click(signInBtnLocator);
		} else {
			System.out.print("username texbox was not present");
		}
	}

	public String signInMessage() {
		List<WebElement> fonts = findElements(signInMessage);
		return getText(fonts.get(3));
	}

	/*
	 * public String selectDropdownList_Passenger() { WebElement dropdownList =
	 * findElement(flightsDropdownList_Passengers); List<WebElement> options =
	 * dropdownList.findElements(By.tagName("option"));
	 * 
	 * for (int i = 0; i < options.size(); i++) { if
	 * (getText(options.get(i)).equals("2 ")) { click(options.get(i)); } }
	 * 
	 * String selectOption = ""; for (int i = 0; i < options.size(); i++) { if
	 * (options.get(i).isSelected()) { selectOption = getText(options.get(i)); } }
	 * return selectOption; }
	 */

	public String selectDropdownList_Passenger() {
		Select selectList = new Select(findElement(flightsDropdownList_Passengers));
		selectList.selectByVisibleText("2");
		return getText(selectList.getFirstSelectedOption());
	}

	public String selectDropdownList_DepartingFrom() {
		Select selectList = new Select(findElement(flightsDropdownList_DepartingFrom));
		selectList.selectByVisibleText("Paris");
		return getText(selectList.getFirstSelectedOption());
	}

	public String selectDropdownList_OnMonth() {
		Select selectList = new Select(findElement(flightsDropdownList_OnMonth));
		selectList.selectByVisibleText("December");
		return getText(selectList.getFirstSelectedOption());
	}

	public String selectDropdownList_OnDay() {
		Select selectList = new Select(findElement(flightsDropdownList_OnDay));
		selectList.selectByVisibleText("16");
		return getText(selectList.getFirstSelectedOption());
	}

	public String selectDropdownList_ArrivingIn() {
		Select selectList = new Select(findElement(flightsDropdownList_ArrivingIn));
		selectList.selectByVisibleText("London");
		return getText(selectList.getFirstSelectedOption());
	}

	public String selectDropdownList_ReturningMonth() {
		Select selectList = new Select(findElement(flightsDropdownList_ReturningMonth));
		selectList.selectByVisibleText("December");
		return getText(selectList.getFirstSelectedOption());
	}

	public String selectDropdownList_ReturningDay() {
		Select selectList = new Select(findElement(flightsDropdownList_ReturningDay));
		selectList.selectByVisibleText("31");
		return getText(selectList.getFirstSelectedOption());
	}

	public String selectDropdownList_Airline() {
		Select selectList = new Select(findElement(flightsDropdownList_Airline));
		selectList.selectByVisibleText("Blue Skies Airlines");
		return getText(selectList.getFirstSelectedOption());
	}
}
