package com.eurotech.test.day04_basic_locaters;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("eurotech@gmail.com");
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(2000);

        WebElement experiences = driver.findElement(By.tagName("h2"));
        String experiencesText = experiences.getText();
        System.out.println("experiencesText = " + experiencesText);

        /**Class Task
         * go to "http://the-internet.herokuapp.com/inputs"
         * print "Inputs" and "Number" keys using tagName locator
         */
        driver.get("http://the-internet.herokuapp.com/inputs");
        System.out.println("driver.findElement(By.tagName(\"h3\")).getText() = " + driver.findElement(By.tagName("h3")).getText());
        System.out.println("driver.findElement(By.tagName(\"p\")).getText() = " + driver.findElement(By.tagName("p")).getText());


        //driver.close();


    }
}
