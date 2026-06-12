package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.CSVUtil;

public class SauceDemoTest extends BaseTest {

	@DataProvider(name = "validLoginData")
	public Object[][] validLoginData() {
		return CSVUtil.getLoginData("src/test/resources/loginData.csv", "valid");
	}

	@DataProvider(name = "invalidLoginData")
	public Object[][] invalidLoginData() {
		return CSVUtil.getLoginData("src/test/resources/loginData.csv", "invalid");
	}

	@Test(priority = 1, dataProvider = "validLoginData")
	public void validLoginWithCSV(String username, String password) {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(username, password);

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Valid login failed for user: " + username);
	}

	@Test(priority = 2, dataProvider = "invalidLoginData")
	public void invalidLoginWithCSV(String username, String password) {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(username, password);

		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for user: " + username);
	}

	@Test(priority = 3)
	public void addToCartTest() {
		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CartPage cartPage = new CartPage(driver);

		loginPage.login("standard_user", "secret_sauce");

		productsPage.addProductToCart();
		productsPage.goToCart();

	}

	@Test(priority = 4)
	public void checkoutTest() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		loginPage.login("standard_user", "secret_sauce");

		productsPage.addProductToCart();
		productsPage.goToCart();

		Thread.sleep(3000);

		cartPage.clickCheckout();

		Thread.sleep(3000);

		checkoutPage.enterCheckoutDetails("Pankaj", "Vishwakarma", "226010");

		checkoutPage.finishCheckout();

		Thread.sleep(3000);

	}

}