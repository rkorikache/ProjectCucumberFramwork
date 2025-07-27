
Feature: Login Validation for HRMs Portal
As a user attempting to log into the HRM portal,
I want clear and specific error messages during the login process,
So that I can understand if my login attempt failed due to missing fields or incorrect credentials.

 Background:
   #Given user is on the login page

   @login @validation
  Scenario: Display error when username field is empty
    When user leaves the username field empty
    And user enters a valid password
    And user clicks on the login button
    Then an error message "Username cannot be empty" should be displayed

 @login @validation
  Scenario: Display error when password field is empty
    When user enters a valid username
    And user leaves the password field empty
    And user clicks on the login button
    Then an error message "Password is Empty" should be displayed

  @login @validation
  Scenario: Display error when login credentials are invalid
    When user enters an invalid username or password
    And user clicks on the login button
    Then an error message "Invalid credentials" should be displayed

   @login @validation
  Scenario: Error message visibility
    When user attempts to login with invalid or empty credentials
    Then error messages should be visible near the respective input fields

   @login @validation
  Scenario: User can retry login after error
    When user attempts to login with invalid or empty credentials
    Then user should be able to correct input and try to log in again