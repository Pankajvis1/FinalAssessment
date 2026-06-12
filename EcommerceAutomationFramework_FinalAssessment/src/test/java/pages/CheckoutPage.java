package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutPage {

	private static final Logger log = LoggerFactory.getLogger(CheckoutPage.class);

	WebDriver driver;

	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By postalCode = By.id("postal-code");
	By continueButton = By.id("continue");
	By finishButton = By.id("finish");
	By successMessage = By.className("complete-header");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;

	}

	public void enterCheckoutDetails(String fname, String lname, String pin) {

		log.info("Entering checkout details");

		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(postalCode).sendKeys(pin);

		log.info("Clicking continue button");

		driver.findElement(continueButton).click();

	}

	public void finishCheckout() {

		log.info("Clicking finish button");

		driver.findElement(finishButton).click();

	}

	public String getSuccessMessage() {

		log.info("Getting success message");

		return driver.findElement(successMessage).getText();
	}
}
