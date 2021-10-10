package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;
import com.qa.factory.TestBase;
import com.qa.util.CommonFunctions;
import com.qa.util.ConfigReader;

public class LoginPage extends TestBase{
	
	@FindBy (xpath = "//i[(contains(@class,'-sign-out'))]")
	private WebElement Logoutbtn;
	
	@FindBy (name = "username")
	private WebElement Username;
	
	@FindBy (name = "password")
	private WebElement password;
	
	@FindBy (xpath = "//input[@type='submit']")
	private WebElement Loginbtn;
	
	@FindBy (xpath = "//a[text() = 'Sign Up']")
	private WebElement Signupbtn;
	
	@FindBy (xpath = "//a[text() = 'Contact']")
	private WebElement Contactbtn;
	
	@FindBy(xpath ="//a[@title = 'Contacts']")
	private WebElement Contactbtnhome;
	//private WebDriver driver;
	
	CommonFunctions cf = new CommonFunctions();

	// 1. By Locators: OR

	
	

	// 2. Constructor of the page class:
//	public LoginPage(WebDriver driver) {
//		this.driver = driver;
//	}
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
}

	// 3. page actions: features(behavior) of the page the form of methods:
	
	public void openUrl()
	{
	
		driver.get("https://classic.crmpro.com/index.html");
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isContactDisplayed() {
		return cf.visibilityelement(Contactbtn);
	}
	
	public boolean isSignupDisplayed() {
		return cf.visibilityelement(Signupbtn);
	}

	public void enterUserName(String username) {
		cf.waitandsendkey(Username, username);
	}

	public void enterPassword(String pwd) {
		cf.waitandsendkey(password, pwd);
	}
	
	public void ClickContact()
	{//cf.switchtolatestframe();
		Contactbtnhome.click();
	}


	public void clickOnLogin() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cf.waitandclick(Loginbtn);
		cf.switchtolatestframe();
	}
	
	public void clickOnLogout() {
	
		cf.waitandclick(Logoutbtn);
	
	}



	

}
