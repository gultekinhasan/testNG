package com.eurotech.pagesSauce;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSaucePage {
    public LoginSaucePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "user-name")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMsg;

    public void login(){
        username.sendKeys(ConfigurationReader.get("usernameSaucePos"));
        password.sendKeys(ConfigurationReader.get("passwordSauce"));
        loginBtn.click();
    }
    public void login(String email, String pass){
        username.sendKeys(email);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
