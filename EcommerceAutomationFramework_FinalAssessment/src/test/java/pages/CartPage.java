package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage {

	private static final Logger log = LoggerFactory.getLogger(CartPage.class);

	WebDriver driver;

	By cartItem = By.className("inventory_item_name");
	By checkoutButton = By.id("checkout");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getCartItemName() {
		log.info("Getting cart item name");

		return driver.findElement(cartItem).getText();
	}

	public void clickCheckout() {
		log.info("Clicking checkout button");

		driver.findElement(checkoutButton).click();
	}
}
