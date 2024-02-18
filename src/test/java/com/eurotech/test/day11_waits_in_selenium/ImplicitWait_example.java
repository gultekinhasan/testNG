package com.eurotech.test.day11_waits_in_selenium;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait_example {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    driver.close();
    }

    @Test
    public void testName() {
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove_Btn = driver.findElement(By.cssSelector("#checkbox-example button"));
        remove_Btn.click();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's gone!");

    }
}
