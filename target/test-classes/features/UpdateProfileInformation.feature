@updateProfileInfo
Feature: User wants to update profile

Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials:
    | Email                   	|      Password			|
    | billybob123@tekschool.us	|    Burgers123$		|
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option
    
    
    
		Scenario Outline: Verify use can update profile information
		
		And User update Name "<name>" and Phone "<phoneNum>"
		And user click on update button
		Then user profile information should be updated
		
		Examples:
		| name 				| phoneNum|
		| Ricky | 2536380495|
		| Julian | 2536369333|
		| Bubbles | 5336749763|