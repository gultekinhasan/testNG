package com.eurotech.test.day02_webDriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/");
        Thread.sleep(2000);
        driver.close();

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/");
        String expectedTitle = "DevEx";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("passed");
        }else System.out.println("failed");



    }
}
