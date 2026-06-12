package listeners;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                ExtentManager.getExtent()
                        .createTest(result.getMethod().getMethodName());

        test.set(extentTest);
        test.get().info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.captureScreenshot(
                result.getMethod().getMethodName());

        test.get().fail(result.getThrowable());

        try {
            test.get().addScreenCaptureFromPath("../" + path);
        } catch (Exception e) {
            test.get().warning("Screenshot not attached");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtent().flush();
    }
}