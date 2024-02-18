package com.eurotech.test.day07_testNG_Intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }

    @Test
    public void test1() {
        System.out.println("Test1 first Assertion");
        Assert.assertEquals("Title","Title");
        System.out.println("Test1 second Assertion");
        Assert.assertEquals(3,3);
    }

    @Test
    public void test2() {
        System.out.println("test2 Assertion");
        Assert.assertEquals("test2","test2","Verfication of actual expected results are Failed");
    }

    @Test
    public void test3() {
        String expectedTitle = "Eurotech";
        String actualTitle = "Eurotech";
        Assert.assertTrue(actualTitle.equals(expectedTitle),"Verification of Title is Failed!!");
    }

    @Test
    public void test4() {
        //Verify the email contains @ sign
        String email = "eurotech@gmail.com";
//        if (email.contains("@")){
//            System.out.println("passed");
//        }else System.out.println("failed");
        Assert.assertTrue(email.contains("@"),"email has not @ sign");
    }

    @Test
    public void test5() {
        Assert.assertFalse(0>1,"verification is Failed");
    }

    @Test
    public void test6() {
        //Assert.assertNotEquals("two","two"); --> failed olur
        //Assert.assertNotEquals("one","two"); //--> passed olur
        Assert.assertNotEquals(2,3,"Actual and expected are equal, TEST FAILED!!");
    }
}
