package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.List;

/**
 * Created by igorsandler on 2/10/18.
 */
public class ExpediaHomePage extends BasePage{
    private By flightsButton = By.id("tab-flight-tab-hp");
    private By flyingFromTextBox = By.xpath("//*[@id=\"flight-origin-hp-flight\"]");

    public void clickFunctionButton() {
        // DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"tab-flight-tab-hp\"]/span[1]")).click();
        SharedSD.getDriver().findElement(flightsButton).click();
    }

    public void testAutoComplete() {
        try {

            // DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"flight-origin-hp-flight\"]")).sendKeys
            // ("Paris");
            SharedSD.getDriver().findElement(flyingFromTextBox).sendKeys("Paris");
            Thread.sleep(3000);
            List<WebElement> list = SharedSD.getDriver().findElements(By.className("results-item"));
            for (WebElement element: list) {
                if (element.getText().contains("Paris")) {
                    element.click();
                    Thread.sleep(3000);
                }
//                String msg = element.getText();
//                String expectedResult = "Paris, France (PAR-All Airports)";
//                Assert.assertEquals(msg,expectedResult);


            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public void verifyText() {
        List<WebElement> list = SharedSD.getDriver().findElements(By.className("results-item"));
        for (WebElement element : list) {
            if (element.getText().contains("Paris")) {
                String msg = element.getText();
                String expectedResult = "Paris, France (PAR-All Airports)";
                Assert.assertEquals(msg, expectedResult);

            }
        }
    }



    public void clickFlyingFromBox() {
        SharedSD.getDriver().findElement(flyingFromTextBox).click();;
    }

}
