@singIn
Feature: Sign In Feature
  User wants to sign into account

  Background: 
    Given User is on retail website
    When User clicks on Sign in option

  
  Scenario Outline: Verify user can sign into Retail Application
    And User enters "<email>" and "<password>"
    And User clicks on login button
    Then User should be logged into their account

    Examples: 
      | email                         | password   |  
      | billybob123@tekschool.us      | Burgers123$  |  
      | peterGriffin6546@tekschool.us | Test12345$ |  
