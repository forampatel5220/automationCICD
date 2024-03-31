
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background:
  Given I landed to Ecommerce Page


  @Regression
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product "<productName>"  to cart
    And Checkout "<productName>" and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                    | password   | productName  |
      | forampatel133@gmail.com | Foram.5220 | ZARA COAT 3  |
    
