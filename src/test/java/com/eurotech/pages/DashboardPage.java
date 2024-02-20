package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{
    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;
    @FindBy(id = "dashboard-p1")
    public WebElement welcomeMsg;

    @FindBy(css = ".btn.btn-light")
    public List<WebElement> altMenu;

    public void dashboardMenu(String linkText){
        Driver.get().findElement(By.linkText(linkText)).click();
    }
    public String getJobTitle(String jobTitle){
        return Driver.get().findElement(By.xpath("//td[.='"+jobTitle+"']")).getText();
    }


}
