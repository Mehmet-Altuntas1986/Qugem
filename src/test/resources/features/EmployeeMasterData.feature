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

  Scenario Outline: Verifying Table Filter elements functionality
    When user uses "<No_filter>", personal No comes to first row and first column of table
    When user uses "<first_name_filter>", personal name comes to first row and second column of table
    When user uses "<last_name_filter>" , personal lastname comes to first row and third column of table

    Examples:
      | No_filter | first_name_filter | last_name_filter |
      | 933       | Irfan             | Erdogdu          |


  Scenario Outline: Verify the functionality of "Lines Per Page" selection

    When the user clicks the Lines Per Page select arrow
    And  chooses a <number_of_personal>, click and verify list doesn't have more than this number of personal

    Examples:
      | number_of_personal |
      | 10                 |
      | 25                 |
      | 50                 |

  Scenario: Verify that when we click next page arrow ,  employee table title is still displayed
    When user clicks the next page arrow in employee list
    And user is still in the employee list page that has Employees tableTitle
    And verify that url didn't change