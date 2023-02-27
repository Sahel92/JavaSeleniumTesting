@regression
Feature: User can edit address.

  Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials
      | Email                    | Password  |
      | billybob123@tekschool.us | Pizza123$ |
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option

  Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
      | country | fullName  | phoneNumber | streetAddress | apt | city        | state      | zipCode |
      | Panama  | Gob Bluth |  1234567890 | 123 fake st   |   1 | Panama City | Los Santos |   23427 |
    And User click Add Your Address button
    Then a message should be displayed address added "Address Added Successfully"

  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And User edits address form with below information
      | country       | fullName    | phoneNumber | streetAddress | apt | city     | state      | zipCode |
      | United States | Will Shakes |  6546544653 | maple valley  |   1 | Catalina | California |   65412 |
    And User click update Your Address button
    Then A confirmation message should be displayed 'Address Updated Successfully'

  
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
