package com.eurotech.test.day08_typeOfWebElements_1;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void t_attribute() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement userNameInputBox = driver.findElement(By.id("userName"));
        System.out.println("userNameInputBox.getAttribute(\"id\") = " + userNameInputBox.getAttribute("id"));
        System.out.println("userNameInputBox.getAttribute(\"type\") = " + userNameInputBox.getAttribute("type"));
        System.out.println("userNameInputBox.getAttribute(\"autocomplete\") = " + userNameInputBox.getAttribute("autocomplete"));
        System.out.println("userNameInputBox.getAttribute(\"placeholder\") = " + userNameInputBox.getAttribute("placeholder"));
        System.out.println("userNameInputBox.getAttribute(\"class\") = " + userNameInputBox.getAttribute("class"));

        System.out.println("userNameInputBox.getAttribute(\"outerHTML\") = " + userNameInputBox.getAttribute("outerHTML"));
        System.out.println("userNameInputBox.getAttribute(\"innerHTML\") = " + userNameInputBox.getAttribute("innerHTML"));//empty

        Thread.sleep(2000);
        driver.close();

    }

}

