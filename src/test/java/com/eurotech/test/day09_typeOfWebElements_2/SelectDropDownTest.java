package com.eurotech.test.day09_typeOfWebElements_2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void t_getOptions() {
        WebElement colorDropDown = driver.findElement(By.id("oldSelectMenu"));
        //create select object by passing that elements as a constructor
        Select color = new Select(colorDropDown);
        List<WebElement> colorList = color.getOptions();
        System.out.println("colorList.size() = " + colorList.size());
        Assert.assertEquals(colorList.size(),11);
        for (WebElement element : colorList) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void t_selectByVisibleText() throws InterruptedException {
        WebElement colorDropDown = driver.findElement(By.id("oldSelectMenu"));
        Select color = new Select(colorDropDown);
        String expectedColor="Red";
        String actualColor=color.getFirstSelectedOption().getText();
        System.out.println("actualColor = " + actualColor);
        Assert.assertEquals(expectedColor,actualColor);

        //how to select option from dropDown
        //we can click each of element by 3 way

        //1. select using visible text
        Thread.sleep(2000);
        color.selectByVisibleText("Yellow");
        expectedColor="Yellow";
        actualColor=color.getFirstSelectedOption().getText();
        System.out.println("actualColor = " + actualColor);
        Assert.assertEquals(expectedColor,actualColor);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
