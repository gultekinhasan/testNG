package com.eurotech.test.day14_propertiesFile_singleton;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonReview  extends TestBase {
    @Test
    public void singletonReview() {
        //WebDriver driver1 = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        //WebDriver driver2 = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        WebDriver driver1 = Driver.get();
        WebDriver driver2 = Driver.get();
        driver1.get("https://www.google.com");
        driver2.findElement(By.id("APjFqb")).sendKeys("testNG");
    }
}
