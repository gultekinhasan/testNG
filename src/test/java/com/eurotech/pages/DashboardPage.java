package com.eurotech.pages;

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


}
