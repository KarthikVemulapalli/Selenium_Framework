package frameworkSetup;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumSetup {
	
	private WebDriver driver;
	private Properties property;
	private FileInputStream configFileInputStream;
	
	public SeleniumSetup(){
		try {
			configFileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
			property = new Properties();
			property.load(configFileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initializeBrowser() {
		String browserName = property.getProperty("browser").trim();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} 
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public Properties getConfigProperty() {
		return property;
	}
	
}