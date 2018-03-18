package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by igorsandler on 2/17/18.
 */
public class SauceTestHotels {

    public static final String USERNAME = "Parisiene1";
    public static final String ACCESS_KEY = "ffc69554-0457-42e5-be0f-8ff919d012f1";
    public static final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs" +
            ".com:443/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "15.0");
        WebDriver driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
        driver.get("https://hotels.com/");
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Date date = new Date();
        String todayDate = sdf.format(date);
        String expectedResults = "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals";
        String actualResults = driver.getTitle();
        Assert.assertEquals(expectedResults, actualResults);
        try {


            driver.findElement(By.xpath("//*[@id=\"qf-0q-localised-check-in\"]")).click();
            List<WebElement> days = driver.findElements(By.xpath("" +
                    ".//*[@class='widget-datepicker-bd']/descendant::a"));
            for (WebElement day : days) {
                String expectedDay = day.getText();
                if (expectedDay.equals(todayDate)) {
                    day.click();
                    Thread.sleep(3000);
                    break;
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}



