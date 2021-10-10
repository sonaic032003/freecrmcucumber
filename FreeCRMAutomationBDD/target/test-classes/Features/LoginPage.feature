Feature: Login page feature

@LoginPage @TCLogin1
Scenario: Login page title
Given user is on the login page
When user gets the title of the page
Then page title should be "CRMPRO - CRM software for customer relationship management, sales, and support."


@LoginPage @TCLogin2
Scenario Outline: User is able to login to the Free-CRM page
Given user is on the login page
When user logs in with valid id <UserName> and <Password> Password
Then page title should be "CRMPRO"
Then User logs out of the Application
Examples:
|UserName| Password|
|sonaic032003|sonai87|

@LoginPage @TCLogin3
Scenario: Contact button is getting displayed
Given user is on the login page
Then Validate that the Contact button is getting displayed


@LoginPage @TCLogin4
Scenario: Sign up button is getting displayed
Given user is on the login page
Then Validate that the Sign Up button is getting displayed


@LoginPage @TCLogin5
Scenario Outline: User is able to click on the Contacts button in the home page
Given user is on the login page
When user logs in with valid id <UserName> and <Password> Password
And User clicks Contacts in the Home Page
Then User logs out of the Application
Examples:
|UserName| Password|
|sonaic032003|sonai87|