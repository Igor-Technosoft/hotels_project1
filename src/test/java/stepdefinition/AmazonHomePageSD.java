package stepdefinition;

import framework.AmazonHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import framework.LoginPage;
import framework.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by igorsandler on 2/10/18.
 */
public class AmazonHomePageSD {
private AmazonHomePage amazonHomePage = new AmazonHomePage();
private HomePage homePage = new HomePage();
    @Given("^I am on home page of Amazon$")
    public void amIonAmazonHomePage() {
        String expectedResults = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualResults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults,actualResults);
        //Assert.assertEquals(SharedSD.getDriver().getTitle(), "Amazon.com: Online Shopping for Electronics, " +
         //       "Apparel," +
         //       " Computers, Books, DVDs & more", expectedResults);
    }
    @When("^I Hover over to Accounts & List$")
    public void hoverOverMenu() {
        amazonHomePage.actionsNavigation();
    }
    @When("^I enter invalid email address$")
    public void enterInvalidEmail() {
        amazonHomePage.enterEmail();
    }
    @When("^if I see password field I enter invalid password")
    public void enterInvalidPassword() {

        amazonHomePage.enterPassword();
    }
//    @When("^I click on Sign in button$")
//    public void clickSigninButton() {
//        amazonHomePage.loginToAmazonApp();
//
//    }
    @Then("^I verify invalid error message$")
    public void verifyMessage() {
    String actualResults = homePage.getErrorMessage();
    String expectedResults = "There was a problem\n" +
            "We cannot find an account with that email address";
    Assert.assertEquals(expectedResults,actualResults);
    }
}
