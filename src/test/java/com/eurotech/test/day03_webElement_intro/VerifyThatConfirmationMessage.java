package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        /**  Class Task
         // open Chrome browser
         // go to "http://eurotech.study/login"
         // click I understand button
         // enter email as "eurotech@gmail.com"
         // enter password as "Test12345!"
         // click to log in btn
         // verify that welcome message is "Welcome Teacher"
         */
        String email ="eurotech@gmail.com";
        String expectedMessage ="Welcome Teacher";
        String password ="Test12345!";
        // open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(password);
        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(2000);
        // verify that welcome message is "Welcome Teacher"
        WebElement welcomeMessage = driver.findElement(By.id("dashboard-p1"));

        String actualMessage = welcomeMessage.getText();
        if (actualMessage.equals(expectedMessage)){
            System.out.println("passed");
        }else System.out.println("failed..");


    }
}
