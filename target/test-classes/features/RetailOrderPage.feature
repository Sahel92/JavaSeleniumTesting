
Feature: Retail Order Page

  Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials
      | Email                      | Password   |
      | SpongeBobss46@tekschool.us | Test12345$ |
    And User clicks on login button
    Then User should be logged into their account
    And User click on Orders section

@orderCancel
  Scenario: Verify User can cancel the order
    And User click on first order in list
    And User click on Cancel The Order button
    And User select the cancelation Reason "Bought wrong item"
    And User click on Cancel Order button
    Then A message should be displayed for canceled order "Your Order Has Been Cancelled"

@orderReturn
  Scenario: Verify User can Return the order
    And User click on Return Items button
    And User select the Return Reason "Item damaged"
    And User select the drop off service "FedEx"
    And User click on Return Order button
    Then Message for return order should be displayed "Return was successfull"

 @orderReview
  Scenario: Verify User can write a review on order placed
    And User click on Review button
    And User write Review headline "Great Game!" and review text "Apex coins are needed to purchase some cool skins"
    And User click Add your Review button
    Then review message should be displayed "Your review was added successfully"
