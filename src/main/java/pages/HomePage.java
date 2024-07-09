package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webcore.cucumber.CommonFunctions;

public class HomePage extends CommonFunctions {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//span[contains(text(), 'Shop By Brand')]")
	private WebElement xpath_linkShopByBrand;
	
	By byxpath_linkShopByBrand = By.xpath("//span[contains(text(), 'Shop By Brand')]");
	
	public void clickShopByBrand() {
		waitForWebElement(byxpath_linkShopByBrand, 10);
		logReportInfo("JavaScript Executor Element Click Performed");
		clickUsingJavaScriptExecutor(xpath_linkShopByBrand);
		coolingTime(5);
	}
	
}