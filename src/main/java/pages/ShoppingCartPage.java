package pages;

import org.openqa.selenium.By;

public class ShoppingCartPage extends HomePage {

	By css_buttonProceedToCheckout = By.cssSelector("button[data-role='proceed-to-checkout']");
	By xpath_labelOrderTotal = By.xpath("//strong[contains(text(), 'Order Total')]");
	
	public void clickProceedToCheckOut() {
		waitForWebElement(xpath_labelOrderTotal, 30);
		capturePageScreenshot("Shopping Cart Page", true);
		click(css_buttonProceedToCheckout);
	}
	
}