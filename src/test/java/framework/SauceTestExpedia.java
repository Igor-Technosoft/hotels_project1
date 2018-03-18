package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.net.URL;
import java.util.List;

/**
 * Created by igorsandler on 2/17/18.
 */
public class SauceTestExpedia {
    public static final String USERNAME = "Parisiene1";
    public static final String ACCESS_KEY = "ffc69554-0457-42e5-be0f-8ff919d012f1";
    public static final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY +"@ondemand.saucelabs" +
            ".com:443/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "55.0");
        WebDriver driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
        driver.get("https://expedia.com/");

        String expectedResults = "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations";
        String actualResults = driver.getTitle();
        Assert.assertEquals(expectedResults, actualResults);
        try {
            driver.findElement(By.id("tab-flight-tab-hp")).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + driver.findElement(By.id("tab-flight-tab-hp"))
                    .toString());
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"flight-origin-hp-flight\"]")).click();
        try {


            driver.findElement(By.xpath("//*[@id=\"flight-origin-hp-flight\"]")).sendKeys("Paris");
            Thread.sleep(3000);
            List<WebElement> list = SharedSD.getDriver().findElements(By.className("results-item"));
            for (WebElement element: list) {
                if (element.getText().contains("Paris")) {
                    element.click();
                    Thread.sleep(3000);
                }


            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> list = driver.findElements(By.className("results-item"));
        for (WebElement element : list) {
            if (element.getText().contains("Paris")) {
                String msg = element.getText();
                String expectedResult = "Paris, France (PAR-All Airports)";
                Assert.assertEquals(msg, expectedResult);

            }
        }

        driver.quit();
    }
    }
