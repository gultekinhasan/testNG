package com.eurotech.test.day08_typeOfWebElements_1;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    @Test
    public void t_checkBox_isSelected() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("//form/input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//form/input[2]"));
        checkBox2.click();
        Thread.sleep(1000);
        Assert.assertTrue(checkBox2.isSelected(),"verify that the checkbox2 is selected ");
        Assert.assertFalse(checkBox1.isSelected(),"verify that the checkbox1 is Not selected");
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void t_demoQa_checkBox_isSelected() throws InterruptedException {
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement sports= driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement reading= driver.findElement(By.id("hobbies-checkbox-2"));
        WebElement music= driver.findElement(By.id("hobbies-checkbox-3"));

        Assert.assertFalse(sports.isSelected());
        Assert.assertFalse(reading.isSelected());
        Assert.assertFalse(music.isSelected());

        /** D8-CT1
         * complete th task
         * click all the checkbox
         * then assert that is selected or not
         */


        Thread.sleep(2000);
        driver.close();
    }
}
