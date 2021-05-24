#Author: Jayashree Eswaran
#Scenario Outline: Exception handle in page
@signup @invaliduser
Feature: User registration
  I want to check exception handle for invalid entry

  @invalidWorkMailField
  Scenario: Exception Handle for Invalid work mail field
    Given i open signup page
    When i am on "https://miro.com/signup/"
    Then i signup with following details
      | Shree04 | ejaya0409@gmai | Sc@nari01 |
    Then i check the Terms and Agreement
    Then i click the Get started now button on the page
    And i should see the notification to enter the valid work mail

  @invalidPasswordField
  Scenario: Exception Handle for Invalid password field
    Given i open signup page
    When i am on "https://miro.com/signup/"
    Then i signup with following details
      | Shree04 | ejaya0409@gmai | Sc@nar |
    And i should see the notification to enter the valid password
