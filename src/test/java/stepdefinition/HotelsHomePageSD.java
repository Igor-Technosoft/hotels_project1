package stepdefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.ExpediaHomePage;
import framework.HotelsHomePage;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by igorsandler on 2/16/18.
 */
public class HotelsHomePageSD {
    private HotelsHomePage hotelsHomePage = new HotelsHomePage();
    @Given("^I am on home page of Hotels$")
    public void amIOnHotelsHomePage() {
        String expectedResults = "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals";
        String actualResults = SharedSD.getDriver().getTitle();
        Assert.assertEquals(expectedResults,actualResults);
    }
//    @When("^I click Where to box$")
//    public void clickWhereBox() {
//        hotelsHomePage.clickWhereBox();
//
//    }
    @When("^I enter Paris in Where To box$")
    public void enterPlace() throws InterruptedException {
        //hotelsHomePage.handleAlert();
        hotelsHomePage.enterText();
    }

    @When("^I enter tomorrow's date in Check in box$")
    public void clickDatebox() throws InterruptedException {
        hotelsHomePage.setCurrentDate();
    }
    @When("^I enter a 6 days from now in Check out box$")
    public void clickFutureNext() {
        hotelsHomePage.setNextDate();
    }
    @When("^I verify 6 nights is displayed$")
    public void verifyNights() {
        hotelsHomePage.verifyNights();
    }
    @When("^I click on rooms drop-down$")
    public void clickEditChoice() {
        hotelsHomePage.clickEditButton();
    }
    @When("^I select 2 from adults drop-down$")
    public void selectMenu1() {
        hotelsHomePage.selectMenu1();
    }
    @When("^I select 2 from Children drop-down$")
    public void selectMenu2() {
        hotelsHomePage.selectMenu2();
    }
    @When("^I select 2 from Child1 drop-down$")
    public void selectAge1Menu() {
        hotelsHomePage.selectAge1();
    }
    @When("^I select <1 from Child2 drop-down$")
    public void selectAge2Menu() {
        hotelsHomePage.selectAge2();
    }

    @When("^I click Search button$")
    public void clickSearchButton() throws InterruptedException {
        hotelsHomePage.clickSearchButton();
    }

    @Then("^I see Paris, France selected$")
    public void verifyDestination() {
        hotelsHomePage.verifySelection();
    }


    @Then("^I'm on Paris, France destination page$")
    public void verifyPage() {
        String expecteddTest = "Hotels.com - hotels in Paris, France";
        String actualTest = SharedSD.getDriver().getTitle();
        Assert.assertEquals(actualTest,expecteddTest);
    }

}
