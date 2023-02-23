
@updatePassword
Feature: User can update password

Background: 
    Given User is on retail website
    When User clicks on Sign in option
    
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option
    
    
    Scenario Outline: Verify that user can update password
    And User enters following login credentials:
    | Email                   	|      Password			|
    | billybob123@tekschool.us	|    	Pizza123$	|
    And User enters "<previousPassword>" "<newPassword>" "<confirmPassword>"
    When User click on Change Password button
    Then A message should be displayed 'Password Updated Successfully'
    
    Examples:
    |previousPassword| newPassword|confirmPassword|
			|Pizza123$ |Burgers123$ |Burgers123$ |