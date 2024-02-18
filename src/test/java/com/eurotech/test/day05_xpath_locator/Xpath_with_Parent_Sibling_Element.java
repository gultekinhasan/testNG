package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_Parent_Sibling_Element {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        //LOCATING PARENT ELEMENT
        //1st way --> <knownXpath>/parent::tagName
        WebElement accountText= driver.findElement(By.xpath("//i[@class='fas fa-user']/parent::p"));
        //2nd way --> <knownXpath>/parent::*
        //3rd way --> <knownXpath>/..
        System.out.println("accountText.getText() = " + accountText.getText());

        //LOCATING FOLLOWING SIBLING ELEMENT
        WebElement doNotText = driver.findElement(By.xpath("//p[@id='loginpage-p1']/following-sibling::p"));
        System.out.println("doNotText.getText() = " + doNotText.getText());

        //LOCATING PRECEDING SIBLING ELEMENT
        WebElement accountText2 = driver.findElement(By.xpath("//p[@class='my-1']/preceding-sibling::p"));
        System.out.println("accountText2.getText() = " + accountText2.getText());

        driver.close();
    }
}
