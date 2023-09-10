package com.company.Qugem.pages;

import com.company.Qugem.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Page_Vehicles_in_Dashboard extends AbstractBasePage {

    public Page_Vehicles_in_Dashboard() {
        super();
    }

    @FindAll({
            @FindBy(xpath = "//div[.='Vehicles']"),

    })
    protected WebElement btn_VehiclesInDashboard;


    By lct_VehiclesInDashboard = By.xpath("//span[contains(text(),'Vehicles')]");


    protected By lct_plus_sign_button = By.xpath("//span[@class='MuiFab-label']");

    @FindBy(xpath = "//span[@class='MuiFab-label']")
    protected
    WebElement btn_plus_sign_button;




//!After clicking + plus add sign button --locaters and elements


    //div[@id='root']//form//label[.='Plate']
    //div[@id='root']//form//label[.='Brand']
    //div[@id='root']//form//label[.='Model']
    //div[@id='root']//form//label[.='Type']
    //div[@id='root']//form//label[.='Year of construction']
    //div[@id='root']//form//label[.='Year of purchase']
    //div[@id='root']//form//label[.='Current kilometer']
    //div[@id='root']//form//label[.='Purchase Price']

    @FindBy(css = "input[name='plate']")
    protected WebElement Plate;
    @FindBy(css = "input[name='brand']")
    protected WebElement Brand;

    @FindBy(css = "input[name='model']")
    protected WebElement Model;


    @FindBy(css = "#mui-component-select-type")
    protected WebElement Type;
    @FindBy(css = "div[id='menu-type'] li:nth-child(1)")
    protected WebElement LKW;


    @FindBy(css = "input[name='year_production']")
    protected WebElement Year_of_construction;

    @FindBy(css = "input[name='year_buy']")
    protected WebElement Year_of_purchase;

    @FindBy(css = "input[name='currentKm']")
    protected WebElement Current_kilometer;

    @FindBy(css = "input[name='purchasePrice']")
    protected WebElement Purchase_Price;

    @FindBy(xpath = "//div[@id='root']//form")  //includes Web Elements
    protected WebElement form;

    @FindBy(css = "button[type='submit']")
    protected WebElement save_changes;


    @FindBy(xpath = "//tbody/tr/td")
    protected List<WebElement> vehicleListinFirstRow;

    @FindBy(css = "table tbody tr td")
    protected List<WebElement> vehicleDetailsPage_second_column_elements;


    @FindAll({  // at least one of the locater should match
            @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']"),

            @FindBy(xpath = "//tbody/tr[2]/td[9]/button[1]"),
            @FindBy(xpath = "//tbody/tr/td[contains(.='KO PJ 3396')]/following-sibling::td[8]"),
    })
    protected WebElement btn_details_in_vehicle_list_page;

    //find the detail element in vehicle list belongs to the plate
    public WebElement detailElementbelongsToPlate_in_vehicle_list(String plate) {
        return driver.findElement(By.xpath("//tbody//tr//td[contains(.,'" + plate + "')]//following-sibling::td[.='Detail']"));
    }

    public WebElement plateElement_in_vehicle_list(String plate) {
        return driver.findElement(By.xpath("//tbody//tr//td[contains(.,'" + plate + "')]"));
    }
    public WebElement detailElementbelongsToRowNumber_in_vehicle_list(int row) {
        return driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[.='Detail']"));
    }


    public WebElement Any_Element_in_Vehicle_List(String plateNumber, String clikableElementName) {
        try {
            return driver.findElement(By.xpath("//tbody//tr//td[.='"+plateNumber+"']/following-sibling::td[.='"+clikableElementName+"']"));
        } catch (NoSuchElementException e) {

            throw new NoSuchElementException("Element not found: " + plateNumber + " - " + clikableElementName);

        }
    }


//!Vehicle details page elements and locaters


    protected By lct_Edit_button_in_Vehicle_details_page = By.xpath("//span[.='Edit']/..");


    @FindAll({
            @FindBy(xpath = "//span[normalize-space()='Edit']")


    })
    protected WebElement btn_edit_in_details;


    //After clicking Vehicle modules --Web elements
    @FindBy(xpath = "//h3[contains(text(),'Vehicle List')]")
    protected WebElement tableTitle_Vehicle_List;
    @FindBy(xpath = "//span[.='Delete']")
    protected WebElement btn_delete_addedAuto;


//!  to delete an added auto
    @FindAll({
            @FindBy(xpath = "//span[.='yes']"),
            @FindBy(xpath = "//span[.='yes']/..")
    })
    protected WebElement btn_yes_Alert_toConfirm_deleteAuto;

    @FindAll({
            @FindBy(xpath = "//span[.='Delete']"),
            @FindBy(xpath = "//span[.='Delete']/..")
    })
    protected WebElement btn_delete_added_auto;






}
