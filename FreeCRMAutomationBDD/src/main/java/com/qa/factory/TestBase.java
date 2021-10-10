package com.qa.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ConfigReader;



//import io.cucumber.java.Before;

public class TestBase {
	public DriverFactory driverFactory;
	public static WebDriver driver;
	public ConfigReader configReader;
	Properties prop;
	public static WebDriverWait wait;
	public static Actions act ;
		

	
	
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}



	public void inittbdriv(WebDriver driver2) {
		// TODO Auto-generated method stub
		driver = driver2;
		wait = new WebDriverWait(driver,30);
			act = new Actions(driver);
	}

}
