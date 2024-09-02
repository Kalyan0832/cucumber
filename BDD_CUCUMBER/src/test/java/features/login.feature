Feature: Login

Scenario:
		validate user is able to login using valid credentials
		
Given Browser should be open and url is navigated
And Login page is displayed
When user enters username and password
And user clicks on login button
Then User should be successfully logged in
And close the browser
