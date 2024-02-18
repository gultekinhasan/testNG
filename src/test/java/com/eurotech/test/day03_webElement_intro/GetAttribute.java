package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys("eurotech@gmail.com");
        WebElement passwordInputBox = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBox.sendKeys("Test12345!");
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));

        String emailInputBox_valueAttribute = emailInputBox.getAttribute("value");
        System.out.println("emailInputBox_valueAttribute = " + emailInputBox_valueAttribute);

        String passwordInputBox_valueAttribute = passwordInputBox.getAttribute("value");
        System.out.println("passwordInputBox_valueAttribute = " + passwordInputBox_valueAttribute);

        String emailInputBox_placeholderAttribute = emailInputBox.getAttribute("placeholder");
        System.out.println("emailInputBox_placeholderAttribute = " + emailInputBox_placeholderAttribute);

        String passwordInputBox_minlengthAttribute= passwordInputBox.getAttribute("minlength");
        System.out.println("passwordInputBox_minlengthAttribute = " + passwordInputBox_minlengthAttribute);

        String loginBtn_classAttribute = loginBtn.getAttribute("class");
        System.out.println("loginBtn_classAttribute = " + loginBtn_classAttribute);

        String loginBtn_typeAttribute = loginBtn.getAttribute("type");
        System.out.println("loginBtn_typeAttribute = " + loginBtn_typeAttribute);


        driver.close();
    }
}
