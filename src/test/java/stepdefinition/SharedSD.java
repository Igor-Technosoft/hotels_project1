package stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.ConfigReader;


public class SharedSD {


	private static WebDriver driver = null;

	@Before


	public static void before() {

	ConfigReader configReader = new ConfigReader();
		String browser = System.getProperty("BROWSER");
		if(browser==null) {
			browser = System.getenv("BROWSER");
			if (browser == null) {

				browser = "chrome";

			}
		}
		switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						configReader.getChromeDriverPath());
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver",
						configReader.getFirefoxDriverPath());
				driver = new FirefoxDriver();
				break;
			case "safari":
				System.setProperty("webdriver.safari.driver",
						configReader.getSafariDriverPath());
				driver = new SafariDriver();

			case "default":
				System.setProperty("webdriver.firefox.driver",
						configReader.getFirefoxDriverPath());
				driver = new FirefoxDriver();
				break;
		}
//		System.setProperty("webdriver.chrome.driver",
//				configReader.getChromeDriverPath());
//		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(configReader.getUrl());

	}

	@After
	public static void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
		//	driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
