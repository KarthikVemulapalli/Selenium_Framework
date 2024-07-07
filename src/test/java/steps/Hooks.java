package steps;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import frameworkSetup.SeleniumSetUp;
import io.cucumber.java.*;

public class Hooks {

	private static Properties property;
	private static WebDriver driver;
	private static SeleniumSetUp seleniumSetUp;
	
	@Before
	public void initialSeleniumSetUp() {
		seleniumSetUp = new SeleniumSetUp();
		property = seleniumSetUp.initializePropertyFile();
		driver = seleniumSetUp.initializeBrowser(property);
	}
	
	@After
	public void finalSeleniumTearDown(Scenario scenario) {
		seleniumSetUp.quitBrowser();
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