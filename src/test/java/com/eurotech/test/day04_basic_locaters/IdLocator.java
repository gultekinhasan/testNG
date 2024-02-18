package com.eurotech.test.day04_basic_locaters;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        WebElement inputUserName = driver.findElement(By.id("userName"));
        //  inputUserName.sendKeys("Hasan");
        Faker faker = new Faker();
        inputUserName.sendKeys(faker.name().fullName());
        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));
       // inputUserEmail.sendKeys("Hasan@eurotech.study");
        inputUserEmail.sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);
        driver.close();


    }
}
