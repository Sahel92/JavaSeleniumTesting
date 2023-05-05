@RegressionTest
Feature: User able to edit their debit/credit information.

  Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials
      | Email                      | Password   |
      | SpongeBobss46@tekschool.us | Test12345$ |
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option

  Scenario: Verify user can edit debit or credit card
    When User clicks on Edit option of card section
    And User edits card information
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      | cardNumber | fullName   |              12 |           2026 | ccv          |
    And User clicks on Update Your Card button
    Then Update successfull message should be displayed 'Payment Method updated Successfully'


  Scenario: Verify user can remove their debit/credit card
    When User click on remove option of card section
    Then payment details should be removed
