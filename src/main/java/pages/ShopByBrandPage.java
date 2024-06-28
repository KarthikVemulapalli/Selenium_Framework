package pages;

import org.openqa.selenium.By;
import constants.PageConstants;

public class ShopByBrandPage extends HomePage {

	By xpath_linkAcePump = By.xpath("//a[@title='Ace Pump']");
	
	public void clickAcePump() {
		click(xpath_linkAcePump);
		softValidateWithPageScreenshot(PageConstants.ACE_PUMP_PAGE_TITLE, getPageTitle(), "Ace Pump Page Title Validation");
	}
	
}