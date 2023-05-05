@RegressionTest
Feature: Sign In Feature Allows User to login into their account.

  Background: 
    Given User is on retail website
    When User clicks on Sign in option

  Scenario Outline: Verify user can sign into Retail Application
    When User enters "<email>" and "<password>"
    And User clicks on login button
    Then User should be logged into their account

    Examples: 
      | email                    | password  |
      | billybob123@tekschool.us | Pizza123$ |
