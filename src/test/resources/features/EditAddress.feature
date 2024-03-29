@RegressionTest
Feature: User able to Add, Edit, and Remove Adress from account.

  Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials
      | Email                      | Password   |
      | SpongeBobss46@tekschool.us | Test12345$ |
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option

 
  Scenario: Verify User can add an Address
    When User click on Add address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt | city | state | zipCode |
      | United States | fullName | phoneNumber | address       | apt | city | state | zipCode |
    And User click Add Your Address button
    Then a message should be displayed address added "Address Added Successfully"

  
  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And User edits address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt | city | state | zipCode |
      | United States | fullName | phoneNumber | address       | apt | city | state | zipCode |
    And User click update Your Address button
    Then A confirmation message should be displayed 'Address Updated Successfully'

  
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
