package com.eurotech.test.day08_typeOfWebElements_1;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class RadioButtonTest {
    @Test
    public void t_radioBtn() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();
        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));
        WebElement legumesRadio= driver.findElement(By.xpath("//div[text()='Legumes']/../input"));

        System.out.println("vegetablesRadio.isSelected() = " + vegetablesRadio.isSelected());
        Assert.assertTrue(vegetablesRadio.isSelected(),"Verify that vegetables radio is selected");
        Assert.assertFalse(legumesRadio.isSelected(),"Verify that legumes radio is NOT selected");

        WebElement legume= driver.findElement(By.xpath("//div[text()='Legumes']/../div[1]"));
        Thread.sleep(2000);
        //legumesRadio.click();
        legume.click();
        Assert.assertTrue(legumesRadio.isSelected(),"Verify that legume radio is selected");
        Assert.assertFalse(vegetablesRadio.isSelected(),"Verify that vegetables radio is NOT selected");

        Thread.sleep(2000);
        driver.close();
    }
}
