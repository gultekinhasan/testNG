package com.eurotech.homeworks;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class hw_8 {
    /** HW D10-TC2
     *  go to https://demoqa.com/alerts
     *  practice with all JS alerts
     *  Verify all result are as expected for the JS alerts
     */
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
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
            //Thread.sleep(3000);
        driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("alertButton")).click();
        //Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String usda = alert.getText();
        System.out.println("usda = " + usda);
        Thread.sleep(2000);
        Assert.assertEquals(usda,"You clicked a button","Test failed");
        alert.accept();
        Thread.sleep(3000);

        WebElement click2 = driver.findElement(By.id("timerAlertButton"));
        click2.click();
        Thread.sleep(6000);
        String usda2 = alert.getText();
        System.out.println("usda2 = " + usda2);
        Assert.assertEquals(usda2,"This alert appeared after 5 seconds","Test failed");
        alert.accept();
        Thread.sleep(2400);

        WebElement click3 = driver.findElement(By.id("confirmButton"));
        click3.click();
        String usda3 = alert.getText();
        System.out.println("usda3 = " + usda3);
        Assert.assertEquals(usda3,"Do you confirm action?","Test failed");
        alert.accept();
        System.out.println("driver.findElement(By.id(\"confirmResult\")).getText() = " + driver.findElement(By.id("confirmResult")).getText());
        Thread.sleep(1500);

        WebElement click4 = driver.findElement(By.id("promtButton"));
        click4.click();
        alert.sendKeys("Hasan");
        Thread.sleep(2400);
        alert.accept();
        System.out.println(driver.findElement(By.id("promptResult")).getText());


    }
}