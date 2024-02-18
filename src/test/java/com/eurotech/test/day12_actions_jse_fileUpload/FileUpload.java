package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void t_fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String filePath = "C:/Users/hasan/Desktop/Upload.txt";
        chooseFile.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        WebElement actualText = driver.findElement(By.id("uploaded-files"));
        System.out.println("actualText.getText() = " + actualText.getText());
        Assert.assertEquals(actualText.getText(),"Upload.txt");
    }
  /*  @Test
    public void t1_fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //to copy file path --> Mac : option+hold +right click  Win : shift+hold + right click
        String filePath="C:/Users/tosun/Desktop/B13 file upload .txt";
        //String filePath="C:\\Users\\tosun\\Desktop\\B13 file upload .txt";

        chooseFile.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();
        WebElement actualText = driver.findElement(By.id("uploaded-files"));
        System.out.println("actualText.getText() = " + actualText.getText());
        Assert.assertEquals(actualText.getText(),"B13 file upload .txt");
    }*/

    @Test
    public void t2_fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");

        //project path
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getenv(\"Path\") = " + System.getenv("Path"));


        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/Upload.txt";

        String fullPath = projectPath + "/" + filePath;
        System.out.println("fullPath = " + fullPath);

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();
        WebElement actualText = driver.findElement(By.id("uploaded-files"));
        System.out.println("actualText.getText() = " + actualText.getText());
        Assert.assertEquals(actualText.getText(),"Upload.txt");
    }
}
