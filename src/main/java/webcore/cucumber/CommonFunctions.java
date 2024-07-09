package webcore.cucumber;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.imageio.ImageIO;
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

public class CommonFunctions extends WebInteractions {

	protected CommonFunctions(WebDriver driver) {
		super(driver);
	}
	
	public static String getCurrentISTDate(String DateFormat) {
		SimpleDateFormat ISTDF = new SimpleDateFormat(DateFormat);
		TimeZone ISTTZ = TimeZone.getTimeZone("GMT+5:30");
		ISTDF.setTimeZone(ISTTZ);
		
		Date currentDate = new Date();
		return ISTDF.format(currentDate.getTime()).toString();
	}
	
	public static String getCurrentESTDate(String DateFormat) {
		SimpleDateFormat ETDF = new SimpleDateFormat(DateFormat);
		TimeZone ETTZ = TimeZone.getTimeZone("America/New_York");
		ETDF.setTimeZone(ETTZ);
		
		Date currentDate = new Date();	
		return ETDF.format(currentDate.getTime()).toString();
	}
	

	public byte[] takeScreenshot() {
		String screenshotPath = System.getProperty("user.dir")+"\\reports\\Screenshots\\"+"PageImage_"+System.currentTimeMillis()+".png";
		byte[] screenshotbyte = null;
		try {
			File scrshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
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
			Shutterbug.shootPage(getDriver(), Capture.FULL, true).withName(name).save(screenshotPath);
			screenshotbyte = Files.readAllBytes(Paths.get(screenshotPath+name+".png"));
		} catch (Exception exception) {
			System.out.print("Failed: Capture Full Page Screenshot");
			Assert.fail(exception.getMessage());
		}
		return screenshotbyte;
	}
	
	/* Taking Screenshots using Java is not preferred */
	private String takeScreenshotUsingJava() {
		String screenshotPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Screenshots";
		try {
			Robot robot = new Robot();
			Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage image = robot.createScreenCapture(rectangle);
			File folderCreation = new File(screenshotPath);
			folderCreation.mkdir();
			screenshotPath = screenshotPath + File.separator + "JavaImage_" + System.currentTimeMillis() + ".png";
			ImageIO.write(image, "png", new File(screenshotPath));
		} catch(Exception e) {
			e.getMessage();
		}
		return screenshotPath;
	}
	
	public void capturePageScreenshotUsingJava(String reportInformation) {
		String imagePath =  takeScreenshotUsingJava();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, reportInformation, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
	}
	
}