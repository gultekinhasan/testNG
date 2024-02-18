package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        /**  Class Task
         // open Chrome browser
         // go to "http://eurotech.study/login"
         // click I understand button
         // enter email as "eurotech@gmail.com"
         // enter password as "Test12345!"
         // click to log in btn
         // verify that Url is changed to "http://eurotech.study/dashboard"
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(2000);
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys("eurotech@gmail.com");
        Thread.sleep(2000);

        WebElement passwordInputBox = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBox.sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(2000);

        // verify that Url is changed to "http://eurotech.study/dashboard"
        String expectedUrl = "http://eurotech.study/dashboard";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed!!!");
        driver.close();
    }
}
