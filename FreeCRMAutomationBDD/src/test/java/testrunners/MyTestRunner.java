package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", glue = "stepdefinitions", monochrome = true,dryRun = false,
		tags = ("@ContactPage"),//("@ContactPage or @LoginPage")
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				
		}
		
		)

public class MyTestRunner {

}
