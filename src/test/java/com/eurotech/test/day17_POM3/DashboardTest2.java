package com.eurotech.test.day17_POM3;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.PostPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PostPage postPage;
    @Test
    public void verifyList() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        /** Class Task - Duration: 13min
         go to "http://92.205.106.232/login"
         Login with teacher credentials
         Verify login is successful
         Verify following menu
         - Edit Profile
         - Add Experience
         - Add Education
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMsg.getText(),"Welcome Teacher");
        BrowserUtils.waitFor(1);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Edit Profile");
        expectedList.add("Add Experience");
        expectedList.add("Add Education");
        System.out.println("expectedList = " + expectedList);
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.altMenu), expectedList);
    }

    @Test
    public void testLogout() {
        /** Class Task - Duration: 12min
         go to "http://92.205.106.232/login"
         Login with teacher credentials
         Verify login is successful
         Navigate to My Posts submenu under My Account and verify that submit button is visible
         Navigate to Logout submenu under My Account and verify that logout successful
         */
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        postPage = new PostPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMsg.getText(),"Welcome Teacher");
        BrowserUtils.waitFor(1);
        dashboardPage.dashboardMenu("My Posts");
        BrowserUtils.waitFor(3);
        Assert.assertTrue(postPage.submitBtn.isDisplayed());
        dashboardPage.dashboardMenu("Logout");
        Assert.assertTrue(loginPage.logoutCheck.isDisplayed());
    }
    @Test
    public void postComment() {
        /**
         Go to http://92.205.106.232/login
         Login with student credentials
         Navigate to My Posts submenu under My Account
         Fill the title and post area
         Click submit button
         Verify that post saved successfully
         */
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        postPage = new PostPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsStudent();
        Assert.assertEquals(dashboardPage.welcomeMsg.getText(), "Welcome Jack");
        dashboardPage.dashboardMenu("My Posts");
        String titleText = "POM";
        String postText = "Page Object Model, also known as POM, " +
                "is a design pattern in Selenium that creates an object " +
                "repository for storing all web elements.";

//        postPage.titleInput.sendKeys(titleText);
//        postPage.postInput.sendKeys(postText);
//        postPage.submitBtn.click();
//        Assert.assertEquals(postPage.postCreatedMsg.getText(), "Post Created");

        postPage.postComment(titleText,postText);
    }

}
