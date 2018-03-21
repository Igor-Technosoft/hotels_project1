package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 3/19/18.
 */
public class HotelsDetailsPageMenuSD {
    private HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^Given I’m starting with Hotels.com home page$")
    public void amIOnHotelsHomePage4() {
        String expectedResults = "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals";
        String actualResults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults, actualResults);
    }
    @When("^I enter Paris, France into Where To search box$")
    public void enterPlace1() {
        hotelsHomePage.enterText();
    }
    @When("^I click tomorrow’s date in the Checkin field$")
    public void clickDatebox2() throws InterruptedException {
        hotelsHomePage.setCurrentDate();
    }
   @When("^I click Search$")
    public void clickSearchButton1() throws InterruptedException {
        hotelsHomePage.clickSearchButton();
    }
    @Then("^I’m on Paris hotels page")
    public void seeMessage() {
        hotelsHomePage.verifySelection();
    }
    @Then("^I click the rooms menu on that page to update number of rooms to 2$")
    public void updateDetail() {
        hotelsHomePage.detailPage();
    }

}
