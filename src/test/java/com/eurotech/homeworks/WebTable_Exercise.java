package com.eurotech.homeworks;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable_Exercise {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Data-Table/index.html ");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void printTable() {
        WebElement table2 = driver.findElement(By.xpath("//div/table[@id='t02']"));
        System.out.println("table2.getText() = " + table2.getText());
        Assert.assertTrue(table2.getText().contains("Bob"));
    }

    @Test
    public void getAllHeaders() {
        List<WebElement> allHeaders = driver.findElements(By.xpath("//div/table[@id='t02']/tbody/tr[1]"));
        System.out.println("allHeaders.size() = " + allHeaders.size());
        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }
    }

    @Test
    public void testName() {
        List<WebElement> allRows = driver.findElements(By.xpath("//div/table[@id='t02']/tbody/tr"));
        System.out.println(allRows.size());
        for (WebElement header : allRows) {
            System.out.println("header.getText() = " + header.getText());
        }
    }
}
