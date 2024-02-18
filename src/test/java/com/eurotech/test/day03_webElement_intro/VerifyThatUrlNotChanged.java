package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /**  Class Task
         // open Chrome browser
         // go to "http://eurotech.study/login"
         // click I understand button
         // enter an email address
         // click to log in btn
         // verify that Url is not changed
         */
        //open a Chrome Browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // go to "http://eurotech.study/login"
        driver.get("http://eurotech.study/login");
        // click I understand button
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        // click I understand button
        // understandBtn.click();
        // lazy way to click I understand button
        driver.findElement(By.id("rcc-confirm-button")).click();
        //enter an email address - eurotech@gmail.com
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys("eurotech@gmail.com");
        // click to log in btn
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();
        // lazy way to click to log in btn
        //driver.findElement(By.id("loginpage-form-btn")).click();
        // verify that Url is not changed
        String expectedUrl = "http://eurotech.study/login";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Passed");
        }else System.out.println("Failed");

        Thread.sleep(1000);
        driver.close();
    }
}
