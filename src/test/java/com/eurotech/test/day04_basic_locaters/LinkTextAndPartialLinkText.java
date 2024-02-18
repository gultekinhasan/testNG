package com.eurotech.test.day04_basic_locaters;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");

        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();
        String expectedText = "Example 1: Element on page that is hidden";
        String actualText = driver.findElement(By.tagName("h4")).getText();
        if (expectedText.equals(actualText)){
            System.out.println("passed");
        }else System.out.println("failed");

        driver.navigate().back();
        driver.findElement(By.partialLinkText("Example 2:")).click();

        String expectedText2 = "Example 2: Element rendered after the fact";
        String actualText2 = driver.findElement(By.tagName("h4")).getText();
        if (expectedText2.contains(actualText2)){
            System.out.println("passed");
        }else System.out.println("failed");


        driver.close();
    }
}
