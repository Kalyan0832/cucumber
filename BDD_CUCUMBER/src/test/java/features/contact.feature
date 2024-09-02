Feature: contact

Scenario: create contact with mandatory fields

Given Browser should be open and url is navigated
And Login page is displayed
When user enters username and password
And user clicks on login button
And homepage is displayed
And user click on contact link 
And contacts page is displayed
And user click on create contact link
And create contact page is displayed
And user enters contact name
And user click on save 
Then contact should be successfully saved
And close the browser