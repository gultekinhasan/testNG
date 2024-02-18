package com.eurotech.test.day07_testNG_Intro;

import org.testng.annotations.*;

public class Before_After_Methods {
    @BeforeClass
    public void beforeClass() {
        System.out.println("*** Before Class Method ***");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("*** After Class Method ***");
    }

    @BeforeMethod
    public void setup() {
        System.out.println("WebDriver, Open Browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser, Quit");
    }


    @Test
    public void test1() {
        System.out.println("First Test Case");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Case");
    }

    @Test
    public void test3() {
        System.out.println("Third Test Case");
    }

    @Test //@Ignore
    public void test4() {
        System.out.println("Fourth Test Case");
    }
}
