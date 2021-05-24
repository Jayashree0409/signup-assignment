#Author: Jayashree Eswaran
#Scenario Outline: Exception handle in page
@signup @nullcheck
Feature: User registration
  I want to check null exception handle in the page

  @nullnamefield
  Scenario: Exception Handle for Null Name field
    Given i open signup page
    When i am on "https://miro.com/signup/"
    Then i signup null value with following details
      | [blank] | ejaya0409@gmail.com | Sc@nari01 |
    Then i check the Terms and Agreement
    Then i click the Get started now button on the page
    And i should see the notification to enter the name

  @nullworkmailfield
  Scenario: Exception Handle for Null Work Mail field
    Given i open signup page
    When i am on "https://miro.com/signup/"
    Then i signup null value with following details
      | Shree04 | [blank] | Sc@nari01 |
    Then i check the Terms and Agreement
    Then i click the Get started now button on the page
    And i should see the notification to enter the work mail

  @nullpasswordfield
  Scenario: Exception Handle for Password field
    Given i open signup page
    When i am on "https://miro.com/signup/"
    Then i signup null value with following details
      | Shree04 | ejaya0409@gmail.com | [blank] |
    Then i check the Terms and Agreement
    Then i click the Get started now button on the page
    And i should see the notification to enter the password

  @nulltermsandagreementfield
  Scenario: Exception Handle for Null Terms and Agreement field
    Given i open signup page
    When i am on "https://miro.com/signup/"
    Then i signup null value with following details
      | Shree04 | ejaya0409@gmail.com | Sc@nari01 |
    Then i click the Get started now button on the page
    And i should see the notification to check the terms and agreement
