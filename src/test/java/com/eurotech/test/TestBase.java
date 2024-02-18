package com.eurotech.test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest() {
        /** We add our report syntax in this BeforeTest Method, so we can have the report according to executed tests.
         If we execute more than 1 test, that means our report will include all test results by BeforeTest annotation. */
        // This will initialize the ExtentReports Class
        report = new ExtentReports();
        // Create a report path --> how can we find our project dynamically
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";
        // Initialize the HTML report  with the report path
        htmlReporter = new ExtentHtmlReporter(path);
        // Attach the HTML report to the report object
        report.attachReporter(htmlReporter);
        // We need to give a title for report
        htmlReporter.config().setReportName("Batch13 Smoke Suit");
        // Set environment information --> Test name, Tester name, Browser, Test Steps, Test Data...
        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Hasan");
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        //driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterTest
    public void tearDownTest() {
        // This is when the report is actually created
        report.flush();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        // If test is failed
        if (result.getStatus() == ITestResult.FAILURE) {
            // Record the name of the failed test
            extentLogger.fail(result.getName());

            // Take the screenshot and return its location
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            // Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            // Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }
        Thread.sleep(3000);
        Driver.closeDriver();
    }
}
