package com.eurotech.test.day13_webTables;


import com.eurotech.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverTask {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }
    @Test
    public void hoverTask() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement imgUser1 = driver.findElement(By.xpath("(//img)[2]"));

        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        System.out.println("imgList.size() = " + imgList.size());

        for (int i = 2; i <= imgList.size(); i++) {
            String imgXpath = "(//img)[" + i + "]";
            System.out.println("imgXpath = " + imgXpath);
            WebElement img = driver.findElement(By.xpath(imgXpath));
            //WebElement img = driver.findElement(By.xpath("(//img)[" + i + "]"));

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textPath= "//h5[text()='name: user" + (i-1) + "']";
            System.out.println("textPath = " + textPath);
            WebElement text = driver.findElement(By.xpath(textPath));
            //WebElement text = driver.findElement(By.xpath("//h5[text()='name: user" + (i-1) + "']"));

            Assert.assertTrue(text.isDisplayed(),"Verify that user" + (i-1) + " is displayed");
        }
    }

}