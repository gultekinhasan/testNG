package com.eurotech.test.day11_waits_in_selenium;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait_example {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,20);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void t_explicitWait_visibilityOf() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();
      //  WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement hello = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(hello));
        System.out.println("hello.getText() = " + hello.getText());
        Assert.assertEquals(hello.getText(),"Hello World!");
    }

    @Test
    public void t_explicitWait_clickable() {
        //WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("B13 is here");

        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's enabled!");

    }
}
