@RegressionTest
Feature: User can update password

  Background: 
    Given User is on retail website
    When User clicks on Sign in option

  Scenario Outline: Verify that user can update password
    When User enters following login credentials
      | Email                      | Password           |
      | Patrickss6546@tekschool.us | <previousPassword> |
    And User clicks on login button
    Then User should be logged into their account
    And User click on Account option
    And User enters '<previousPassword>' '<newPassword>' '<confirmPassword>'
    When User click on Change Password button
    Then A message should be displayed 'Password Updated Successfully'

    Examples: 
      | previousPassword | newPassword | confirmPassword |
      | Test12345$       | Pizza123$   | Pizza123$       |
      | Pizza123$        | Test12345$  | Test12345$      |
