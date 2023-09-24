package com.company.Qugem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.SplittableRandom;

public class Page_EmployeeMasterData extends AbstractBasePage{

    @FindBy(xpath = "(//h3[.='Employee information'])[1]")
    protected WebElement Employee_information;

    @FindBy(css = "#tableTitle")
    protected WebElement Employees;

    @FindBy(xpath = "//h6[@id= 'tableTitle']/..//button")
    protected WebElement Add_new_employees_plus_buttonSign;

    @FindBy(xpath = "(//input[@placeholder='Filter'])[1]")
    protected WebElement Filter_No;

    @FindBy(xpath = "(//input[@placeholder='Filter'])[2]")
    protected WebElement Filter_FirstName;

    @FindBy(xpath = "(//input[@placeholder='Filter'])[3]")
    protected WebElement Filter_LastName;

    @FindBy(xpath = "//table//th//span//strong")
    protected List<WebElement> Employees_TableTitles ;       //No ,First Name ,Last Name ,Client , Company ,Entry Date , Role , Dispatcher ,Wage type ,Current Vehicle ,Status



    //find Employees page any table title element
    //No ,First Name ,Last Name ,Client , Company ,Entry Date , Role , Dispatcher ,Wage type ,Current Vehicle ,Status     ==>title elements
    public WebElement employees_Table_Titles_Element(String el_title){

    return driver.findElement(By.xpath("//table//th//span//strong[.='"+el_title+"']"));
    }


    @FindBy(xpath = "//div[@id='mui-59918']/../*[name()='svg']")
    protected WebElement LinesPerPageDownArrowBox;

    @FindBy(xpath = "//button[@title='Next page']")
    protected WebElement Next_page;

    @FindBy(xpath = "//button[@title='Previous page']")
    protected WebElement Previous_page;



}
