package com.eurotech.test.day19_review_and_xml_runner;

import com.eurotech.pages.*;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /*
T D19 TC01
        Login as a teacher
        verify that login is successful
        click on edit profile button
        verify that GitHub username  ....
        click on go back button
        verify that user's title is ....
     */
    LoginPage loginPage;
    DashboardPage dashboardPage;



    @Test
    public void t_userInfo(){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        ProfilePage profilePage = new ProfilePage();


        extentLogger= report.createTest("user info Verification ");


        extentLogger.info("go to url " + ConfigurationReader.get("url") + "Website");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("click understand button");
        loginPage.understandBtn.click();

        extentLogger.info("enter user email");
        loginPage.username.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("enter password");
        loginPage.password.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("click login button");
        loginPage.loginBtn.click();

        //1. way to verify log in successfully
        extentLogger.info("verify that log in is successfully");
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.welcomeMsg));
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/dashboard");

        extentLogger.info("click edit profile");
        dashboardPage.dashboardMenu("Edit Profile");

        String expectedGithubUserName="teacher23";
        WebElement valueTeacher = driver.findElement(By.id("editprofile-from-github-input"));
        BrowserUtils.scrollToElement(valueTeacher);
        extentLogger.info("Verify that github user name is " + expectedGithubUserName);
        String actualGithubUserName=profilePage.githubusername.getAttribute("value");
        System.out.println("actualGithubUserName = " + actualGithubUserName);
        Assert.assertEquals(actualGithubUserName,expectedGithubUserName);
        extentLogger.info("Click Go Back button");
        profilePage.goBackBtn.click();
        String expectedJobTitle="QA Test Engineer";
        extentLogger.info("verify that user's job title is "+ expectedJobTitle);
        String actaulJobTitle= dashboardPage.getJobTitle(expectedJobTitle);
        Assert.assertEquals(actaulJobTitle,expectedJobTitle);
        extentLogger.info("Passed");


    }


}
