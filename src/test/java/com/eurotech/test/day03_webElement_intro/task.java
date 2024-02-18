package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class task {
    public static void main(String[] args) throws InterruptedException {
        /**  Class Task / 5 min
         open Chrome browser
         go to "http://eurotech.study/login"
         click I understand button
         enter email as "eurotech@gmail.com"
         enter password as "Test12345!"
         click to log in btn
         verify that "Dashboard" text is visible on the web page
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys("eurotech@gmail.com");
        WebElement passwordInputBox = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBox.sendKeys("Test12345!");
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();
        Thread.sleep(2000);
        String expectedText ="Dashboard";
        WebElement actual = driver.findElement(By.id("dashboard-h1"));
        String actualText=actual.getText();

        if (expectedText.equals(actualText)){
            System.out.println("passed");
        }else System.out.println("failed");
        driver.close();
    }
}
