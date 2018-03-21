package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 3/19/18.
 */
public class HotelsDetailsPageBookingsSD {
    private HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I type-in Paris, France into Where To search box$")
    public void amIOnHotelsHomePage5() {
        String expectedResults = "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals";
        String actualResults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults, actualResults);
    }

    @When("^I click on tomorrow’s date in the Checkin field$")
    public void enterPlace1() {
        hotelsHomePage.enterText();
    }

    @When("^I click the Search$")
    public void clickDatebox2() throws InterruptedException {
        hotelsHomePage.setCurrentDate();
    }

    @When("^I click the Search option$")
    public void clickSearchButton2() throws InterruptedException {
        hotelsHomePage.clickSearchButton();
    }

    @Then("^I’m on the Paris hotels page")
    public void seeMessage() {
        hotelsHomePage.verifySelection();
    }

    @Then("^I click on the rooms menu on that page$")
    public void updateDetail() {
        hotelsHomePage.detailPage();
    }
    @When("^I click on Your Bookings$")
    public void clickLink() {
        hotelsHomePage.clickText();
    }
    @Then("^I see Sign-in page$")
    public void verifyPage() {
        hotelsHomePage.bookingPage();
    }

}
