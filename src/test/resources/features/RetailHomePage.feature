Feature: Retail Home Page

Background: 
Given User is on retail website
When User click on All section
@smoke
Scenario: Verify Shop by Department sidebar


Then below options are present in Shop by Department sidebar
|Electronics|Computers|Smart Home|Sports|Automative|

@test
Scenario Outline: Verify Department sidebar options
   
    And User on '<department>'
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department  | optionOne                      | optionTwo                |
      | Electronics | TV & Video                     | Video Games              |
      | Computers   | Accessories                    | Networking               |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets        |
      | Sports      | Athletic Clothing              | Exercise & Fitness       |
      | Automative  | Automative Parts & Accessories | MotorCycle & Powersports |

#Scenario: Verify User can add an item to cart
#When User click on Sign in option
#And User enter email 'EmailValue' and password 'PasswordValue'
#And User click on login button
#And User should be logged in into Account
#And User change the category to 'Smart Home'
#And User search for an item ' kasa outdoor smart plug'
#And User click on Search icon 
#And User click on item
#And User select quantity ‘2’ 
#And User click add to Cart button 
#Then the cart icon quantity should change to ‘2’