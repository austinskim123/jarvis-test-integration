Feature: Test the functionality of adding and deleting a client from the Jarvis site

Scenario: the user should be able to add and delete a client from the directories page
Given user is logged in and on the directories page
When user clicks on Add Client
And user submits form with the required fields filled out
And user gets confirmation that the client was added successfully
And user deletes most recently added client
Then user gets confirmation that the client was deleted successfully

Scenario: the user should be able to edit a client from the client page
Given user is logged in and client has been added
When user navigates to the client page
And user clicks on Edit Client
And user edits information for the client
Then user gets confirmation that the client was edited successfully