package com.eurotech.test.day04_basic_locaters;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeWork {
    public static void main(String[] args) throws InterruptedException {
        Faker faker=new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();
        WebElement acceptAllBtn = driver.findElement(By.id("accept-cookie-notification"));
        acceptAllBtn.click();
        Thread.sleep(2000);
        WebElement fullNameBtn = driver.findElement(By.name("user[full_name]"));
        WebElement businessEmailBtn = driver.findElement(By.name("user[email]"));
        WebElement passwordBtn = driver.findElement(By.id("user_password"));
        WebElement termsAndConditionsBtn = driver.findElement(By.name("terms_and_conditions"));
        fullNameBtn.sendKeys(faker.name().firstName()+" "+ faker.name().lastName());
        businessEmailBtn.sendKeys(faker.internet().emailAddress());
        passwordBtn.sendKeys(faker.internet().password(6,12));
        termsAndConditionsBtn.click();
        Thread.sleep(2000);
        driver.close();
    }
}
