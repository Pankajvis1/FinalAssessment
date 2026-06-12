package utilities;

import driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

	public static String captureScreenshot(String testName) {

		String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotPath = "screenshots/" + testName + "_" + time + ".png";

		try {
			File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

			File dest = new File(screenshotPath);
			Files.copy(src.toPath(), dest.toPath());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return screenshotPath;
	}
}