package cucumber.steps;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import frameworkSetup.ReportSetup;
import frameworkSetup.SeleniumSetup;
import io.cucumber.java.*;

public class Hooks {

	private static ReportSetup reportSetup;
	private static SeleniumSetup seleniumSetUp;
	
	@BeforeAll
	public static void initialReportConfiguration() {
		reportSetup = new ReportSetup();
		reportSetup.initialReportStep();
	}
	
	@Before
	public void initialSeleniumConfiguration() {
		seleniumSetUp = new SeleniumSetup();
		seleniumSetUp.initializeBrowser();
	}
	
	@After
	public void finalSeleniumTearDown(Scenario scenario) {
		seleniumSetUp.quitBrowser();
	}
	
	@AfterStep
	public void takeApplicationScreenshot(Scenario scenario) {
		scenario.attach(takeFullScreenshot(), "image/png", "Page Screenshot");
	}
	
	
	public static WebDriver getDriver() {
		return seleniumSetUp.getDriver();
	}
	
	public static String getConfigProperty(String key) {
		return seleniumSetUp.getConfigProperty().getProperty(key);
	}
	
	public byte[] takeFullScreenshot() {
		String name = "PageImage_"+System.currentTimeMillis();
		String screenshotPath = System.getProperty("user.dir")+"\\reports\\Screenshots\\";
		byte[] screenshotbyte = null;
		try {
			Shutterbug.shootPage(getDriver(), Capture.FULL, true).withName(name).save(screenshotPath);
			screenshotbyte = Files.readAllBytes(Paths.get(screenshotPath+name+".png"));
		} catch (Exception exception) {
			System.out.print("Failed: Capture Full Page Screenshot");
			Assert.fail(exception.getMessage());
		}
		return screenshotbyte;
	}
	
}