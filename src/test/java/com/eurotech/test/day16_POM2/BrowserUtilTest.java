package com.eurotech.test.day16_POM2;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class BrowserUtilTest extends TestBase {

    @Test
    public void window() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();

        BrowserUtils.switchToWindow("New Window");
        System.out.println("After Switch = " + driver.getTitle());
    }

    @Test
    public void actions() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));
        BrowserUtils.hover(img1);
    }
    @Test
    public void list(){
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));
        System.out.println("BrowserUtils.getElementsText(menuList) = " + BrowserUtils.getElementsText(menuList));
    }
}
