package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver initDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));
		
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
			
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		
		} else {
			throw new RuntimeException("Invalid browser: " + browser);
		}
		
		 driver.get().manage().window().maximize();
		 return driver.get();
		}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quitDriver() {
		if(driver.get() !=null) {
			driver.get().quit();
			driver.remove();
		}
	}

}