package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_VisibleText {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        //1st way
        WebElement signInText = driver.findElement(By.xpath("//h1[text()?'Sign In']"));
        System.out.println("signInText = " + signInText);
        //2nd way
        WebElement accountText = driver.findElement(By.xpath("//*[.=' Sign Into Your Account']"));
        System.out.println("accountText = " + accountText);

        driver.close();

    }
}
