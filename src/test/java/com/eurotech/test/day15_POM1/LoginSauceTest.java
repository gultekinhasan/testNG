package com.eurotech.test.day15_POM1;

import com.eurotech.pagesSauce.LoginSaucePage;
import com.eurotech.pagesSauce.ProductsSaucePage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSauceTest extends TestBase {
    LoginSaucePage loginSaucePage;
    ProductsSaucePage productsSaucePage;

    @Test
    public void testLoginSauce() {
        loginSaucePage = new LoginSaucePage();
        productsSaucePage = new ProductsSaucePage();
        driver.get(ConfigurationReader.get("urlSauce"));
        loginSaucePage.username.sendKeys(ConfigurationReader.get("usernameSaucePos"));
        loginSaucePage.password.sendKeys(ConfigurationReader.get("passwordSauce"));
        loginSaucePage.loginBtn.click();
        String expectedText = "Products";
        String actualText = productsSaucePage.productsText.getText();
        Assert.assertEquals(actualText, expectedText);
        //Assert.assertTrue(productsSaucePage.productsText.isDisplayed());
    }

    @Test
    public void testLoginSauce2() {
        loginSaucePage = new LoginSaucePage();
        productsSaucePage = new ProductsSaucePage();
        driver.get(ConfigurationReader.get("urlSauce"));

        loginSaucePage.username.sendKeys(ConfigurationReader.get("usernameSaucePos"));
        loginSaucePage.password.sendKeys(ConfigurationReader.get("passwordSauce"));
        loginSaucePage.loginBtn.click();

        wait.until(ExpectedConditions.visibilityOf(productsSaucePage.productsText));

        String expectedText = "Products";

        String actualText = productsSaucePage.productsText.getText();
        Assert.assertEquals(actualText, expectedText);
        //Assert.assertTrue(productsSaucePage.productsText.isDisplayed());
    }

    @Test
    public void testLoginWithMethod() {
        loginSaucePage = new LoginSaucePage();
        productsSaucePage = new ProductsSaucePage();
        driver.get(ConfigurationReader.get("urlSauce"));

        loginSaucePage.login();

        wait.until(ExpectedConditions.visibilityOf(productsSaucePage.productsText));

        String expectedText = "Products";

        String actualText = productsSaucePage.productsText.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testNegativeLogin() {
        /**
         * Class Task - 10min
         * go to url https://www.saucedemo.com/
         * enter locked_out_user as username
         * enter secret_sauce as password
         * click login button
         * verify error message
         */
        loginSaucePage = new LoginSaucePage();
        driver.get(ConfigurationReader.get("urlSauce"));
        loginSaucePage.login(ConfigurationReader.get("usernameSauceNeg"),"secret_sauce");
        Assert.assertEquals(loginSaucePage.errorMsg.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testWithMethodAndParameter() {
        loginSaucePage = new LoginSaucePage();
        driver.get(ConfigurationReader.get("urlSauce"));
        loginSaucePage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginSaucePage.errorMsg.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
