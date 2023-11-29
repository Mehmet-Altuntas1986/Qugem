package com.company.Qugem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
public class Page_Company_Client extends  AbstractBasePage{

    @FindBy(xpath = "//p[text()='QUICK PLT GMBH']")
    public WebElement companyBtn;
    @FindBy(xpath = "//p[text()='OTLG']")
    public WebElement clientBtn;
}
