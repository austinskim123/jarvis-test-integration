Feature: Test the functionality of adding and deleting a client from the Jarvis site

Scenario: the user should be able to add and delete a client from the directories page
Given user is logged in and on the directories page
When user clicks on Add Client
And user submits form with the required fields filled out
And user gets confirmation that the client was added successfully
And user deletes most recently added client
Then user gets confirmation that the client was deleted successfully