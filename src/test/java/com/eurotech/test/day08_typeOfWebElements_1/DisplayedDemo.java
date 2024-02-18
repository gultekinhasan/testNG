package com.eurotech.test.day08_typeOfWebElements_1;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void t1_isDisplayed() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement hello = driver.findElement(By.xpath("//*[.='Hello World!']"));
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());// false because its not visible now
        Assert.assertFalse(hello.isDisplayed(),"Verify that element is not displayed");
        WebElement startBtn = driver.findElement(By.cssSelector("#start>button"));
        startBtn.click();
        Thread.sleep(6000);
        Assert.assertTrue(hello.isDisplayed());
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testTask() {

    }
}
