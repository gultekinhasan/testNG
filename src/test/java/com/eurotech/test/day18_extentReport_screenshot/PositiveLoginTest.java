package com.eurotech.test.day18_extentReport_screenshot;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    LoginPage loginPage;

    DashboardPage dashboardPage;

    @Test
    public void loginWithStudentTest() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        extentLogger= report.createTest("Positive Login with student Credentials");

        extentLogger.info("navigate to "+ ConfigurationReader.get("url")+" website");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("login as Student");
        loginPage.loginAsStudent();

        extentLogger.info("Verify that Student logged in successfully");
        Assert.assertEquals(dashboardPage.welcomeMsg.getText(),"Welcome Jack");

        extentLogger.pass("Test Passed");
    }
}
