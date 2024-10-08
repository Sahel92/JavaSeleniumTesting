@RegressionTest
Feature: To test account creation functionality.

  Background: 
    Given User is on retail website
    When User clicks on Sign in option

  Scenario: Verify user can create an account into Retail Website
    When User clicks on Create New Accout button
    And User fills the signUp form with below data
      | name     | email | password   | confirmPassword |
      | fullName | email | Test12345$ | Test12345$      |
    And User click on SignUp button
    Then User should be logged into account page
