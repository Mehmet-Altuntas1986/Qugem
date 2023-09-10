@wip
Feature:Testing Navigation Success with valid and invalid credentials

  Background:
    When Navigate to Login Page
  Scenario:1-User Logs In, Navigates to Dashboard, and Logs Out
    Then Enter a valid email
    Then Enter a valid password
    Then Click the login button after choosing english language
    And  Verify that user is now on the Dasboard Page after clicking login
    Then verify that dashboard page tab name contains QUGEM
    Then Click the sign out button

    #Then sign out to come back to login page --not necessary



  Scenario Outline:2- User cannot login with invalid passwords and valid email
    Then Enter a valid email
    Then Enter an invalid "<password>"
    Then Click the login button after choosing english language
    And  Verify that user is not on the Dasboard Page after clicking login
    And  verify user gets right alert warning -->false 'Bitte geben Sie eine korrekte E-Mail-Adresse ein.'


    Examples:
      | password |
      | 123txt_  |
      | 1234     |


  Scenario Outline:3- User cannot login with a short password
    Then Enter a valid email
    Then Enter an invalid "<shortpassword>"
    Then Click the login button after choosing english language
    Then verify that user gets an alert that pasword "Must be at least 6 characters long"

    Examples:
      | shortpassword |
      | 12345         |
      | abc        |






