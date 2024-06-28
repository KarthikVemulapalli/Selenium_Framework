package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ProductPage extends HomePage {
	
	By css_textboxOrderQuantity = By.cssSelector("input#qty");
	By xpath_buttonAddToCart = By.xpath("//button[@title='Add to Cart']");

	public void clickProduct(String productName) {
		click(By.xpath("//a[contains(text(),'"+productName+"')]"));
	}
	
	public void enterOrderQuantity(String orderQty) {
		enterText(css_textboxOrderQuantity, orderQty);
		capturePageScreenshot("Order Quantity", true);
	}
	
	public void clickAddToCart() {
		
		WebElement element = driver.findElement(xpath_buttonAddToCart);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//click(xpath_buttonAddToCart);
	
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
}