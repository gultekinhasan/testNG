package com.eurotech.pagesSauce;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsSaucePage {
    public ProductsSaucePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(className = "title")
    public WebElement productsText;
}
