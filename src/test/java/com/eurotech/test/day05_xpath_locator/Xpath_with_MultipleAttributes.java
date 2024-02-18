package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_MultipleAttributes {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.xpath("//button[@id='rcc-confirm-button']")).click();

        // multiple attribute 1st way -LOGICAL AND
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='email'][@placeholder='Email Address']"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        // multiple attribute 2nd way -LOGICAL AND
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@type='password' and @placeholder='Password']"));
        passwordInputBox.sendKeys("Test12345!");

        // multiple attribute 3rd way -LOGICAL OR
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit' or @value='Login']"));
        loginBtn.click();

        Thread.sleep(2000);
        driver.close();
    }
}