package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 3/18/18.
 */
public class HotelsHomePageNoDestinationSD {
    private HotelsHomePage hotelsHomePage = new HotelsHomePage();

        @Given("^I am on home page of Hotels.com$")
        public void amIOnHotelsHomePage1() {
            String expectedResults = "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals";
            String actualResults = SharedSD.getDriver().getTitle();
            Assert.assertEquals(expectedResults, actualResults);
        }
    @When("^I enter tomorrow's date in the Check in box$")
    public void clickDatebox1() throws InterruptedException {
        hotelsHomePage.setCurrentDate();
    }
    @When("^I click the Search button$")
    public void clickSearchButton1() throws InterruptedException {
        hotelsHomePage.clickSearchButton();
    }
    @Then("^I see Please tell us the destination, hotel or landmark you’re looking for displayed$")
    public void seeAlert() {
        hotelsHomePage.verifyText();
    }
    }

