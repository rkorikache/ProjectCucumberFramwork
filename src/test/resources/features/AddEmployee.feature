Feature: Add Employee
  As an admin user,
  I want to add an employee to the HRMS application,
  So that the system can generate or accept a unique employee ID and store the employee's

  Background:
     #Given user is navigated to HRMS application
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    When user clicks on add employee option

  @addEmployee @withoutID
  Scenario: Add an employee without providing employee ID
    And user enters "lana" and "ms" and "smith"
    And user clicks on save button
    Then employee is added successfully

  @addEmployee @withID
  Scenario: Add an employee with a unique employee ID
    And user enters "lana" and "ms" and "smith" and "1"
    And user clicks on save button
    Then employee is added successfully

  @addEmployee @errorValidation
  Scenario: Display error messages when required fields are missing
    When user leaves the firstname and lastname fields empty
    And user clicks on save button
    Then an error message "Required" should be displayed in add employee form
    And  error messages should be visible near the respective input
