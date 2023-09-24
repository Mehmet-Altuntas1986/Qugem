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

  Scenario: Verify Employees Table titles are displayed
    Given Verify employees table column titles are all displayed

  Scenario: Verifying Table Filter elements functionality
    When user uses "<No_filter>", personal No comes to first row and first column of table
    When user uses "<first_name_filter>", personal name comes to first row and second column of table
    When user uses "<last_name_filter>" , personal lastname comes to first row and third column of table

    Examples:
      | No_filter | first_name_filter | last_name_filter |
      | 933       | Irfan             | Erdogdu          |


Scenario: Verify line per page max personal number works expected
  When user clicks lines per page select arrow
  Then choose and clicks 10 personal for the employee page table list
  Then verify that employee table body doesnt have more than 10 row lists personals


