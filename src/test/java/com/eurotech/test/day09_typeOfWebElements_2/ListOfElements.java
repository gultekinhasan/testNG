package com.eurotech.test.day09_typeOfWebElements_2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void t_ListOfElements() {
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));
        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize =44;
        int actualSize=menuList.size();
        Assert.assertEquals(expectedSize,actualSize,"verify that menu size is 44");
        System.out.println("menuList.get(7).getText() = " + menuList.get(7).getText());

        //element is not clickable
        //elements.get(0).click();
        
        //print all elements * shortcut "iter" for -> foreach loop
        for (WebElement element : menuList) {
            System.out.println(element.getText());
        }
        
    }

    @Test
    public void t_demQA_list() {
        /** D9-CT1
         * go to https://demoqa.com/elements website
         * verify that 9 elements are there
         */
        driver.get("https://demoqa.com/elements");
        //List<WebElement> elementsList
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.close();
    }
}
