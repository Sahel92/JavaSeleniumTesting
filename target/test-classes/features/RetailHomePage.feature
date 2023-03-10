@SmokeTest
Feature: Retail Home Page

  Background: 
    Given User is on retail website
    When User clicks on Sign in option
    And User enters following login credentials
      | Email                      | Password   |
      | SpongeBobss46@tekschool.us | Test12345$ |
    And User clicks on login button
    Then User should be logged into their account

  Scenario: Verify Shop by Department sidebar
    When User click on All section
    Then below options are present in Shop by Department sidebar
      | Electronics | Computers | Smart Home | Sports | Automative |

  Scenario Outline: Verify Department sidebar options
    When User click on All section
    And User on "<department>"
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department  | optionOne                      | optionTwo                |
      | Electronics | TV & Video                     | Video Games              |
      | Computers   | Accessories                    | Networking               |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets        |
      | Sports      | Athletic Clothing              | Exercise & Fitness       |
      | Automative  | Automative Parts & Accessories | MotorCycle & Powersports |

  Scenario: Verify User can add an item to cart
    And User change the category to 'Smart Home'
    And User search for an item 'Kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to "2"

  Scenario: Verify User can place an order without Shipping address and payment Method on file
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click Add a new address link for shipping address
    And user fill new address form during checkout
      | country | fullName | phoneNumber | streetAddress | apt | city        | state      | zipCode |
      | Panama  | fullName |  1234567890 | 123 fake st   |   1 | Panama City | Los Santos | zipCode |
    And User click Add Your Address button
    And User click Add a credit card or Debit Card for Payment method
    And User fills debit or credit card information during checkout
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      | cardNumber | fullName   |               7 |           2025 | ccv          |
    And User click on Add your card button
    And User click on Place Your Order
    Then Order placed message should be displayed "Order Placed, Thanks"

  Scenario: Verify User can place an order with Shipping address and payment Method on file
    And User change the category to 'Electronics'
    And User search for an item 'Apex Legends'
    And User click on Search icon
    And User click on item
    And User select quantity '5'
    And User click add to Cart button
    Then the cart icon quantity should change to '5'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then Order placed message should be displayed "Order Placed, Thanks"
