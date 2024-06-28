package pages;

import org.openqa.selenium.By;

public class CheckOutPage extends HomePage {

	By css_textboxEmailAddress = By.cssSelector("input[data-bind*='hasFocus: emailFocused']");
	By xpath_textboxFirstName = By.xpath("(//input[@name='firstname'])[1]");
	By xpath_textboxLastName = By.xpath("(//input[@name='lastname'])[1]");
	By xpath_textboxStreetAddress = By.xpath("(//input[@name='street[0]'])[1]");
	By xpath_dropdownCountry = By.xpath("(//select[@name='country_id'])[1]");
	By xpath_titleShippingAddress = By.xpath("//*[contains(text(),'Shipping Address')]");
	By xpath_dropdownState = By.xpath("(//select[@name='region_id'])[1]");
	By xpath_textboxCity = By.xpath("(//input[@name='city'])[1]");
	By xpath_textboxPostalCode = By.xpath("(//input[@name='postcode'])[1]");
	By xpath_textboxPhoneNumber = By.xpath("(//input[@name='telephone'])[2]");
	By css_textboxCreditCard = By.cssSelector("input[title='Credit Card Number']");
	By css_dropdownMonth = By.cssSelector("select#authnetcim-cc-exp-month");
	By css_dropdownYear = By.cssSelector("select#authnetcim-cc-exp-year");
	By css_textboxCVV = By.cssSelector("input#authnetcim-cc-cid");
	By css_buttonPlaceOrder = By.cssSelector("button[title='Place Order']");
	
	public void enterEmail(String email) {
		waitForWebElement(xpath_titleShippingAddress, 30);
		enterText(css_textboxEmailAddress, email);
	}
	
	public void enterFirstAndLastName(String firstName, String lastName) {
		enterText(xpath_textboxFirstName, firstName);
		enterText(xpath_textboxLastName, lastName);
	}
	
	public void enterStreetAddress(String streetAddress) {
		enterText(xpath_textboxStreetAddress, streetAddress);
	}
	
	public void selectCountry(String country) {
		selectDropdownByValue(xpath_dropdownCountry, country);
	}
	
	public void selectState(String state) {
		selectDropdownByValue(xpath_dropdownState, state);
	}
	
	public void enterCity(String city) {
		enterText(xpath_textboxCity, city);
	}
	
	public void enterPostalCode(String postalCode) {
		enterText(xpath_textboxPostalCode, postalCode);
	}
	
	public void enterPhoneNumber(String phoneNo) {
		enterText(xpath_textboxPhoneNumber, phoneNo);
	}

	public void enterCreditCardDetails(String ccNo, String expMonth, String expYear, String cvv) {
		enterText(css_textboxCreditCard, ccNo);
		selectDropdownByValue(css_dropdownMonth, expMonth);
		selectDropdownByValue(css_dropdownYear, expYear);
		enterText(css_textboxCVV, cvv);
		
		waitForWebElement(css_buttonPlaceOrder, 30);
		capturePageScreenshot("CheckOut Page", true);
	}
	
}