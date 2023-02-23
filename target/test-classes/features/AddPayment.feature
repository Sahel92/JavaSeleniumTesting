@regression
Feature: User can add  payment  method

  Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials 
      | Email                    | Password    |
      | billybob123@tekschool.us | Pizza123$ |
    And User clicks on login button
    Then User should be logged into their account
    When User click on Account option

  
  Scenario Outline: Verify User can add a payment method
    When User click on Add a payment method link
    And User fills debit or credit card information "<cardNumber>" "<nameOnCard>" "<expirationMonth>" "<expirationYear>" "<securityCode>"
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

    Examples: 
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 8387956115160064 | Mario      |               4 |           2039 |          745 |

