package cucumber.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/cucumberfeatures"},
		glue = {"cucumber/steps"},
		tags = "@AcePump_OrderProduct",
		plugin = {
				/* "html:reports/automation-cucumber-report.html", */
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

	/* To Execute the Tests in Parallel */
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}