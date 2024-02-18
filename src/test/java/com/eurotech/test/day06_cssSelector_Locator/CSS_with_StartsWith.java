package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_StartsWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        //Accept cookies by cssSelector with ID --> #valueOfIdAttribute
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //starts with xpath--> //input[starts-with(@placeholder,'Email')]

        //CSS Selector with starts-with -->  [attribute^='value']
        WebElement userEmail= driver.findElement(By.cssSelector("[placeholder^='Email']"));
        userEmail.sendKeys("eurotech@gmail.com");
        Thread.sleep(1000);
        //CSS Selector with tagName and starts-with -->  tagName[attribute^='value']
        WebElement userPassword= driver.findElement(By.cssSelector("input[type^='pass']"));
        userPassword.sendKeys("Test12345!");

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class^='btn']")).click();
        Thread.sleep(1000);
        Thread.sleep(2000);
        driver.close();
    }
}
