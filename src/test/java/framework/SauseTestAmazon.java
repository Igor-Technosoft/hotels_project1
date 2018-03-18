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

/**
 * Created by igorsandler on 2/17/18.
 */
public class SauseTestAmazon {
    public static final String USERNAME = "Parisiene1";
    public static final String ACCESS_KEY = "ffc69554-0457-42e5-be0f-8ff919d012f1";
    public static final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY +"@ondemand.saucelabs" +
            ".com:443/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "15.0");
        WebDriver driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
        driver.get("https://amazon.com/");

        String expectedResults = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualResults = driver.getTitle();
        Assert.assertEquals(expectedResults,actualResults);
        try {
            WebElement element = driver.findElement(By.xpath("id(\"nav-link-accountList\")"));
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
            Thread.sleep(2000);
            // DriverWrapper.getDriver().findElement(By.cssSelector("#nav-flyout-ya-signin > a > span\n")
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            driver.findElement(By.id("ap_email")).sendKeys("W2@t.com");
            //SharedSD.getDriver().findElement(locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + driver.findElement(By.id("ap_email")).toString());
            e.printStackTrace();
        }
        try {
            driver.findElement(By.id("continue")).click();

            //SharedSD.getDriver().findElement(locator).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + driver.findElement(By.id("continue")).toString());
            e.printStackTrace();
        }
        driver.quit();
    }







    }



