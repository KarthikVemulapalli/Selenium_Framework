package frameworkSetup;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class ReportValidationsSetup {
	
	protected WebDriver driver = SeleniumSetUp.getDriver();
	
	public void softValidateWithPageScreenshot(String expectedResult, String actualResult, String reportInformation) {
		if(expectedResult.equals(actualResult)) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, reportInformation+": Expected '"+expectedResult+"' matches Actual '"+actualResult+"'", MediaEntityBuilder.createScreenCaptureFromPath(takeFullScreenshot()).build());
		} else {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, reportInformation+": Expected '"+expectedResult+"' not matches Actual '"+actualResult+"'", MediaEntityBuilder.createScreenCaptureFromPath(takeFullScreenshot()).build());
		}
	}
	
	public void softValidate(String expectedResult, String actualResult, String reportInformation) {
		if(expectedResult.equals(actualResult)) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, reportInformation+": Expected '"+expectedResult+"' matches Actual '"+actualResult+"'");
		} else {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, reportInformation+": Expected '"+expectedResult+"' not matches Actual '"+actualResult+"'");
		}
	}
	
	public void capturePageScreenshot(String reportInformation, boolean fullPageScreenshot) {
		String imagePath = "";
		if(fullPageScreenshot) {
			imagePath =  takeFullScreenshot();
		} else {
			imagePath = takeScreenshot();
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, reportInformation, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
	}
	
	private String takeScreenshot() {
		String screenshotPath = System.getProperty("user.dir")+"\\reports\\screenshots\\"+"ScreenShot_"+System.currentTimeMillis()+".png";
		try {
			File scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrshot, new File(screenshotPath));
		} catch (Exception e) {
			System.out.print("Failed: Capture Screenshot");
		}
		return screenshotPath;
	}
	
	private String takeFullScreenshot() {
		String name = "ScreenShot_"+System.currentTimeMillis();
		String screenshotPath = System.getProperty("user.dir")+"\\reports\\screenshots\\";
		try {
			Shutterbug.shootPage(driver, Capture.FULL, true).withName(name).save(screenshotPath);
		} catch (Exception exception) {
			Assert.fail(exception.getMessage());
		}
		return screenshotPath+name+".png";
	}
	
}