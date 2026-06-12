package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getExtent() {

		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");

			spark.config().setDocumentTitle("SauceDemo Automation Report");
			spark.config().setReportName("Cross Browser Report");

			extent = new ExtentReports();
			extent.attachReporter(spark);

			extent.setSystemInfo("Project", "SauceDemo Automation");
			extent.setSystemInfo("Tester", "Pankaj");
		}

		return extent;
	}
}