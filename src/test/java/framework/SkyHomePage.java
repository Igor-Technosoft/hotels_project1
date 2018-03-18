package framework;


import jdk.nashorn.internal.ir.IfNode;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.*;
import java.text.SimpleDateFormat;
import java.lang.Object.*;
import java.util.Calendar;


/**
 * Created by igorsandler on 3/10/18.
 */
public class SkyHomePage extends BasePage {
    List<String> skyDays = new ArrayList<>();
    List<String> weekDays = new ArrayList<>();
    By todayBar = By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[2]");
    By timeButton = By.cssSelector("#timeMachine > div.buttonContainer > a");

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("d");


    public void daysOfWeek() {
        try {

            List<WebElement> list = SharedSD.getDriver().findElements(By.className("name"));
            for (WebElement element : list) {
                skyDays.add(element.getText());
                String days = element.getText();
                System.out.println(days);

            }
        } catch (ElementNotSelectableException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("EEE");
        Calendar date = Calendar.getInstance();
        weekDays.add("Today");

        for (int i = 0; i < 7; i++) {
            date.add(Calendar.DAY_OF_YEAR, 1);
            Date tomorrow = date.getTime();
            String tomorrowDate = format.format(tomorrow);
            weekDays.add(tomorrowDate);
            System.out.println(tomorrowDate);
            continue;
        }

    }

    public void compareDays() {
        Assert.assertEquals(skyDays, weekDays);
    }

    public void clickBar() {
        SharedSD.getDriver().findElement(todayBar).click();

    }

    public void dayTemps() {
        String minTemp = SharedSD.getDriver().findElement(By.className("minTemp")).getText();
        System.out.println(minTemp);
        String maxTemp = SharedSD.getDriver().findElement(By.className("maxTemp")).getText();
        System.out.println(maxTemp);
        String minUpTemp = SharedSD.getDriver().findElement(By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/" +
                "span[2]")).getText();
        System.out.println(StringUtils.stripStart(minUpTemp, "Low: "));
        String maxUpTemp = SharedSD.getDriver().findElement(By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/" +
                "span[3]")).getText();
        System.out.println(StringUtils.stripStart(maxUpTemp, "High: "));

        Assert.assertEquals(minTemp, StringUtils.stripStart(minUpTemp, "Low: "));
        Assert.assertEquals(maxTemp, StringUtils.stripStart(maxUpTemp, "High: "));
    }

    public void clickSkyTimeButton() {
        SharedSD.getDriver().findElement(timeButton).click();
    }


    public void selectFutureDate() {
        try {


            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date tomorrow = calendar.getTime();
            String tomorrowDate = sdf.format(tomorrow);
            List<WebElement> days = SharedSD.getDriver().findElements(By.xpath("//*[@class='pika-button pika-day']"));
            for (WebElement day : days) {
                String expectedDay = day.getText();
                if (expectedDay.equals(tomorrowDate)) {
                    day.click();
                    System.out.println(tomorrowDate);
                    break;
                }
            }

        } catch (ElementNotSelectableException e) {
            e.printStackTrace();
        }

    }

    public void checkEnabled() {
        By dateDisplay = By.xpath("//div[@class='date']");


        if (SharedSD.getDriver().findElement(dateDisplay).isEnabled()) {

            System.out.println("This date is clickable");
            //  Assert.assertEquals(isNotEnabled,isEnabled);

        }


    }

    public void checkDate() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = date.getTime();
        By dateDisplay = By.xpath("//div[@class='date']");
        String txt = SharedSD.getDriver().findElement(dateDisplay).getText();
        System.out.println(txt);
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        SimpleDateFormat format1 = new SimpleDateFormat("MMM");
        SimpleDateFormat format2 = new SimpleDateFormat("dd");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
        String disp = format.format(tomorrow);
        String disp1 = format1.format(tomorrow);
        String disp2 = format2.format(tomorrow);
        String disp3 = format3.format(tomorrow);
        String disp5 = disp + "," + " " +  disp1 + " " + disp2 + "th" + "," + " " + disp3;
        System.out.println(disp5);
        Assert.assertEquals(txt,disp5);
    }
}
