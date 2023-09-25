package com.company.Qugem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Page_login_to_navigate_dashboard extends AbstractBasePage {


    public Page_login_to_navigate_dashboard() {
        super(); //call super class constructor ,then driver=Driver.getDriver();
    }


    protected By lct_inputbox_emailbox = By.xpath("//input[@name='email']");
    protected By lct_inputbox_password = By.cssSelector("input[name='password']");
    protected By lct_btn_login = By.xpath("//span[normalize-space()='Login']");
    protected By lct_langugeImg_button = By.cssSelector("img[alt='Flag']");


    //locaters to choose language before log in
    protected By lct_choose_language_deutch = By.cssSelector("ul[role='menu']>li:nth-child(1)");
    protected By lct_choose_language_turkce = By.cssSelector("ul[role='menu']>li:nth-child(2)");
    protected By lct_choose_language_english = By.cssSelector("ul[role='menu']>li:nth-child(3)");


    @FindBy(id = "login")
    WebElement btn_login;


    //!Sign out  elements

    @FindAll({
            @FindBy(xpath = "//button[.='Max Mustermann']"),
            @FindBy(xpath = "//button[@title='Account']")


    })
    protected WebElement btn_MaxMusterman;


    @FindAll({
            @FindBy(xpath = "//*[.='Sign out']"),
            @FindBy(xpath = "//li[.='Sign out']"),
            @FindBy(css = "div[id='menu-appbar'] li:nth-child(2)")
    })
    protected WebElement btn_SignOut;


}


