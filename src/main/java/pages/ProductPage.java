package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends HomePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = "input#qty")
	private WebElement css_textboxOrderQuantity;
	
	@FindBy (xpath = "//button[@title='Add to Cart']")
	private WebElement xpath_buttonAddToCart;

	public void clickProduct(String productName) {
		WebElement element = getDriver().findElement(By.xpath("//a[contains(text(),'"+productName+"')]"));
		click(element);
	}
	
	public void enterOrderQuantity(String orderQty) {
		enterText(css_textboxOrderQuantity, orderQty);
		capturePageScreenshot("Order Quantity", true);
	}
	
	public void clickAddToCart() {
		scrollToViewElementUsingJavaScriptExecutor(xpath_buttonAddToCart);
		clickUsingJavaScriptExecutor(xpath_buttonAddToCart);
	}
	
}