package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_MultipleElementIndex {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.xpath("//button[@id='rcc-confirm-button']")).click();

        //index in same parent
        WebElement emailInputBox = driver.findElement(By.xpath("//form/div[1]/input"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.xpath("//div[starts-with(@id,'login')][2]/input"));
        passwordInputBox.sendKeys("Test12345!");

        // index with different parent - WE HAVE TO WRITE SYNTAX INSIDE () AFTER THAT WE CAN DECLARE INDEX NUMBER INSIDE []
        WebElement loginBtn = driver.findElement(By.xpath("(//input[starts-with(@id,'login')])[3]"));
        loginBtn.click();

        Thread.sleep(2000);
        driver.close();
    }
}
