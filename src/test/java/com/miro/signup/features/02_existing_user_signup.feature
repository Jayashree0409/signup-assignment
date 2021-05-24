#Author: Jayashree Eswaran
#Scenario Outline: Signup for a account
@signup @existinguser
Feature: User registration
  I want to signup with already registered user

  Scenario: Unable to register a user if the mail is already registered
    Given i open signup page
    When i am on "https://miro.com/signup/"
    Then i signup with following details
      | Jayashree | umeshgct@gmail.com | Coke@2021 |
    Then i check the Terms and Agreement
    Then i click the Get started now button on the page
    Then i should see the notification as email already signup
    Then i click the sign in button on the page
    Then i am redirected to "https://miro.com/login/"
    Then i login with following details
      | umeshgct@gmail.com | Coke@2021 |
    And i should see the dashboard page
