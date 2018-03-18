package framework;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends BasePage{

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");
	private By firstNameTextField = By.id("firstName");
	//private By firstNameTextField = By.xpath("//*[@id=\"u_0_b\"]");
	private By lastNameTextField = By.id("lastName");
	//private By lastNameTextField = By.xpath("//*[@id=\"u_0_d\"]");
	private By mobileNumberTextField = By.id("mobileNumber");
	//private By mobileNumberTextField = By.xpath("//*[@id=\"u_0_g\"]");
	private By newPasswordTextField = By.id("newPwd");
//	private By newPasswordTextField = By.id("newPwd");
//	private By newPasswordTextField = By.xpath("//*[@id=\"u_0_n\"]");
	private By errorMessage = By.xpath("//*[@id=\"auth-error-message-box\"]");
	//private By errorMessage = By.xpath("")
//	private By createAccountButton = By.id("u_0_t");
//	private By maleRadioButton = By.xpath("//*[@id=\"u_0_9\"]");

//	private By firstNameTextField = By.xpath("//*[@id=\"u_0_m\"]");
//	private By lastNameTextField = By.xpath("//*[@id=\"u_0_o\"]");
//	private By phoneNumberTextField = By.xpath("//*[@id=\"u_0_r\"]");
//	private By createAccountButton = By.xpath("//*[@id=\"u_0_14\"]");
//	private By newPasswordTextField = By.xpath("//*[@id=\"u_0_y\"]");
//	private By genderRadioButton = By.id("u_0_9");
//	private By monthDropdownField = By.id("month");
//	private By dayDropDownField = By.id("day");
//	private By yearDropDownField = By.id("year");
	
	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

	public void enterEmail(String enterEmail) {
		sendText(emailTextField, enterEmail);
	}
	
	public void enterPassword(String enterPassword) {
		sendText(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		sendText(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		sendText(lastNameTextField, lastName);
	}

	public void enterMobileNumber(String mobileNum) {
		sendText(mobileNumberTextField, mobileNum);
	}

	public void enterNewPassword(String password) {
		sendText(newPasswordTextField, password);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

//	public void createAccount() {
//		//clickOn(genderRadioButton);
//		clickOn(createAccountButton);

	}











