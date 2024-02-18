package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_Class {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        //Accept cookies by cssSelector with ID --> #valueOfIdAttribute
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //CSS Selector with ID -->  #valueOfIdAttribute
        WebElement userEmail= driver.findElement(By.cssSelector("#loginpage-input-email"));
        userEmail.sendKeys("CSS Selector with ID");

        //CSS Selector with TagName and ID -->  TagName#valueOfIdAttribute
        WebElement userPassword= driver.findElement(By.cssSelector("input#loginpage-form-pw-input"));
        userPassword.sendKeys("CSS Selector with TagName and ID");

        WebElement warningMsg = driver.findElement(By.cssSelector(".my-1"));
        System.out.println("warningMsg = " + warningMsg.getText());

        //CSS Selector with valueOfClass (with space) [put . for each space]
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        //CSS Selector with TagName and valueOfClass (with space) [put . for each space]
        //driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
