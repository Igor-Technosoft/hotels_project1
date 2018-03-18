package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.SkyHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 3/10/18.
 */
public class SkyTempSD {
    private SkyHomePage skyHomePage = new SkyHomePage();
    @Given("^I am on home page of darksky$")
    public void AmIOnSkyHomePage() {
        String expectedResults = "Dark Sky - 260 Broadway, New York City, NY";
        String actualREsults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults,actualREsults);
    }
    @When("^I click on todays bar$")
    public void clickDateBar() {
        skyHomePage.clickBar();
    }
    @Then("^I verify low and high temp displayed correctly on parent bar$")
    public void VerifyTemps() {
        skyHomePage.dayTemps();
    }
}
