
Feature: Adding Vehicles
  Background:
    When Navigate to DashboardPage with English language
    When click to Vehicles module

  #this test becomes successful in case there is no same auto added with same plate
  Scenario Outline:4- Adding a vehicle and verifying that its properties are also visible in Vehicle Details page
    Then click plus + add button
    Then choose the Type of the Vehicle
    Then fill in the boxes of "<Plate>" , "<Brand>" , "<Model>","<Year_of_construction>" "<Year_of_the_purchase>" , "<current_kilometer>" and "<purchase_price>"
    And click the Save Changes button
   #after save changes ,alert is not in english language
    Then verify that you are in the Vehicle details page
    Then verify that added vehicle properties are found in Vehicle details page
    When click to Vehicles module
    Then verify that you are in the page of Vehicle List
    Then verify that you see added vehicle properties in vehicle list page
    Then click the detail button and verify vehicle details are all there

    Examples:
      | Plate      | Brand    | Model | Year_of_construction | Year_of_the_purchase | current_kilometer | purchase_price |
      | KO PJ 3396 | Mercedes | A5    | 2010                 | 2015                 | 100000            | 20000          |

  Scenario:5- Editing Vehicle properties and verifying these changes are successfully visible

    And  click the detail in the first row of vehicle list
    Then verify that you are in the Vehicle details page
    And  click the edit button in vehicle details page
    Then verify that current url contains edit
    Then clear plate and Brand input boxes and put new values CO DJ 140 and Audi
    Then click the Save Changes button
    Then verify you are again in the Vehicle details page
    Then verify that new edited changes of plate CO DJ 140 and Audi name is in the Vehicle Details page
    Then click to Vehicles module
    Then verify that you are in the page of Vehicle List
    Then verify that edited changes are visible in the Vehicle List page


  Scenario Outline: 6- User cannot add again a vehicle with the same plate
    Then click plus + add button
    Then choose the Type of the Vehicle
    Then fill in the boxes of "<Plate>" , "<Brand>" , "<Model>","<Year_of_construction>" "<Year_of_the_purchase>" , "<current_kilometer>" and "<purchase_price>"
    And click the Save Changes button
    Then verify that an alert warns you if you try to add a vehicle with the same plate duplicate key error collection

    Examples:
      | Plate     | Brand | Model | Year_of_construction | Year_of_the_purchase | current_kilometer | purchase_price |
      | CO DJ 140 | Audi  | C5    | 2015                 | 2018                 | 120000            | 30000          |


  Scenario:7- User can delete an added auto
    Then verify that plate CO DJ 140 is displayed in the Vehicle list
    And  click the detail in the first row of vehicle list
    Then click the delete button
    Then click confirm yes button in the alert
    Then verify that you are in the page of Vehicle List
    Then verify that plate CO DJ 140 plate Auto is not displayed in the vehicle list anymore

  Scenario Outline:8-Add vehicle and assign drivers to this vehicle , then verify , they are seen in the vehicle List

    Then click plus + add button
    Then choose the Type of the Vehicle
    Then fill in the boxes of "<Plate>" , "<Brand>" , "<Model>","<Year_of_construction>" "<Year_of_the_purchase>" , "<current_kilometer>" and "<purchase_price>"
    And  click the Save Changes button
    Then verify you are again in the Vehicle details page
    Then click to Vehicles module
    Then click Usage button in the related car plate row found
    Then verify car plate is there after click usage
    Then click add driver button
    Then fill the "<driver1>" ,"<driver2>" and startDate and "<startKm>" then click enter to save changes
    Then verify saved Drivers are seen in the Vehicle List
    Then verify this vehicle is now in use
    Then click Usage button in the related car plate row found
    Then verify Driver names ,Start date , in use text and start km are found there
    Then click the edit button in the section of usage
    Then add input EndDate and "<EndKm>" and click save changes
    And verify that you are in the page of Vehicle List
    Then verify Vehicle status is now Idle in Vehicle List
    Then click Usage button in the related car plate row found
    Then verify distance is 2000 km
    Then click to Vehicles module
    Then click Detail button of plate in Vehicle list
    Then verify that you are in the Vehicle details page
    Then click the delete button
    Then click confirm yes button in the alert
    Then verify that you are in the page of Vehicle List
    Then verify that plate AS 20 150 plate Auto is not displayed in the vehicle list anymore

    Examples:
      | Plate     | Brand    | Model | Year_of_construction | Year_of_the_purchase | current_kilometer | purchase_price | driver1     | driver2     | startKm | EndKm |
      | AS 20 150 | Mercedes | A3    | 2010                 | 2015                 | 80000             | 20000          | Rumen Rumen | Frank Frank | 12000   | 14000 |



