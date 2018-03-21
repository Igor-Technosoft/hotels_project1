Feature: Users select a large number of rooms
  Background: Given I'm starting on Hotels.com home page

  @hotels-group-page
  Scenario: User selects more than 9 rooms
    When  I enter Paris, France into the Where To box
    And I enter tomorrow's date into the Check in box
    And I click on the rooms drop-down
    And I select more than 9 as a choice
    And I click on the Search button
    Then I see Paris group hotel page

