package com.eurotech.test.day07_testNG_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task {
    /**  TestNG's annotations and assertions task
     -open Chrome browser
     -go to https://www.facebook.com/
     -enter fake username
     -enter fake password
     -click login button
     -verify that NOT login successfully with "Bu senin hesabın mı?" message.
     */
    WebDriver driver;
    @Test
    public void facebookLogin() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("absc@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("12345şy");
        driver.findElement(By.name("login")).click();
        String expectedMessage = "Bu senin hesabın mı?";
        String actualMessage= driver.findElement(By.className("_9kpn")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Verification of messages is failed.");
    }
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
