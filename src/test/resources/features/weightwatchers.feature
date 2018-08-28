@weight-watchers-test
Feature: Searching for a meeting and displaying results
  Background: Given I'm on Weigh Watchers home page

    Scenario: Searching for a first Weight Watchers meeting location based on 10011 zip code
      When I click on Find a Meeting button
      And I enter 10011 zip code in the search field
      Then I see the first meeting location and distance
      And I click location name
      And I verify that I've selected the same location as was on the previous page
      And I print out the hours of operation fot this location
