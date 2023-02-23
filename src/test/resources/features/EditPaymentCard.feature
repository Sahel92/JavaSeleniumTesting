@regression
Feature: User able to edit their debit/credit information. 
  

 Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials 
      | Email                    | Password    |
      | billybob123@tekschool.us | Pizza123$ |
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option
   
   

  Scenario: Verify user can edit debit or credit card
  
   And User click on bank card
   When User clicks on Edit option of card section
  
  And User edits card information
  |cardNumber					 |nameOnCard	|expirationMonth|   expirationYear		 |securityCode|
  |		9876889098098908 |	Tryndamere|		3						|   	2026				 |			321		  |
  And User clicks on Update Your Card button
  Then Update successfull message should be displayed 'Payment Method updated Successfully'
  
  @test
  Scenario: Verify user can remove their debit/credit card
   And User click on bank card
  And User click on remove option of card section
  Then payment details should be removed
  

  
  