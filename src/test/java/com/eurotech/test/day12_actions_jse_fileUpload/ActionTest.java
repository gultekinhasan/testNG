package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        actions= new Actions(driver);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
            Thread.sleep(2000);
            driver.close();
    }
    @Test
    public void t_hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));
        //img1.click();
        //Actions-> class that contains all the user interactions
        Thread.sleep(2000);
        //.moveToElement(img1) -> move your mouse to the web element(hover over)
        //.perform(); -> perform the action, complete the action
        actions.moveToElement(img1).perform();
        WebElement viewProfile1 = driver.findElement(By.linkText("View profile"));
        System.out.println("viewProfile1.getText() = " + viewProfile1.getText());
        Assert.assertTrue(viewProfile1.isDisplayed());
    }
    @Test
    public void t_dragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source,target).perform();

        WebElement verifyMessage = driver.findElement(By.xpath("(//p[.='Dropped!'])[1]"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());
        Assert.assertTrue(verifyMessage.isDisplayed());
        Assert.assertEquals(verifyMessage.getText(),"Dropped!");
    }
    @Test
    public void t2_dragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();
        WebElement verifyMessage = driver.findElement(By.xpath("(//p[.='Dropped!'])[1]"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());
        Assert.assertTrue(verifyMessage.isDisplayed());
    }
    @Test
    public void t_rightClick() {
        driver.get("https://demoqa.com/buttons");
        driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(rightClickMessage.isDisplayed());
    }
    @Test
    public void t_doubleClick() {
        driver.get("https://demoqa.com/buttons");
        driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(doubleClickMessage.isDisplayed());
    }
}
