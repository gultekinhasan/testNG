package com.eurotech.test.day02_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    //Class Task Day2Task2
    //open chrome and navigate to "https://www.eurotechstudy.com/en"
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       // driver.get("https://www.google.com/");
       // Thread.sleep(2000);
       // driver.navigate().to("https://www.eurotechstudy.com/en");
       // Thread.sleep(2000);
        driver.get("https://en-gb.facebook.com/");
        //shortcut Alt+Enter+Enter
        String title = driver.getTitle();

        System.out.println(title);

        System.out.println();
        //how to verify title (expectedResult and actualResult)
        String expectedResult = "Facebook – log in or sign up";
        String actualResult = driver.getTitle();
        if (expectedResult.equalsIgnoreCase(actualResult)){
            System.out.println("expectedResult and actualResult are the same, PASSED");
        }else System.out.println("expectedResult and actualResult are not the same,FAILED");

        //getting web pages URL-->
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSource= driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

        Thread.sleep(2000);
        driver.close();
    }


}
