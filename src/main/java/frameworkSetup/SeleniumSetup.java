package frameworkSetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumSetup {
	
	static WebDriver driver;
	Properties property;

	public WebDriver initializeBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		
		switch (browserName) {
			case "chrome":
				/* WebDriverManager.chromedriver().setup(); */
				driver = new ChromeDriver();
				break;
			case "edge":
				/* WebDriverManager.edgedriver().setup(); */
				driver = new EdgeDriver();
				break;
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public Properties initializePropertyFile() {
		try {
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}
	
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}