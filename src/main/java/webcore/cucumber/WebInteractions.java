package webcore.cucumber;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebInteractions extends ExtentReportLogger {
	
	private WebDriver driver;
	
	protected WebInteractions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected WebDriver getDriver() {
		return driver;
	}

	protected void click(WebElement element) {
		try {
			element.click();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void clickUsingJavaScriptExecutor(WebElement element) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].click();", element);
	}
	
	protected void scrollToViewElementUsingJavaScriptExecutor(WebElement element) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	protected void enterText(WebElement element, String textValue) {
		try {
			element.sendKeys(textValue);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void selectDropdownByValue(WebElement element, String textValue) {
		try {
			Select selectobj = new Select(element);
			selectobj.selectByValue(textValue);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected String getPageTitle() {
		String title = ""; 
		try {
			title = driver.getTitle();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return title;
	}
	
	/* 
	 * Below Method Deprecated
	 * 
	protected void addImplicitWait(int waitTime) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 */
	
	protected void addImplicitWait(int waitTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}
	
	protected void waitForWebElement(By element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	protected void coolingTime(int hardWaitTime){
		try {
			Thread.sleep(hardWaitTime);
		} catch (InterruptedException exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
}