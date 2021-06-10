#Author: Jayashree Eswaran
#Scenario Outline: Signup for a account
@signup @newuser
Feature: User registration
  I want to signup as new user

  Scenario: Successful registration of a new user
    Given i open signup page
    When i am on "https://miro.com/signup/"
    Then i signup with following details
      | Test61 | Test61@gmail.com | Sc@nari01 |
    Then i check the Terms and Agreement
    Then i click the Get started now button on the page
    And i should see the confirmation page
