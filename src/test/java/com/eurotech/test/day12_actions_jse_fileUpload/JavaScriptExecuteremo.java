package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuteremo {
    WebDriver driver;
    JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        jse = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void t_clickWithJSE() {
        driver.get("https://www.amazon.co.uk/");
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement germany = driver.findElement(By.linkText("Germany"));
        //germany.click();
        //ask to google --> how to click with jse
        //JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", germany);
    }

    @Test
    public void t_typeWithJSE() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example input"));
        String text = "B13 is here";
        //ask to google --> how to type(sendKeys) with JSE
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputBox);
    }

    @Test
    public void t_scrollDropAndUp() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.findElement(By.id("sp-cc-accept")).click();
        // ask to google--> how to scroll down in selenium with jse
        //jse.executeScript("window.scrollBy(0,1000)");
        for (int i = 0; i < 15; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,300)");
        }
        for (int i = 0; i < 15; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-300)");
        }
    }

    @Test
    public void t_scrollToElement() {
        driver.get("https://www.amazon.co.uk/");
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement germany = driver.findElement(By.linkText("Germany"));
        // ask to google--> how to scroll in to view with jse
        jse.executeScript("arguments[0].scrollIntoView(true);", germany);
        jse.executeScript("arguments[0].click();", germany);
    }
}