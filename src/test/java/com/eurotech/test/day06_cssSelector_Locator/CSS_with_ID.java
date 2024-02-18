package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_ID {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        //driver.findElement(By.xpath("//button[@id='rcc-confirm-button']")).click();
        //Accept cookies by cssSelector with ID --> #valueOfIdAttribute
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();
        //driver.findElement(By.id("rcc-confirm-butto")).click(); --> wrong located element
        //NoSuchElementException: no such element: Unable to locate element:
        // {"method":"css selector","selector":"#rcc\-confirm\-butto"}
        // That means Selenium works with cssSelector at the background

        //CSS Selector with ID -->  #valueOfIdAttribute
        WebElement userEmail= driver.findElement(By.cssSelector("#loginpage-input-email"));
        userEmail.sendKeys("CSS Selector with ID");

        //CSS Selector with TagName and ID -->  TagName#valueOfIdAttribute
        WebElement userPassword= driver.findElement(By.cssSelector("input#loginpage-form-pw-input"));
        userPassword.sendKeys("CSS Selector with TagName and ID");

        Thread.sleep(2000);
        driver.close();
    }
}
