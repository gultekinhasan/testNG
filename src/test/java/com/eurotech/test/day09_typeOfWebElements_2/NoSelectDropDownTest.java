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

public class NoSelectDropDownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void t_noSelectDropDown() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        driver.findElement(By.id("btnCookie")).click();
        WebElement dropDownBtn = driver.findElement(By.xpath("(//div[@class='o-slbtn'])[8]"));
        dropDownBtn.click();

        Thread.sleep(1000);
        List<WebElement> dropDownList = driver.findElements(By.cssSelector(".o-igit"));
        System.out.println("dropDownList.size() = " + dropDownList.size());
        Thread.sleep(1000);
        Assert.assertEquals(dropDownList.size(),25);
        for (WebElement element : dropDownList) {
            System.out.println("element.getText() = " + element.getText());
        }
        String actualText=dropDownList.get(3).getText();
        String expectedText="Banana";
        System.out.println("actualText = " + actualText);
        Assert.assertEquals(actualText,expectedText);
        String expectedSelectedElem =dropDownList.get(4).getText();
        dropDownList.get(4).click();

    }
}
