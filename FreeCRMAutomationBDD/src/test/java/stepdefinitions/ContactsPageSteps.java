package stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import com.pages.ContactsPage;

import io.cucumber.java.en.Then;

public class ContactsPageSteps {
	
	ContactsPage CP = new ContactsPage();
	
	@Then("User clicks on the New Contacts button")
	public void user_clicks_on_the_new_contacts_button() {
		boolean flag = true;
	   try {
	flag =	CP.createNewContact();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Assert.assertTrue(flag);  
	   
	}
	@Then("^User adds on First (.*) and (.*) Name and set the input in the status (.*) dropdown$")
	public void user_adds_on_first__and__name(String firstName, String lastName,String Status) {
	 CP.addrecord(firstName, lastName, Status);
	}
	
	@Then("User saves the data")
	public void user_saves_the_data() {
	    // Write code here that turns the phrase above into concrete actions
	  try {
		CP.saveRecord();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Then("^User validates the First (.*) and Last (.*) Name in the Contact List$")
	public void user_validates_the_first_and_last_name_in_the_contact_list(String firstName, String lastName) {
	 boolean flag = CP.validateRecordbyName(firstName, lastName);
	 Assert.assertTrue(flag);
	   
	}
	@Then("^User deletes the contact with the given first (.*) and last  (.*) Name$")
	public void user_deletes_the_contact_with_the_given_first_and_last_name(String firstName, String lastName) {
	boolean flag =   CP.deleteRecord(firstName, lastName);
	   Assert.assertFalse(flag);
	}


}
