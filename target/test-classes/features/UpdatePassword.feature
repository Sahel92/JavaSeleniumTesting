@updatePassword
Feature: User can update password

Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials:
    | Email                   	|      Password			|
    | SpongeBobs46@tekschool.us	|    Test12345$		|
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option
    
    
    Scenario Outline: Verify that user can update password
    And User enters "<previousPassword>" "<newPassword>" "<confirmPassword>"
    When User click on Change Password button
    Then A message should be displayed 'Password Updated Successfully'
    
    Examples:
    |previousPassword| newPassword|confirmPassword|
			|Test12345$ |Pizza123$ |Pizza123$ |