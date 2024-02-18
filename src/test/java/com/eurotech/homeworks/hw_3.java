package com.eurotech.homeworks;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hw_3 {
    public static void main(String[] args) throws InterruptedException {
        String expectedWord = "selenium";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.co.uk/");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        searchBox.sendKeys("selenium");
        driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
        WebElement wantedWord = driver.findElement(By.xpath("//title[text()='selenium for sale | eBay']"));
        String actualWord = driver.getTitle();
        System.out.println("actualWord = " + actualWord);
        System.out.println("expectedWord = " + expectedWord);
        if (actualWord.contains(expectedWord)){
            System.out.println("Title of this webPage contains word 'selenium'...");
        }else System.out.println("Title of this webPage does not contains word 'selenium'...");
        Thread.sleep(1500);
        driver.close();
    }
}
