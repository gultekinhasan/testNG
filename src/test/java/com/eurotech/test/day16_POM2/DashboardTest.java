package com.eurotech.test.day16_POM2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest extends TestBase {
    /**
     * Class Task
     * Go to http://92.205.106.232/login
     * Login with teacher credentials
     * Get the text of the welcome message
     * Then verify following menu
     Developers
     All Posts
     My Account
     */
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void dashboardMenu() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedMessage = "Welcome Teacher";
        String actualMessage = dashboardPage.welcomeMsg.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");
        System.out.println("expectedList = " + expectedList);

        // 1st way
        ArrayList<String> actualList= new ArrayList<>();
        List<WebElement> dashboardMenu = dashboardPage.menuList;
        for (WebElement menu : dashboardMenu) {
            //System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(actualList,expectedList);

        // 2nd way
        List<String> actualList2 = BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualList2,expectedList);

        //3rd way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.menuList),expectedList);

    }

    @Test
    public void testNavigate() {
        /** Class Task - Homework
         *  Go to http://92.205.106.232/login
         *  Login with teacher credentials
         *  Navigate to All Posts menu and verify url is http://92.205.106.232/posts
         *  Navigate to Developers menu and verify url is http://92.205.106.232/profiles
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMsg.getText(),"Welcome Teacher");
        dashboardPage.allPosts.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/posts");
        dashboardPage.developers.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/profiles");
    }

    @Test
    public void testNavigate2() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMsg.getText(),"Welcome Teacher");
        dashboardPage.dashboardMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/posts");
        dashboardPage.dashboardMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/profiles");
    }
    @Test
    public void testNavigate3() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMsg.getText(),"Welcome Teacher");
        BrowserUtils.waitFor(1);
        //BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.dashboardMenu("My Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/posts");
        //BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.dashboardMenu("Logout");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
