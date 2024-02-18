package com.eurotech.test.day15_POM1;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    /** Class Task - 10 min
     * go to url http://92.205.106.232/login
     * enter valid username
     * enter invalid password
     * click login button
     * verify warning message is displayed
     */
    LoginPage loginPage;
    @Test
    public void wrongPassword() {
        loginPage= new LoginPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.login(ConfigurationReader.get("usernameTeacher"),"wrongPassword");
        String expectedMsg= "Invalid Credentials!";
        String actualMsg= loginPage.errorMessage.getText();
        Assert.assertEquals(actualMsg,expectedMsg);
    }
    @Test
    public void wrongUsername() {
        loginPage= new LoginPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.login("eurotech@gmail.co",ConfigurationReader.get("passwordTeacher"));
        String expectedMsg= "Invalid Credentials!";
        String actualMsg= loginPage.errorMessage.getText();
        Assert.assertEquals(actualMsg,expectedMsg);
    }
    @Test
    public void wrongUsername2() {
        loginPage= new LoginPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.login("eurotech@gmail",ConfigurationReader.get("passwordTeacher"));
        String expectedMsg= "Please include a valid email!";
        String actualMsg= loginPage.errorMessage.getText();
        Assert.assertEquals(actualMsg,expectedMsg);
    }
}
