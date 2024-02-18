package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_VisibleText_Partial {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        //1st way
        WebElement accountText = driver.findElement(By.xpath("//p[contains(text(),'Account')]"));
        //2nd way --> //*[contains(text(),'Account')]
        System.out.println("accountText.getText() = " + accountText.getText());

        driver.close();
    }
}
