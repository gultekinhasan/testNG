package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSS_with_FollowingSibling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //locate following sibling with xpath
        String xpathText = driver.findElement(By.xpath("//form/following-sibling::p")).getText();
        System.out.println("xpathText = " + xpathText);

        //locate following sibling with cssSelector
        // --> we use ~ (tilde) operator instead of following-sibling keyword
        String cssText1 = driver.findElement(By.cssSelector("form~p")).getText();
        System.out.println("cssText1 = " + cssText1);
        String cssText2 = driver.findElement(By.cssSelector("form[id='loginpage-form']~p")).getText();
        System.out.println("cssText2 = " + cssText2);

        //We can NOT locate PRECEDING SIBLING wth cssSelector.
        driver.close();

    }
}
