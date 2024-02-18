package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_Contains {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //xpath with contains
        WebElement xpathText = driver.findElement(By.xpath("//p[contains(@id,'warn')]"));
        System.out.println("xpathText.getText() = " + xpathText.getText());

        //css selector with contains --> * = contains --> [attribute*='value']
        WebElement cssText1 = driver.findElement(By.cssSelector("[id*=warn]"));
        System.out.println("cssText1.getText() = " + cssText1.getText());

        //Css Selector with tagName and contains --> * = contains --> tagName[attribute*='value']
        WebElement cssText2= driver.findElement(By.cssSelector("p[id*='warn']"));
        System.out.println("cssText2.getText() = " + cssText2.getText());
        driver.close();


    }
}
