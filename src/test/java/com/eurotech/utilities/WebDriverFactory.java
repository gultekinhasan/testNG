package com.eurotech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

        /** Class Task D2T3
         * write a static method that takes a string parameter name : browserType
         * it will setUp the browser
         * and the method will return chromeDriver or firefoxDriver object
         * and name of the method is getDriver
         */
        public static WebDriver getDriver (String browserType){
            WebDriver driver =null;
            if (browserType.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
               driver= new ChromeDriver();
            } else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            return driver;
        }
}
