package webcore;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import frameworkSetup.ReportValidationsSetup;

public class Interactions extends ReportValidationsSetup {

	protected void click(By elementLocator) {
		try {
			waitForWebElement(elementLocator, 30);
			driver.findElement(elementLocator).click();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void enterText(By elementLocator, String textValue) {
		try {
			waitForWebElement(elementLocator, 30);
			driver.findElement(elementLocator).sendKeys(textValue);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void selectDropdownByValue(By elementLocator, String textValue) {
		try {
			waitForWebElement(elementLocator, 30);
			WebElement dropdownElement = driver.findElement(elementLocator);
			Select selectobj = new Select(dropdownElement);
			selectobj.selectByValue(textValue);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void waitForWebElement(By elementLocator, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
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
	
}