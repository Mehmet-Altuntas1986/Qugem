package com.company.Qugem.pages;

import com.company.Qugem.utilities.BrowserUtils;
import com.company.Qugem.utilities.ConfigurationReader;
import com.company.Qugem.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class AbstractBasePage {
    protected static WebDriver driver;

    protected AbstractBasePage() { //constructor
        this.driver = Driver.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);

    }
//lOGIN PAGE EMAIL,PASSWORD ,LOGIN BUTTON ,LANGUAGES LOCATERS ARE COMMON FOR All PAGES

    protected By lct_inputbox_emailbox = By.xpath("//input[@name='email']");
    protected By lct_inputbox_password = By.cssSelector("input[name='password']");
    protected By lct_btn_login = By.xpath("//span[normalize-space()='Login']");
    protected By lct_langugeImg_button = By.cssSelector("img[alt='Flag']");


    //if you want to change language, you can use these locaters in a method  ---- NavigateToDashBoard(By languageLocater)
    protected By lct_choose_language_deutch = By.cssSelector("ul[role='menu']>li:nth-child(1)");
    protected By lct_choose_language_turkce = By.cssSelector("ul[role='menu']>li:nth-child(2)");
    protected static By lct_choose_language_english = By.cssSelector("ul[role='menu']>li:nth-child(3)");


    protected void NavigateToDashBoard(By languageLocater) {
        WebDriver driver = Driver.getDriver();
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
            BrowserUtils.waitFor(3);
        }
    }

    //!Modules web elements

    @FindBy(xpath = "(//div//a//span)[1]")
    protected WebElement DashBoard_module;

    @FindBy(xpath = "(//div//a//span)[2]")
    protected WebElement Employee_Master_Data_module;

    @FindBy(xpath = "(//div//a//span)[3]")
    protected WebElement Employee_Attendance_module;

    @FindBy(xpath = "(//div//a//span)[4]")
    protected WebElement Payroll_module;

    @FindBy(xpath = "(//div//a//span)[5]")
    protected WebElement Vehicles_module;

    @FindBy(xpath = "(//div//a//span)[6]")
    protected WebElement Quickly_GmbH_module;

    @FindBy(xpath = "(//div//a//span)[7]")
    protected WebElement Kinesis_GPS;

    @FindBy(xpath = "//span[normalize-space()='Admin']")
    protected static WebElement Admin_module;

    //! when we click Admin module -- new sub modules ==> Users ,Options ,Holidays ,Payout_amounts
    @FindBy(xpath = "//span[.='Users']")
    protected WebElement Users_module;
    @FindBy(xpath = "//span[.='Options']")
    protected WebElement Options_module;
    @FindBy(xpath = "//span[.='Holidays']")
    protected WebElement Holidays_module;
    @FindBy(xpath = "//span[.='Payout amounts']")
    protected WebElement Payout_amounts_module;
    @FindBy(xpath = "//span[@class='MuiButton-startIcon MuiButton-iconSizeMedium']")
    protected WebElement einlogen;
    @FindBy(xpath = "//button[@title='Languages']")
    protected WebElement languagebtn;
    @FindBy(xpath = "//img[@alt='Flag']")
    protected WebElement languagebtn2;
    @FindBy(xpath = "//li[text()='Türkçe']")
    protected WebElement trkisbtn;
    @FindBy(xpath = ("//li[text()='English']"))
    protected WebElement englishbtn;
    @FindBy(xpath = ("//li[text()='Deutsch']"))
    protected WebElement deutschbtn;
    @FindBy(xpath = "//h5[text()='Hello, welcome to the QUGEM homepage.']")
    protected WebElement englishverify;
    @FindBy(xpath = "//h5[text()='Merhaba, QUGEM Anasayfasına hoşgeldiniz.']")
    protected WebElement turkishverify;
    @FindBy(xpath = "//h5[text()='Hallo, willkommen auf der QUGEM-Startseite.']")
    protected WebElement deutschverify;


    protected void NavigateToModule_WithLogin(By language_In_Login, WebElement ModuleName) {
        NavigateToDashBoard(language_In_Login); //choose language and navigate to dashboard

        //here clicks the intended module element
        if (ModuleName != null) {
            //now click the desired module
            ModuleName.click();
        } else {
            throw new NoSuchElementException("Module element not found");
        }
    }


}