package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "user-name")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Fluent Design Pattern
	public LoginPage enterUsername(String user) {
		username.clear();
		username.sendKeys(user);
		return this;
	}

	public LoginPage enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
		return this;
	}

	public LoginPage clickLogin() {
		loginButton.click();
		return this;
	}

	public LoginPage login(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
		return this;
	}

	public boolean isErrorMessageDisplayed() {
		try {
			return errorMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getErrorMessageText() {
		try {
			return errorMessage.getText();
		} catch (Exception e) {
			return "";
		}
	}
}