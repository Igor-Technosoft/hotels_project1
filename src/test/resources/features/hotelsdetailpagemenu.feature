Feature: Users can update their choices on Destination page
  Background: Given I’m starting with Hotels.com home page

    @hotels-update-detail
    Scenario: User update number of rooms on Destination page
      When I enter Paris, France into Where To search box
      And I click tomorrow’s date in the Checkin field
      And I click Search
      Then I’m on Paris hotels page
      And I click the rooms menu on that page to update number of rooms to 2
