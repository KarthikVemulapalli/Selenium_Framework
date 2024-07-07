package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends HomePage {
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = "button[data-role='proceed-to-checkout']")
	private WebElement css_buttonProceedToCheckout;
	
	By xpath_labelOrderTotal = By.xpath("//strong[contains(text(), 'Order Total')]");
	
	public void clickProceedToCheckOut() {
		waitForWebElement(xpath_labelOrderTotal, 30);
		capturePageScreenshot("Shopping Cart Page", true);
		click(css_buttonProceedToCheckout);
	}
	
}