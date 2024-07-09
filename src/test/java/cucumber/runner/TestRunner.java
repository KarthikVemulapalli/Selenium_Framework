package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/cucumberfeatures"},
		glue = {"cucumber/steps"},
		tags = "@ShopByBrand",
		plugin = {
				/* "html:reports/automation-cucumber-report.html", */
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}