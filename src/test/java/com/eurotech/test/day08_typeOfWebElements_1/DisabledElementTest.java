package com.eurotech.test.day08_typeOfWebElements_1;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElementTest {
    @Test
    public void t_disabledElement_isEnabled() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        WebElement disableElement = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(disableElement.isEnabled(),"Verify that element is NOT enable or element is disabled");

        //if we click the enable button it will be interactive
        WebElement enableBtn = driver.findElement(By.cssSelector("#input-example>button"));
        enableBtn.click();
        Thread.sleep(4000);
        Assert.assertTrue(disableElement.isEnabled(),"Verify that element is enabled");
        Thread.sleep(2000);
        driver.close();
    }
}
