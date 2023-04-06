package extentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ExtentTestNGITestListener implements ITestListener {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public synchronized void onStart(ITestContext context) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}

	public synchronized void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
		test.set(extentTest);
	}

	public synchronized void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test passed");
	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getName());
		test.get().fail(result.getThrowable());
	}

	public synchronized void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test skipped");
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Do nothing
	}

	public synchronized void handleTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());

		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");

		if (driver == null) {
			System.out.println("WebDriver instance is null. Cannot capture screenshot.");
			return;
		}

		if (driver != null) {
			String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
			try {
				test.get().fail("Screenshot",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	private String captureScreenshot(WebDriver driver, String screenshotName) {
		System.out.println("Capturing screenshot: " + screenshotName);
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = "screenshots/" + screenshotName + "_" + timestamp + ".png";

		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(destination));
			System.out.println("Screenshot captured: " + destination);
			return destination;
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Screenshot could not be captured.");
		return null;

	}




}