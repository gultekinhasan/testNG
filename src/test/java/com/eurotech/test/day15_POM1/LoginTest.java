package com.eurotech.test.day15_POM1;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    /**
     * Class Task
     * go to url http://eurotech.study/login
     * enter username
     * enter password
     * click login button
     */
    @Test
    public void loginTest() {
        driver.get(ConfigurationReader.get("url"));
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();
        WebElement userName = driver.findElement(By.id("loginpage-input-email"));
        WebElement password = driver.findElement(By.id("loginpage-form-pw-input"));
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));

        userName.sendKeys(ConfigurationReader.get("usernameTeacher"));
        password.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginBtn.click();
    }
}
