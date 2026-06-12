package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductsPage {

	private static final Logger log = LoggerFactory.getLogger(ProductsPage.class);

	WebDriver driver;

	By productTitle = By.className("title");
	By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
	By cartIcon = By.className("shopping_cart_link");

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {

		log.info("Getting products page title");

		return driver.findElement(productTitle).getText();
	}

	public void addProductToCart() {

		log.info("Adding product to cart");

		driver.findElement(addToCartButton).click();
	}

	public void goToCart() {

		log.info("Opening cart page");

		driver.findElement(cartIcon).click();
	}
}