package com.eurotech.homeworks;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hw_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.co.uk/");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        searchBox.sendKeys("java");
        driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
        WebElement result = driver.findElement(By.xpath("(//h1/span[@class='BOLD'])[1]"));
        String resultText = result.getText();
        System.out.println("resultText = " + resultText);
        Thread.sleep(2000);
        driver.close();
    }
}
