package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_MultipleAttribute {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        //Accept cookies by cssSelector with ID --> #valueOfIdAttribute
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //multiple attribute with xpath
        WebElement xpathText= driver.findElement(By.xpath("//p[@class='lead'][@id='loginpage-p1']"));
        System.out.println("xpathText.getText() = " + xpathText.getText());
        //multiple attribute with cssSelector without tagName
        WebElement cssText1= driver.findElement(By.cssSelector("[class='lead'][id='loginpage-p1']"));
        System.out.println("cssText1.getText() = " + cssText1.getText());
        //multiple attribute with cssSelector with tagName
        WebElement cssText2= driver.findElement(By.cssSelector("p[class='lead'][id='loginpage-p1']"));
        System.out.println("cssText2.getText() = " + cssText2.getText());
    }
}
