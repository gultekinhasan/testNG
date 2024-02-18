package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_EndsWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        //Accept cookies by cssSelector with ID --> #valueOfIdAttribute
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //We can NOT use ends-with in xpath

        //CSS Selector with ends-with --> $=ends-with --> [attribute$='value']
        WebElement userEmail= driver.findElement(By.cssSelector("[placeholder$='Address']"));
        userEmail.sendKeys("eurotech@gmail.com");
        Thread.sleep(1000);
        //CSS Selector with tagName and ends-with --> $=ends-with --> tagName[attribute$='value']
        WebElement userPassword= driver.findElement(By.cssSelector("input[id$='pw-input']"));
        userPassword.sendKeys("Test12345!");

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class$='btn-primary']")).click();
        Thread.sleep(1000);
        driver.close();
    }
}
