Feature: User forgets to enter Destination
  Background:
    Given I am on home page of Hotels.com
    @hotels-no-destination
    Scenario: No destination entered
      When I enter tomorrow's date in the Check in box
      When I click the Search button
      Then I see Please tell us the destination, hotel or landmark you’re looking for displayed