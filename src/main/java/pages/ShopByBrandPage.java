package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import constants.PageConstants;

public class ShopByBrandPage extends HomePage {
	
	public ShopByBrandPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//a[@title='Ace Pump']")
	private WebElement xpath_linkAcePump;
	
	By byxpath_linkAcePump = By.xpath("//a[@title='Ace Pump']");
	
	public void clickAcePump() {
		waitForWebElement(byxpath_linkAcePump, 20);
		click(xpath_linkAcePump);
		softValidateWithPageScreenshot(PageConstants.ACE_PUMP_PAGE_TITLE, getPageTitle(), "Ace Pump Page Title Validation");
	}
	
}