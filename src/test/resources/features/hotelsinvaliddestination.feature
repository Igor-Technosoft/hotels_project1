Feature: User enters invalid destination
  Background:
    Given I am on home page of the Hotels.com
    @hotels-invalid-destination
    Scenario: User enters invalid characters
      When I enter !!!!! invalid characters into Where To box
      And I enter tomorrow's date into Check in box
      And I click on Search button
      Then I see Sorry, we could not understand !!!!!