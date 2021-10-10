package stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.factory.TestBase;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	  public WebDriver driver;
		private ConfigReader configReader;
		Properties prop;

	//	@Before(order = 0)
		public void initiatettestbase() {
			//TestBase tb = new TestBase();
//tb.getProperty();
//tb.launchBrowser();
//tb.openURL();
		}
		
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		System.out.println("Hooks with order = 0");
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
	driver=	driverFactory.init_driver(browserName);
		TestBase tb = new TestBase();
		tb.inittbdriv(DriverFactory.getDriver());
	}


	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	/* @After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName); 

		}*/
	}	



