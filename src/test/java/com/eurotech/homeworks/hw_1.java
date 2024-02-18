package com.eurotech.homeworks;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hw_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        WebElement textA = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        System.out.println("textA  = " + textA.getText());
        WebElement textB = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println("textB  = " + textB.getText());
        WebElement textC = driver.findElement(By.xpath("//input[@id='email']"));
        textC.sendKeys("av.gultekinhasan@gmail.com");
        WebElement textD = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        System.out.println("textD  = " + textD.getText());
        Thread.sleep(1500);
        driver.close();
    }
}
