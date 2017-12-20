Feature: Test the login functionality of Jarvis site

Scenario: the user should be able to login with correct username and correct password
Given user is on the login page
When user enters correct username and correct password
Then user gets confirmation

#Examples:
#	| username | password |
#	| test@liferay.com | test |