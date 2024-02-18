package com.eurotech.test.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        // We have to enter below line every time if we want to open chrome/firefox/safari...
        WebDriverManager.chromedriver().setup();
        // WebDriver represents the browser, we are creating driver for Chrome browser
        WebDriver driver = new ChromeDriver(); // Polymorphism
        //
        driver.get("https://www.google.com");
        driver.close();
    }
}
