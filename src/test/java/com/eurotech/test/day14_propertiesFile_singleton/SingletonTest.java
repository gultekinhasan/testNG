package com.eurotech.test.day14_propertiesFile_singleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SingletonTest {
    //Singleton singleton = new Singleton();
    // we cannot create a new singleton class object

    @Test @Ignore
    public void test1() {
        String s1=Singleton.getInstance();
        System.out.println("s1 = " + s1);
        String s2=Singleton.getInstance();
        System.out.println("s2 = " + s2);
    }

    @Test @Ignore
    public void test2_withDriverClass() {
      //  WebDriver driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver= Driver.get();
        driver.get("https://www.amazon.co.uk");
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void test3() {
        //WebDriver driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.co.uk");
        Driver.closeDriver();
    }

    @Test
    public void test4() {
       // WebDriver driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        Driver.closeDriver();
    }
}
