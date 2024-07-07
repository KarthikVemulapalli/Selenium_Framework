package cucumber.steps;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import frameworkSetup.Cucumber_ReportSetup;
import frameworkSetup.SeleniumSetup;
import io.cucumber.java.*;
import pages.HomePage;

public class Hooks {

	private static Properties property;
	private static WebDriver driver;
	private static SeleniumSetup seleniumSetUp;
	private static Cucumber_ReportSetup reportSetup;
	private HomePage homepage;
	
	
	@BeforeAll
	public static void initialReportSetUp() {
		reportSetup = new Cucumber_ReportSetup();
		reportSetup.initialReportStep();
	}
	
	@Before
	public void initialSeleniumSetUp() {
		seleniumSetUp = new SeleniumSetup();
		property = seleniumSetUp.initializePropertyFile();
		driver = seleniumSetUp.initializeBrowser(property);
		homepage = new HomePage(getDriver());
	}
	
	@After
	public void finalSeleniumTearDown(Scenario scenario) {
		seleniumSetUp.quitBrowser();
	}
	
	@AfterStep
	public void takeApplicationScreenshot(Scenario scenario) {
		scenario.attach(homepage.takeFullScreenshot(), "image/png", "Page Screenshot");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static String getConfigProperty(String key) {
		return property.getProperty(key);
	}
	
	public static void launchURL(String URL) {
		driver.navigate().to(URL);
	}
	
}