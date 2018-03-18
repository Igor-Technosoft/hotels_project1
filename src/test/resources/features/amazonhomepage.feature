@login @regression
Feature: Testing Invalid Login
Background:
  Given I am on home page of Amazon

  @amazon-login
  Scenario: Verify user should not be able to login using invalid credentials
  When I Hover over to Accounts & List
  And I enter invalid email address
  And if I see password field I enter invalid password
  Then I verify invalid error message

