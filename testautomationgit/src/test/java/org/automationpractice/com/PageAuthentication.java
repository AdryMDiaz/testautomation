package org.automationpractice.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageAuthentication extends ClaseBase{
	
	By signInLocator = By.xpath("//a[contains(text(), \"Sign in\")]");
	By signMailCreateLocator = By.id("email_create");
	By signBtnCreateLocator = By.name("SubmitCreate");
	By signPageLocator = By.xpath("//h1[contains(text(),\"Create an account\")]");
	By signGenderLocator1 = By.id("id_gender1"); //Masculino
	By signGenderLocator2 = By.id("id_gender2"); //Femenino
	By signFirstNameCustomerLocator = By.name("customer_firstname");
	By signLastNameCustomerLocator = By.name("customer_lastname");
	By signMailLocator = By.id("email"); //se llena automaticamente
	By signPasswdLocator = By.id("passwd");
	By signDropdownDaysLocator = By.cssSelector("select#days option:nth-of-type(21)");
	By signDropdownMonthLocator = By.cssSelector("select#months option:nth-of-type(12)");
	By signDropdownYearLocator = By.cssSelector("select#years option:nth-of-type(43)");
	By signFirstnameLocator = By.name("firstname"); //Se llena automaticamente
	By signLastnameLocator = By.name("lastname"); //Se llena automaticamente
	By signCompanyLocator = By.id("company");
	By signAddressLocator = By.id("address1");
	By signAddAdressLocator = By.id("address2");
	By signCityLocator = By.name("city");
	By signDropdownStateLocator = By.cssSelector("select#id_state option:nth-of-type(2)");
	By signPostalCodeLocator = By.id("postcode"); //00000
	By signDropdownCountryLocator = By.id("id_country");
	By signAddInformationLocator = By.id("other");
	By signHomePhoneLocator = By.name("phone");
	By signMobilePhoneLocator = By.id("phone_mobile");
	By signAliasLocator = By.name("alias");
	By signBtnRegisterLocator = By.id("submitAccount");
	By signSuccessLocatgor = By.xpath("//h1[@class=\"page-heading\"]");
	By signOutLocator = By.xpath("//a[contains(text(), \"Sign out\")]");

	public PageAuthentication(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void createAccount () {
		click(signInLocator);
		if (isDisplayed(signMailCreateLocator)) {
			type("pepitas@gmail.com", signMailCreateLocator);
			click(signBtnCreateLocator);
		} else {
			System.out.println("Create An Account was no present");
		}
		
	}
	
	public void accountCreation () {
		if (isDisplayed(signPageLocator)) {
			click(signGenderLocator1);
			type("Pepita", signFirstNameCustomerLocator);
			type("Perez", signLastNameCustomerLocator);
			type("12345678", signPasswdLocator);
			click(signDropdownDaysLocator);
			click(signDropdownMonthLocator);
			click(signDropdownYearLocator);
			type("Anonima", signCompanyLocator);
			type("Carrera 55 # 55-55", signAddressLocator);
			type("Int 101", signAddInformationLocator);
			type("Alabama", signCityLocator);
			click(signDropdownStateLocator);
			type("00000", signPostalCodeLocator);
			type("Any", signAddInformationLocator);
			type("6010000000", signHomePhoneLocator);
			type("3000000000", signMobilePhoneLocator);
			findElement(signAliasLocator).clear();
			type("Pepita", signAliasLocator);
			click(signBtnRegisterLocator);
		} else {
			System.out.println("Authentication Form was no present");
		}
	}
}
