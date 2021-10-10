package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.factory.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps  {

	private static String title;
	//private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage();

	@Given("user is on the login page")
	public void user_is_on_login_page() {
		loginPage.openUrl();
		//DriverFactory.getDriver()
			//	.get("https://classic.crmpro.com/index.html");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page()  {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		System.out.println("Page title is: " +expectedTitleName);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("Validate that the Contact button is getting displayed")
	public void validate_that_the_contact_button_is_getting_displayed() {
		boolean flag = loginPage.isContactDisplayed();
Assert.assertTrue(flag);
	}
	
	@Then("Validate that the Sign Up button is getting displayed")
	public void Validate_that_the_Sign_Up_button_is_getting_displayed() {
		boolean flag = loginPage.isSignupDisplayed();
Assert.assertTrue(flag);
	}


	
	@When("User clicks Contacts in the Home Page")
	public void user_clicks_contacts_in_the_home_page() {
		
	    loginPage.ClickContact();
	}


@When("^user logs in with valid id (.*) and (.*) Password$")
public void user_logs_in_with_valid_id_and_password(String id, String Password) {
	try {
		loginPage.enterUserName(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		loginPage.enterPassword(Password);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		loginPage.clickOnLogin();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Then("User logs out of the Application")
public void user_logs_out_of_the_login_page() {
try {
	loginPage.clickOnLogout();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}
