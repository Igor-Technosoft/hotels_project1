package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepdefinition.SharedSD;

/**
 * Created by igorsandler on 2/10/18.
 */
public class AmazonHomePage extends BasePage{

   // public class AmazonLandingPage extends BasePage {
        private By emailTextField = By.id("ap_email");
        private By passTextField = By.id("ap_password");
        private By loginButton = By.id("signInSubmit");
        private By continueButton = By.id("continue");
        public void enterEmail() {
            sendText(emailTextField,"w@tt.com");

           // setValueToInputField(email,emailTextField);
        }
        public void enterPassword() {
            if (SharedSD.getDriver().findElement(continueButton).isDisplayed()) {
                clickOn(continueButton);
            } else if (SharedSD.getDriver().findElement(passTextField).isDisplayed())
            {
                clickOn(passTextField);
                sendText(passTextField, "test1234");
                // setValueToInputField(password, passTextField);

            }
        }
        public void loginToAmazonApp() {
           // enterEmail();
           // enterPassword();

//            enterEmail(email);
//            enterPassword(password);
            clickOn(loginButton);
        }


    public void actionsNavigation() {
        try {
            WebElement element = SharedSD.getDriver().findElement(By.xpath("id(\"nav-link-accountList\")"));
            Actions action = new Actions(SharedSD.getDriver());
            action.moveToElement(element).build().perform();
            Thread.sleep(2000);
            SharedSD.getDriver().findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
            Thread.sleep(2000);
            // DriverWrapper.getDriver().findElement(By.cssSelector("#nav-flyout-ya-signin > a > span\n")
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
