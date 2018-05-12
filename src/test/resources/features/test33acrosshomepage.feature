@ad-display
Feature: Testing waiting for the add and closing the add
  Background:
    Given I'm on the 33Across.com home page

    Scenario: Closing the ad displayed on the screen
      When I see  33Across ad displayed on the left of the page and I click close button
      Then I see the ad disappear from the screen
