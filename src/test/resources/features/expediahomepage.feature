@regression @login
  Feature: Type Ahead Testing
    Background:
      Given I’m on Expedia home page

      @typeahead1
      Scenario: Enter City Name into Flying from box
        When I click on Flights button
        And I click in Flying from box
        And I type Paris
        Then I see Paris, France (PAR-All Airports)
