package com.eurotech.test.day07_testNG_Intro;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {
    @Test
    public void test1() {
        System.out.println("Open Browser");
        System.out.println("My 1st test case");
        System.out.println("Close Browser");
    }
    @Test
    public void Btest2(){
        System.out.println("My 2nd test case");
    }
    @Test //@Ignore
    public void atest3() {
        System.out.println("My 3rd test case");
    }
}

