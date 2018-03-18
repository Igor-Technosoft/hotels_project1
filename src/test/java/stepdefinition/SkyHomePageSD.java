package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.SkyHomePage;
import org.testng.Assert;

/**
 * Created by igorsandler on 3/10/18.
 */
public class SkyHomePageSD {
    private SkyHomePage skyHomepage = new SkyHomePage();
    @Given("^I am on homepage of darksky$")
    public void AmIOnSkyHomePage() {
        String expectedResults = "Dark Sky - 260 Broadway, New York City, NY";
        String actualREsults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults,actualREsults);
    }
    @Then("^I verify days of the week is displayed in correct order$")
public void displayDays() {
        skyHomepage.daysOfWeek();

       skyHomepage.compareDays();



    }
}
