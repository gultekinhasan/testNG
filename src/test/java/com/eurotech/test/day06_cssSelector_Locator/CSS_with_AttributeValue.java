package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_AttributeValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        //Accept cookies by cssSelector with ID --> #valueOfIdAttribute
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //CSS Selector with Attribute and Value -->  [attribute='value']
        WebElement userEmail= driver.findElement(By.cssSelector("[type='email']"));
        userEmail.sendKeys("eurotech@gmail.com");

        //CSS Selector with TagName and Attribute and Value -->  tagName[attribute='value']
        WebElement userPassword= driver.findElement(By.cssSelector("input[type='password']"));
        userPassword.sendKeys("Test12345!");

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();


        Thread.sleep(2000);
        driver.close();
    }
}
