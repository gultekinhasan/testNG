package com.eurotech.test.day02_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://eurotech.study/");
        Thread.sleep(2000);
        //close current tab
        driver.close();
        driver=new ChromeDriver();
        driver.get("https://en-gb.facebook.com/");
        Thread.sleep(2000);
        driver.quit();

    }
}
