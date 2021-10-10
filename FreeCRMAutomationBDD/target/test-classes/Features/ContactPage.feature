Feature: Contact page feature

@ContactPage @TCContactPage01

Scenario Outline: User is able to create a new contact from the Contacts Page
Given user is on the login page
When user logs in with valid id <UserName> and <Password> Password
And User clicks Contacts in the Home Page
Then User clicks on the New Contacts button
Then User adds on First <FirstName> and <LastName> Name and set the input in the status <Status> dropdown
Then User saves the data
Then User validates the First <FirstName> and Last <LastName> Name in the Contact List
Then User deletes the contact with the given first <FirstName> and last  <LastName> Name
Then User logs out of the Application
Examples:
|UserName| Password  |  FirstName |LastName|Status |
|sonaic032003|sonai87|Robert  |Barry 		   |Active|