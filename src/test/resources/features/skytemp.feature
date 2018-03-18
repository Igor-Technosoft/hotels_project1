@verifytemps
Feature: Verify that Min and Max temps display correctly
  Scenario: Click on Bar and verify temps
    Given I am on home page of darksky
    When  I click on todays bar
    Then I verify low and high temp displayed correctly on parent bar
