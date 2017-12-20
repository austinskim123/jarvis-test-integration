Feature: Test the functionality of adding a client to the Jarvis site

Scenario: the user should be able to add a client from the directories page
Given user is logged in and on the directories page
When user clicks on Add Client and fills out the required fields
Then user gets confirmation that the client was added successfully