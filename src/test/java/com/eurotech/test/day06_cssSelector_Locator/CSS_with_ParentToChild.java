package com.eurotech.test.day06_cssSelector_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSS_with_ParentToChild {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //Parent to child with xpath
        String xpathText = driver.findElement(By.xpath("//section/p")).getText();
        System.out.println("xpathText = " + xpathText);

        //Parent to child with Css Selector using > operator
        String cssText1 = driver.findElement(By.cssSelector("section>p")).getText();
        System.out.println("cssText1 = " + cssText1);

        //Parent to child with Css Selector with space (without using > operator)
        String cssText2 = driver.findElement(By.cssSelector("body section p")).getText();
        System.out.println("cssText2 = " + cssText2);

        //we can't go from child to parent with cssSelector.
        //we can't use INDEX number with cssSelector
        Thread.sleep(2000);
        driver.close();
    }
}
