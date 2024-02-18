package com.eurotech.test.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicWebTables {
    WebDriver driver;

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
    public void dynamicTableTest() {
        driver.get("https://demoqa.com/webtables");
        WebElement aldenName = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[1]"));
        System.out.println("before click = " + aldenName.getText());
        WebElement lastname= driver.findElement(By.xpath("//div[text()='Last Name']"));
        lastname.click();
        System.out.println("after click = " + aldenName.getText());
        //Assert.assertEquals(aldenName.getText(),"Alden");

        String name= "Alden";
        WebElement valueInCell = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[text()='" + name + "']"));
        System.out.println("after click 2 = " + valueInCell.getText());

        Assert.assertEquals(valueInCell.getText(),name);

    }
    @Test
    public void testExtra() {
        driver.get("https://demoqa.com/webtables");
        WebElement secondRowFirstCell = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[1]"));
        System.out.println("before click = " + secondRowFirstCell.getText());
        WebElement lastname= driver.findElement(By.xpath("//div[text()='Last Name']"));
        lastname.click();
        System.out.println("after click = " + secondRowFirstCell.getText());
        Assert.assertEquals(secondRowFirstCell.getText(),"Kierra");
    }
}
