@skytimemachine
Feature: Clicking Fututre Date
  Scenario: Click Future Date and Verify Format
Given I am on homepage of darksky
When I click on Time Machine
And I select tomorrow date
Then I verify selected date is clickable
And I verify date is displayed in correct format