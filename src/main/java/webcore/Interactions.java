package webcore;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class Interactions extends Cucumber_ExtentReportLogger {
	
	private WebDriver driver;
	
	protected Interactions(WebDriver driver){
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
	
	
	public byte[] takeScreenshot() {
		String screenshotPath = System.getProperty("user.dir")+"\\reports\\Screenshots\\"+"PageImage_"+System.currentTimeMillis()+".png";
		byte[] screenshotbyte = null;
		try {
			File scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrshot, new File(screenshotPath));
			screenshotbyte = Files.readAllBytes(Paths.get(screenshotPath));
		} catch (Exception exception) {
			System.out.print("Failed: Capture Display Page Screenshot");
			Assert.fail(exception.getMessage());
		}
		return screenshotbyte;
	}
	
	public byte[] takeFullScreenshot() {
		String name = "PageImage_"+System.currentTimeMillis();
		String screenshotPath = System.getProperty("user.dir")+"\\reports\\Screenshots\\";
		byte[] screenshotbyte = null;
		try {
			Shutterbug.shootPage(driver, Capture.FULL, true).withName(name).save(screenshotPath);
			screenshotbyte = Files.readAllBytes(Paths.get(screenshotPath+name+".png"));
		} catch (Exception exception) {
			System.out.print("Failed: Capture Full Page Screenshot");
			Assert.fail(exception.getMessage());
		}
		return screenshotbyte;
	}
	
}