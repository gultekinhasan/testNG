package com.eurotech.test.day15_POM1;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    /** Class Task - 5 min

     go to url http://eurotech.study/dashboard
     enter valid username
     enter valid password
     click login button
     verify url is
     */
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void loginTest() {
     driver.get(ConfigurationReader.get("url"));
     loginPage.understandBtn.click();
     loginPage.username.sendKeys(ConfigurationReader.get("usernameTeacher"));
     loginPage.password.sendKeys(ConfigurationReader.get("passwordTeacher"));
     loginPage.loginBtn.click();

        // wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        BrowserUtils.waitForVisibility(dashboardPage.dashboardText,5);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/dashboard");
    }
    @Test
    public void loginWithTeacherCredentialsMethod() {
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/dashboard");
    }
    @Test
    public void loginWithStudentCredentialsMethod() {
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsStudent();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/dashboard");
    }
}
