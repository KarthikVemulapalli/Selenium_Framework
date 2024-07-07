package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends HomePage {
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = "input[data-bind*='hasFocus: emailFocused']")
	private WebElement css_textboxEmailAddress;
	
	@FindBy (xpath = "(//input[@name='firstname'])[1]")
	private WebElement xpath_textboxFirstName;
	
	@FindBy (xpath = "(//input[@name='lastname'])[1]")
	private WebElement xpath_textboxLastName;
	
	@FindBy (xpath = "(//input[@name='street[0]'])[1]")
	private WebElement xpath_textboxStreetAddress;
	
	@FindBy (xpath = "(//select[@name='country_id'])[1]")
	private WebElement xpath_dropdownCountry;

	@FindBy (xpath = "//*[contains(text(),'Shipping Address')]")
	private WebElement xpath_titleShippingAddress;
	
	By byxpath_titleShippingAddress = By.xpath("//*[contains(text(),'Shipping Address')]");
	
	@FindBy (xpath = "(//select[@name='region_id'])[1]")
	private WebElement xpath_dropdownState;
	
	@FindBy (xpath = "(//input[@name='city'])[1]")
	private WebElement xpath_textboxCity;
	
	@FindBy (xpath = "(//input[@name='postcode'])[1]")
	private WebElement xpath_textboxPostalCode;
	
	@FindBy (xpath = "(//input[@name='telephone'])[2]")
	private WebElement xpath_textboxPhoneNumber;
	
	@FindBy (css = "input[title='Credit Card Number']")
	private WebElement css_textboxCreditCard;
	
	@FindBy (css = "select#authnetcim-cc-exp-month")
	private WebElement css_dropdownMonth;
	
	@FindBy (css = "select#authnetcim-cc-exp-year")
	private WebElement css_dropdownYear;
	
	@FindBy (css = "input#authnetcim-cc-cid")
	private WebElement css_textboxCVV;
	
	@FindBy (css = "button[title='Place Order']")
	private WebElement css_buttonPlaceOrder;
	
	By bycss_buttonPlaceOrder = By.cssSelector("button[title='Place Order']");
	
	public void enterEmail(String email) {
		waitForWebElement(byxpath_titleShippingAddress, 30);
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
		
		waitForWebElement(bycss_buttonPlaceOrder, 30);
	}
	
}