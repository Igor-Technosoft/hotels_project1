package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.ExpediaHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 2/10/18.
 */
public class ExpediaHomePageSD {
    private ExpediaHomePage expediaHomePage = new ExpediaHomePage();
    @Given("^I’m on Expedia home page$")
    public void amIOnExpediaPage() {
        String expectedResults = "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations";
        String actualResults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults,actualResults);
    }
    @When("^I click on Flights button$")
    public void clickFlightsButton() {
        expediaHomePage.clickFunctionButton();
    }
    @When("^I click in Flying from box$")
    public void clickFlyingFrom() {
        expediaHomePage.clickFlyingFromBox();
    }
    @When("^I type Paris$")
    public void enterTypeAhead() {
        expediaHomePage.testAutoComplete();
    }
    @Then("^I see Paris, France (PAR-All Airports)$")
    public void verifyEntry() {
        expediaHomePage.verifyText();
    }
}
