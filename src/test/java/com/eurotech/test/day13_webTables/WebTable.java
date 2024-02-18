package com.eurotech.test.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.navigate().refresh();
        WebElement demoTable2 =  driver.findElement(By.xpath("//span[text()='Demo Webtable 2 (Dynamic Table)']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].scrollIntoView(true);",demoTable2);
        jse.executeScript("window.scrollBy(0,750)");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.close();
    }
    @Test
    public void printTable() {
        WebElement tableDemo = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println("tableDemo.getText() = " + tableDemo.getText());
        Assert.assertTrue(tableDemo.getText().contains("Mecca"));
    }
    @Test
    public void getAllHeaders() {
        //get all column headers
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        System.out.println("allHeaders.size() = " + allHeaders.size());
        //to get all headers with for each loop
        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }
        //get all row headers
        List<WebElement> allRowHeaders = driver.findElements(By.xpath("//table[@border='1']/tbody/tr/th"));
        System.out.println("allRowHeaders.size() = " + allRowHeaders.size());
        for (WebElement rowHeader : allRowHeaders) {
            System.out.println("rowHeader.getText() = " + rowHeader.getText());
        }
    }
    @Test
    public void getRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("allRows.size() = " + allRows.size());
        WebElement clockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println("clockTower.getText() = " + clockTower.getText());
        System.out.println("------------------------------");
        for (int i=1; i<=allRows.size();i++){
            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+ i +"]"));
            System.out.println(i+" .row = " + row.getText());
        }
    }
    @Test
    public void getAllCellsOnOneRow() {
        //get Burj Khalifa info as list
        List<WebElement> burjKhalifa = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));
        System.out.println("burjKhalifa.size() = " + burjKhalifa.size());
        Assert.assertEquals(burjKhalifa.size(),6);

        for (WebElement bKCell : burjKhalifa) {
            System.out.println("bKCell.getText() = " + bKCell.getText());
        }
    }
    @Test
    public void getSingleCell() {
        WebElement clockTowerHeight = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[3]"));
        System.out.println("clockTowerHeight.getText() = " + clockTowerHeight.getText());
        Assert.assertEquals(clockTowerHeight.getText(),"601m");
    }
    @Test
    public void getAllCellsByIndex() {
        // we need nested loop
        // we need methods
        int rowNumber= getNumberOfRows();
        int columnNumber= getNumberOfColumn();
        System.out.println("rowNumber = " + rowNumber); // 4
        System.out.println("columnNumber = " + columnNumber); //7
        //iterate through each row on the table
        for (int i = 1 ; i <rowNumber ; i++) {
            //iterate through each row cell on the table
            for (int j = 1; j <columnNumber ; j++) {
                String cellPath = "//table[@border='1']/tbody/tr["+i+"]/td["+j+"]";
                WebElement cell= driver.findElement(By.xpath(cellPath));
                System.out.println(i+" / "+j+" cell.getText() = " + cell.getText());
            }
        }
    }
    private int getNumberOfRows(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }
    private int getNumberOfColumn(){
        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead//th"));
        return columns.size();
    }
}
