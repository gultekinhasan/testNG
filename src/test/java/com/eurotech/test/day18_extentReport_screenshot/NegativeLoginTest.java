package com.eurotech.test.day18_extentReport_screenshot;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage;

    @Test
    public void wrongUsername() {
        loginPage = new LoginPage();
        extentLogger = report.createTest("Wrong UserName Test");
        extentLogger.info("go to url " + ConfigurationReader.get("url") + "Website");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Click Understand Button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter Invalid Username");
        loginPage.username.sendKeys("wrongUser@wrong.com");

        extentLogger.info("Enter Valid Password");
        loginPage.password.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click Login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify user should NOT be able to login");
        Assert.assertEquals(loginPage.errorMessage.getText(), "Invalid Credentials!!");

        extentLogger.pass("Test Passed");
    }
    @Test
    public void wrongPassword() {
        loginPage = new LoginPage();
        extentLogger = report.createTest("Wrong passWord Test");
        extentLogger.info("go to url " + ConfigurationReader.get("url") + "Website");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Click Understand Button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter Valid Username");
        loginPage.username.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter Invalid Password");
        loginPage.password.sendKeys("wrongPass");

        extentLogger.info("Click Login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify user should NOT be able to login");
        Assert.assertEquals(loginPage.errorMessage.getText(), "Invalid Credentials!");

        extentLogger.pass("Test Passed");
    }
}
