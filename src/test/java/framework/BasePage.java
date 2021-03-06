package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class BasePage {

	private static WebElement webAction(final By locator) {


	Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
			.withTimeout(15, TimeUnit.SECONDS)
			.pollingEvery(1, TimeUnit.SECONDS)
			.ignoring(java.util.NoSuchElementException.class)
			.ignoring(StaleElementReferenceException.class)
			.ignoring(ElementNotFoundException.class)
			.withMessage("Unable to find the element for locator " + locator.toString());
	WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
			return driver.findElement(locator);
		}
	});
		return element;
}





	public void clickOn(By locator) {
        try {
        	webAction(locator).click();

			//SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
	}
	}

	public void sendText(By locator, String text) {
		try {
			webAction(locator).sendKeys(text);
			//SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public void clickOnBrowserBackArrow() {
		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}
}
