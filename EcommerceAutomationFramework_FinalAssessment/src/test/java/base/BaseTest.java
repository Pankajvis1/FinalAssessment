package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import driver.DriverFactory;

public class BaseTest {
	
	protected WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(@Optional("chrome") String browser){
		driver = DriverFactory.initDriver(browser);
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
