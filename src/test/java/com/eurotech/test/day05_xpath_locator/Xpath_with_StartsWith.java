package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_StartsWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement emailInputBox = driver.findElement(By.xpath("//input[starts-with(@placeholder,'Email')]"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        // ends-with method in Xpath does NOT work with chrome, firefox, edge...
        // it works with only Chrome version 1.0
        // //tagName[ends-with(@attribute,'Value')]

        Thread.sleep(2000);
        driver.close();
    }
}
