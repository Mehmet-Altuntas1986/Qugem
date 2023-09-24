Feature:Employee Master Data - Employee information page tests

  Background:
    When user logins and clicks module employee_master_data

  Scenario: Verify Employee Information and employees Table Title Display
    Given verify user is on the employee information page
    Then verify employee information should be displayed
    And verify Employees table title is displayed

  Scenario: Verify Add new personal button is clickable and displayed
    Given verify that add personal button is displayed
    Then  verify that add personal button is enabled-functional
