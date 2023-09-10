package com.company.Qugem.stepDefinitions;

import com.company.Qugem.pages.Page_login_to_navigate_dashboard;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.company.Qugem.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Step_Login_to_navigate_dasboard extends Page_login_to_navigate_dashboard {


    @When("Navigate to Login Page")
    public void navigateToLoginPage() {
        driver.navigate().to(ConfigurationReader.getProperty("url"));
        BrowserUtils.waitFor(5);
    }

    @Then("Enter a valid email")
    public void enterAValidEmail() {
        driver.findElement(lct_inputbox_emailbox).sendKeys(ConfigurationReader.getProperty("admin_username"));
    }
    @Then("Enter a valid password")
    public void enterAValidPassword() {
        driver.findElement(lct_inputbox_password).sendKeys(ConfigurationReader.getProperty("admin_password"));
    }


    @Then("Click the login button after choosing english language")
    public void clickTheLoginButtonWithEnglish() {
        driver.findElement(lct_langugeImg_button).click();
        BrowserUtils.waitFor(1);
        driver.findElement(lct_choose_language_english).click();
        BrowserUtils.waitFor(1);

        driver.findElement(lct_btn_login).click();
        BrowserUtils.waitFor(5);
    }

    @And("Verify that user is now on the Dasboard Page after clicking login")
    public void getThePopUpTextLoginIsSuccessful() {
        String expectedUrlAfterNavigation="https://qugem-staging.netlify.app/";
        Assert.assertEquals("user is now in the dashboard page",expectedUrlAfterNavigation,driver.getCurrentUrl());

    }


    @Then("verify that dashboard page tab name contains QUGEM")
    public void verifyThatDashboardPageTabNameIsQUICKLYQUGEM() {

        Assert.assertTrue(driver.getTitle().contains("QUGEM") );

    }




    @Then("Enter an invalid {string}")
    public void enterAnInvalid(String invalidPassword) {

        driver.findElement(lct_inputbox_password).sendKeys(invalidPassword);
    }


    @And("Verify that user is not on the Dasboard Page after clicking login")
    public void verifyThatUserIsNotOnTheDasboardPageAfterClickingLogin() {

        String unexpectedUrlAfterNavigation="https://qugem-staging.netlify.app";
        Assert.assertNotEquals( unexpectedUrlAfterNavigation,driver.getCurrentUrl());

    }

    @And("verify user gets right alert warning -->false {string}")
    public void verifyUserGetsRightAlertWarningFalseBitteGebenSieEineKorrekteEMailAdresseEin() {
        WebElement alertInvalidPassword=driver.findElement(By.xpath("//div[contains(text(),'Bitte geben Sie eine korrekte E-Mail-Adresse ein.')]"));
        Assert.assertFalse("user gets a wrong alert",alertInvalidPassword.getText().contains("E-Mail"));
    }




    @Then("verify that user gets an alert that pasword \"Must be at least 6 characters long\"")
    public void verifyThatUserGetsAnAlert() {
        WebElement alertShortPasword=driver.findElement(By.xpath("//p[contains(text(),'Must be at least 6 characters long')]"));
        Assert.assertEquals("Must be at least 6 characters long", alertShortPasword.getText());
    }

    @Then("Click the sign out button")
    public void clickTheSignOutButton() {
        //first click Max Musterman button but possible after it is visible or clickable


       BrowserUtils.clickWithJS_withoutScrollIntoView(btn_MaxMusterman);
       // btn_MaxMusterman.click();
       BrowserUtils.clickWithJS_withoutScrollIntoView(btn_SignOut);
       // btn_SignOut.click();
       // new Actions(driver).click(btn_MaxMusterman);
       // new Actions(driver).click(btn_SignOut);



        Assert.assertEquals("user is again on the sign in webpage", "https://qugem-staging.netlify.app/auth/sign-in", driver.getCurrentUrl());


    }



}

