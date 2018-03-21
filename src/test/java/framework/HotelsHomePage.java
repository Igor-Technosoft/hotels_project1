package framework;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefinition.SharedSD;
import sun.security.provider.SHA;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

/**
 * Created by igorsandler on 2/16/18.
 */
public class HotelsHomePage extends BasePage {
    //public String checkDate;
    // public By checkDate = By.xpath("//*[@id=\"qf-0q-localised-check-in\"]");
   // private By checkinField = By.xpath("//*[@id=\"qf-0q-localised-check-in\"]");

    private By checkinField = By.cssSelector("#qf-0q-localised-check-in");
    private By checkoutField = By.cssSelector("#qf-0q-localised-check-out");
    private By numberNights = By.xpath("//*[@id=\"qf-0q-nights\"]/span[1]/span");
    private By textSeen = By.xpath("//*[@id=\"main-content\"]/main/div[2]/div/div[1]/div/div[1]/div[1]" +
            "/div/div/form/div[1]/div/div/span");
    private By invalidText = By.xpath("//*[@id=\"widget-overlay-title-1\"]");
    private By linkText = By.cssSelector("#hdr-customer-bookings");
    private By selectChoices = By.cssSelector("#qf-0q-compact-occupancy");
    private By selectGroupChoice = By.cssSelector("#qf-0q-rooms");
    private By selectDetailPage = By.cssSelector("#q-rooms");
    private By searchButton = By.cssSelector("#change-search-form > div > form >" +
            " div.widget-query-group.widget-query-ft > button");
    private By filterDetail = By.cssSelector("#f-popular-2048");
    private By choiceFilterText = By.cssSelector("#applied-filters > div > ul > li");
    private By editButton = By.xpath("//button[@type='button'][contains(text(),'Edit or add rooms')]");
    private By selectAdults = By.xpath("//*[@id=\"qf-0q-room-0-adults\"]");
    private By selectChild = By.xpath("//*[@id=\"qf-0q-room-0-children\"]");
    private By child1Age = By.xpath("//*[@id=\"qf-0q-room-0-child-0-age\"]");
    private By child2Age = By.xpath("//*[@id=\"qf-0q-room-0-child-1-age\"]");

    SimpleDateFormat sdf = new SimpleDateFormat("d");
    Date date = new Date();
    String todayDate = sdf.format(date);
    Calendar calendar = Calendar.getInstance();
    private By whereBox = By.cssSelector("#qf-0q-destination");
    private By searchBox = By.xpath("//*[@id=\"main-content\"]/main/div[2]/div/div[1]/div/div[1]/div[1]/div/div/" +
            "form/div[5]/button");



    public void setCurrentDate() {
      //  try {


            SharedSD.getDriver().findElement(checkinField).click();
           calendar.add(Calendar.DAY_OF_YEAR, 1);
           Date tomorrow = calendar.getTime();
           String tomorrowDate = sdf.format(tomorrow);
            List<WebElement> days = SharedSD.getDriver().findElements(By.xpath("" +
                    ".//*[@class='widget-datepicker-bd']/descendant::a"));
            for (WebElement day : days) {
                String expectedDay = day.getText();
                if (expectedDay.equals(tomorrowDate)) {
                    day.click();
                   // Thread.sleep(3000);
                    break;
                }
            }


//        } catch (InterruptedException e) {
//            e.printStackTrace();
      //  }
    }

    public void setNextDate() {
        SharedSD.getDriver().findElement(checkoutField).click();
        calendar.add(Calendar.DAY_OF_YEAR, 6);
        Date tomorrow = calendar.getTime();
        String futureDate = sdf.format(tomorrow);
        List<WebElement> days = SharedSD.getDriver().findElements(By.xpath("" +
                ".//*[@class='widget-datepicker-bd']/descendant::a"));
        for (WebElement day : days) {
            String expectedDay = day.getText();
            if (expectedDay.equals(futureDate)) {
                day.click();
                // Thread.sleep(3000);
                break;
            }
        }
    }
    public void verifyNights() {
      WebElement element =  SharedSD.getDriver().findElement(numberNights);
        String expectedNumber = "6";
        String actualNumber = element.getText();
        Assert.assertEquals(expectedNumber,actualNumber);
    }
    public void clickEditButton() {
        Select choiceMenu = new Select(SharedSD.getDriver().findElement(selectChoices));
        choiceMenu.selectByIndex(2);
    }

    public void selectGroup() {
        Select groupChoice = new Select(SharedSD.getDriver().findElement(selectGroupChoice));
        groupChoice.selectByIndex(8);
    }
    public void detailPage() {
        Select detailChoice = new Select(SharedSD.getDriver().findElement(selectDetailPage));
        detailChoice.selectByVisibleText("2");
      //  SharedSD.getDriver().findElement(searchButton).click();
    }
    public void detailPageFilter() {
        Select detailChoice = new Select(SharedSD.getDriver().findElement(selectDetailPage));
        detailChoice.selectByVisibleText("2");
        SharedSD.getDriver().findElement(filterDetail).click();
    }
    public void clickText() {
        SharedSD.getDriver().findElement(linkText).click();
    }
    public void bookingPage() {
        String expectedText = "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels" +
                " to Budget Accommodations";
        String actualText = SharedSD.getDriver().getTitle();
        Assert.assertEquals(actualText,expectedText);
    }
    public void verifyDetails() {
        String expectedResults = "Amenities: Free Breakfast";
        WebElement element = SharedSD.getDriver().findElement(choiceFilterText);
        String actualResults = element.getText();
        Assert.assertEquals(actualResults,expectedResults);
    }
    public void verifyGroup() {
        String expectedTitle = "Group Hotel Quote Request";
        String actualTitle = SharedSD.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    public void selectMenu1() {
        Select adultsMenu = new Select(SharedSD.getDriver().findElement(selectAdults));
        adultsMenu.selectByVisibleText("2");
    }
    public void selectMenu2() {
        Select childrenMenu = new Select(SharedSD.getDriver().findElement(selectChild));
        childrenMenu.selectByVisibleText("2");
    }
    public void selectAge1() {
        Select ageOne = new Select(SharedSD.getDriver().findElement(child1Age));
        ageOne.selectByVisibleText("2");
    }
    public void selectAge2() {
        Select ageTwo = new Select(SharedSD.getDriver().findElement(child2Age));
        ageTwo.selectByVisibleText("<1");
    }

    public void verifyDate() {


        WebElement msg = SharedSD.getDriver().findElement(By.cssSelector("#qf-0q-localised-check-in"));
        String expectedDay = msg.getText();
        if (expectedDay.equals(todayDate)) {
            Assert.assertEquals(expectedDay, todayDate);

        }
    }

    public void clickWhereBox() {
        try {


            SharedSD.getDriver().findElement(whereBox).click();
        } catch (ElementNotSelectableException e) {
            e.printStackTrace();
        }
    }

    public void enterText() throws StaleElementReferenceException {

            try {
                SharedSD.getDriver().findElement(whereBox).sendKeys("Paris, France");
                Thread.sleep(3000);
             //   WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), 10);
                List<WebElement> list = SharedSD.getDriver().findElements(By.xpath("//*[@id=\"citysqm-asi0-s0\"]" +
                        "/td/div[2]"));
                for (WebElement element : list) {
                    if (element.getText().contains("Paris, France")) {
                        element.click();
                        break;
                    }
                }
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();

                } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
    public void enterInvalidText() {
        SharedSD.getDriver().findElement(whereBox).sendKeys("!!!!!");
    }
    public void verifyText() {
        String expectedText = "Please tell us the destination, hotel or landmark you’re looking for";
        WebElement element = SharedSD.getDriver().findElement(textSeen);
        String actualText = element.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    public void verifyInvalidText() {
        String expectedText = "Sorry, we could not understand !!!!!";
        WebElement element = SharedSD.getDriver().findElement(invalidText);
        String actualText = element.getText();
        Assert.assertEquals(expectedText,actualText);
    }


    public void verifySelection() {
        List<WebElement> list = SharedSD.getDriver().findElements(By.className("autosuggest-category-results"));
        for (WebElement element : list) {
            if (element.getText().contains("Paris")) {
                String actualTest = element.getText();
                String expectedTest = "Paris, France";
                Assert.assertEquals(actualTest, expectedTest);
            }
        }
    }

    public void clickSearchButton() {
        try {


            SharedSD.getDriver().findElement(searchBox).click();

        } catch (ElementNotSelectableException e) {
            e.printStackTrace();
        }
    }
   public void handleAlert() throws InterruptedException {
     // SharedSD.getDriver().switchTo().alert().dismiss();
       SharedSD.getDriver().findElement(By.xpath("//*[@id=\"managed-overlay\"]/button")).click();
      // Thread.sleep(2000);
   }
}




