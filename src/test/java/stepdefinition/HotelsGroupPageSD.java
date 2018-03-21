package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 3/18/18.
 */
public class HotelsGroupPageSD {
    private HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I'm starting on Hotels.com home page$")
    public void amIOnHotelsHomePage3() {
        String expectedResults = "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals";
        String actualResults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults, actualResults);
    }
    @When("^I enter Paris, France into the Where To box$")
    public void enterPlace1() {
        hotelsHomePage.enterText();
    }
    @When("^I enter tomorrow's date into the Check in box$")
    public void clickDatebox2() throws InterruptedException {
        hotelsHomePage.setCurrentDate();
    }
    @When("^I click on the rooms drop-down$")
    public void clickEditChoice() {
        hotelsHomePage.clickEditButton();
    }
    @When("^I select more than 9 as a choice$")
    public void clickEditChoice1() {
        hotelsHomePage.selectGroup();
    }
    @When("^I click on the Search button$")
    public void clickSearchButton1() throws InterruptedException {
        hotelsHomePage.clickSearchButton();
    }
    @Then("^I see Paris group hotel page")
    public void seeMessage() {
        hotelsHomePage.verifyGroup();
    }
}
