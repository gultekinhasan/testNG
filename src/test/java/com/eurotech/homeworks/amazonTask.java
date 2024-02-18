package com.eurotech.homeworks;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
        searchBox.sendKeys("selenium");
        WebElement searchBtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchBtn.click();
        String expectedText = "\"selenium\"";
        WebElement actual = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualText= actual.getText();
        System.out.println(actualText);
        System.out.println(expectedText);
        if (expectedText.equals(actualText)){
            System.out.println("Test Passed Successfully");
        }else System.out.println("Test Failed :( ");
        Thread.sleep(2000);
        driver.close();
    }
}
