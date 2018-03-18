package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.SkyHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 3/11/18.
 */
public class SkyTimeMachineSD {
    private SkyHomePage skyHomePage = new SkyHomePage();
    @Given("^I am on homepage of darksky1$")
    public void AmIOnSkyHomePage1() {
        String expectedResults = "Dark Sky - 260 Broadway, New York City, NY";
        String actualREsults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults,actualREsults);
    }
    @When("^I click on Time Machine$")
    public void clickTimeButton() {
        skyHomePage.clickSkyTimeButton();
    }
    @When("^I select tomorrow date$")
    public void clickDate() {
    //skyHomePage.clickFutureDate();
        skyHomePage.selectFutureDate();

    }
    @Then("^I verify selected date is clickable$")
    public  void checkClick() {
        skyHomePage.checkEnabled();
    }
    @Then("^I verify date is displayed in correct format")
    public void  checkDisplay() {
        skyHomePage.checkDate();
    }
}
