package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_AttributeAndValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.xpath("//button[@id='rcc-confirm-button']")).click();

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='name']"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.xpath("//*[@type='password']"));
        passwordInputBox.sendKeys("Test12345!");

        WebElement loginBtn = driver.findElement(By.xpath("//*[@*='btn btn-primary']"));
        loginBtn.click();

        Thread.sleep(2000);
        driver.close();

    }
}
