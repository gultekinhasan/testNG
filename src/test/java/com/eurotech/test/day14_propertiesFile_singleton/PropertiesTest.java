package com.eurotech.test.day14_propertiesFile_singleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void testProperties() {
        String usedBrowser = ConfigurationReader.get("browser");
        System.out.println("usedBrowser = " + usedBrowser);

        String usedUrl = ConfigurationReader.get("url");
        System.out.println("usedUrl = " + usedUrl);
    }

    @Test
    public void openBrowserUsingConfigurationReader() {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER);

    }

    @Test
    public void testSingleTon() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver =WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.id("sp-cc-accept")).click();
    }
}
