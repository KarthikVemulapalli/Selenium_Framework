package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import webcore.Interactions;

public class HomePage extends Interactions {

	By xpath_linkShopByBrand = By.xpath("//span[contains(text(), 'Shop By Brand')]");
	
	public void clickShopByBrand() {
		WebElement element = driver.findElement(xpath_linkShopByBrand);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//click(xpath_linkShopByBrand);
	}
	
}