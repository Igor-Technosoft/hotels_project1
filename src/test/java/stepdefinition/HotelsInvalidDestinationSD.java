package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 3/18/18.
 */
public class HotelsInvalidDestinationSD {
    private HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I am on home page of the Hotels.com$")
    public void amIOnHotelsHomePage2() {
        String expectedResults = "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals";
        String actualResults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults, actualResults);
    }
    @When("^I enter !!!!! invalid characters into Where To box$")
    public void enterPlace1() {
        hotelsHomePage.enterInvalidText();
    }
    @When("^I enter tomorrow's date into Check in box$")
    public void clickDatebox2() throws InterruptedException {
        hotelsHomePage.setCurrentDate();
    }
    @When("^I click on Search button$")
    public void clickSearchButton1() throws InterruptedException {
        hotelsHomePage.clickSearchButton();
    }
    @Then("^I see Sorry, we could not understand !!!!!")
    public void seeMessage() {
        hotelsHomePage.verifyInvalidText();
    }
}

