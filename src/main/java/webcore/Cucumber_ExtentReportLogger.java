package webcore;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class Cucumber_ExtentReportLogger {
	
	public void softValidate(String expectedResult, String actualResult, String reportInformation) {
		if(expectedResult.equals(actualResult)) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, reportInformation+": Expected '"+expectedResult+"' matches Actual '"+actualResult+"'");
		} else {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, reportInformation+": Expected '"+expectedResult+"' not matches Actual '"+actualResult+"'");
		}
	}
	
	public void logReportInfo(String reportInformation) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, reportInformation);
	}
	
}