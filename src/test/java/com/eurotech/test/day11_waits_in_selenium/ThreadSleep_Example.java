package com.eurotech.test.day11_waits_in_selenium;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleep_Example {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void t_ThreadSleep() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startBtn = driver.findElement(By.cssSelector("#start button"));
        startBtn.click();
        Thread.sleep(5000);
        WebElement hello = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        Assert.assertEquals(hello.getText(),"Hello World!");
    }
}
