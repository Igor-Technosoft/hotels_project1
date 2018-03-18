@hotels-regression
Feature: Clicking today's date
  Background:
    Given I am on home page of Hotels


    @hotels-destination
      Scenario: Entering destination
      When I enter Paris in Where To box
      And I enter tomorrow's date in Check in box
      And I enter a 6 days from now in Check out box
      And I verify 6 nights is displayed
      And I click on rooms drop-down
      And I select 2 from adults drop-down
      And I select 2 from Children drop-down
      And I select 2 from Child1 drop-down
      And I select <1 from Child2 drop-down
      And I click Search button
      Then I see Paris, France selected
      And I'm on Paris, France destination page



