package com.eurotech.test.day10_typeOfWebElements_3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void t_twoWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
//        String titleAfterClick= driver.getTitle();
//        System.out.println("titleAfterClick = " + titleAfterClick);

        System.out.println(driver.findElement(By.tagName("h3")).getText());

        String currentTab = driver.getWindowHandle(); // title the internet and has ID window-CC84B1F44A7DEFA03870280B01DD7388
        System.out.println("currentTab = " + currentTab);  //6CAB4E517D04AD0BF078C2946151A12A


        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            System.out.println("tab = " + tab);
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }

    @Test
    public void t_multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
//          1 . way
//            if (driver.getTitle().equals("New Window")){
//                System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
//                System.out.println("driver.getTitle() = " + driver.getTitle());
//                break;
//            }
//          2.way
            if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")) {
                System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
                System.out.println("driver.getTitle() = " + driver.getTitle());
                break;
            }
        }
    }
}
