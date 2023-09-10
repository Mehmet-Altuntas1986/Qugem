package com.company.Qugem.pages;

import com.company.Qugem.utilities.BrowserUtils;
import com.company.Qugem.utilities.ConfigurationReader;
import com.company.Qugem.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class AbstractBasePage {
    protected static WebDriver driver;

    protected  AbstractBasePage() { //constructor
        this.driver=Driver.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }
//lOGIN PAGE EMAIL,PASSWORD ,LOGIN BUTTON ,LANGUAGES LOCATERS ARE COMMON FOR All PAGES

    protected static By lct_inputbox_emailbox = By.xpath("//input[@name='email']");
    protected static By lct_inputbox_password = By.cssSelector("input[name='password']");
    protected static By lct_btn_login = By.xpath("//span[normalize-space()='Login']");
    protected static By lct_langugeImg_button = By.cssSelector("img[alt='Flag']");

   //if you want to change language, you can use these locaters in a method  ---- NavigateToDashBoard(By languageLocater)
    protected By lct_choose_language_deutch = By.cssSelector("ul[role='menu']>li:nth-child(1)");
    protected By lct_choose_language_turkce = By.cssSelector("ul[role='menu']>li:nth-child(2)");
    protected static By lct_choose_language_english = By.cssSelector("ul[role='menu']>li:nth-child(3)");


    protected static void NavigateToDashBoard(By languageLocater) {
        WebDriver driver=Driver.getDriver();
        if (driver == Driver.getDriver()) {
            driver.navigate().to(ConfigurationReader.getProperty("url"));
            BrowserUtils.waitFor(1);
            driver.findElement(lct_inputbox_emailbox).sendKeys(ConfigurationReader.getProperty("admin_username"));
            driver.findElement(lct_inputbox_password).sendKeys(ConfigurationReader.getProperty("admin_password"));

            driver.findElement(lct_langugeImg_button).click();
            BrowserUtils.waitFor(1);
            driver.findElement(languageLocater).click();
            BrowserUtils.waitFor(1);
            driver.findElement(lct_btn_login).click();
            BrowserUtils.waitFor(5);
        }
    }




}
