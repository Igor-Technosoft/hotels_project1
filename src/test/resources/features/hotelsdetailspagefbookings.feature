Feature: Users apply filters
  Background: Given I’m starting with the  Hotels.com home page

    @hotels-booking-page
    Scenario: User chooses Free Breakfast filter
      When I type-in Paris, France into Where To search box
      And I click on tomorrow’s date in the Checkin field
      And I click the Search option
      Then I’m on the Paris hotels page
      And I click on the rooms menu on that page
      And I click on Your Bookings
      Then I see Sign-in page