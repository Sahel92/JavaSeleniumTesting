@RegressionTest
Feature: Testing funtionality to allow user to update personal information. 

  Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials
      | Email                    | Password  |
      | billybob123@tekschool.us | Pizza123$ |
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option

  Scenario Outline: Verify use can update profile information
    When User update Name and Phone 
    | name     | phoneNumber |
    | fullName | phoneNumber |
    And user click on update button
    Then user profile information should be updated