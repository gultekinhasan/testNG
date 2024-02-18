package com.eurotech.test.day10_typeOfWebElements_3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUp_and_Alerts {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    public void t_html_popUp() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=e97a6");

        driver.findElement(By.xpath("//span[.='Confirm']")).click();

        driver.findElement(By.xpath("//span[.='Yes']")).click();

        Thread.sleep(1000);
        String expectedMessage="You have accepted";
        String actualMessage = driver.findElement(By.xpath("//p[.='You have accepted']")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void t_js_Alerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);

        WebElement resultText = driver.findElement(By.id("result"));

        //click "Click for JS Alert" button
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        //switch to JS alert pop up
        Alert alert= driver.switchTo().alert();
        Thread.sleep(2000);
        //click to OK Button
        alert.accept();

        Thread.sleep(2000);
        System.out.println("resultText = " + resultText.getText());

        // Click for JS Confirm
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        //click to cancel
        alert.dismiss();

        Thread.sleep(2000);
        System.out.println("resultText = " + resultText.getText());

        //Click for JS Prompt
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        //get text to JS alert
        String alertText = alert.getText();
        System.out.println("alertText = " + alertText);
        //senKeys to JS prompt
        alert.sendKeys("Eurotech B13 is here and we are doing \"" + alertText + "\" example");
        Thread.sleep(2000);
        alert.accept();
        System.out.println("resultText = " + resultText.getText());

        /** HW D10-TC1
         *  for the above test
         *  Verify all results are as expected for the JS alerts
         */

        /** HW D10-TC2
         *  go to https://demoqa.com/alerts
         *  practice with all JS alerts
         *  Verify all result are as expected for the JS alerts
         */
    }
}
