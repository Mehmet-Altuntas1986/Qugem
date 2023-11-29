package com.company.Qugem.stepDefinitions;



import com.company.Qugem.pages.AbstractBasePage;
import com.company.Qugem.utilities.BrowserUtils;
import com.company.Qugem.utilities.ConfigurationReader;
import com.company.Qugem.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Language_Change extends AbstractBasePage {
    @Given("Navigate to Login Page iki")
    public void navigate_to_login_page_iki() {
        WebDriver driver = Driver.getDriver();
            driver.navigate().to(ConfigurationReader.getProperty("url"));
            BrowserUtils.waitFor(1);
            driver.findElement(lct_inputbox_emailbox).sendKeys(ConfigurationReader.getProperty("admin_username"));
            driver.findElement(lct_inputbox_password).sendKeys(ConfigurationReader.getProperty("admin_password"));
           einlogen.click();
           BrowserUtils.waitFor(6);
    }
    @When("The user should be able to language button click and select Deutsch")
    public void theUserShouldBeAbleToLanguageButtonClickAndSelectDeutsch() {
        languagebtn.click();
        deutschbtn.isSelected();
    }
    @Then("Verify that the language is selected as Deutsch")
    public void verifyThatTheLanguageIsSelectedAsDeutsch() {
        BrowserUtils.verifyElementDisplayed(deutschverify);
        BrowserUtils.waitFor(3);
    }
    @When("The user should be able to language button click and select Turkish")
    public void theUserShouldBeAbleToLanguageButtonClickAndSelectTurkish() {
        trkisbtn.click();
    }
    @Then("Verify that the language is selected as Turkish")
    public void verifyThatTheLanguageIsSelectedAsTurkish() {
        BrowserUtils.verifyElementDisplayed(turkishverify);
    }
    @When("The user should be able to language button click and select English")
    public void theUserShouldBeAbleToLanguageButtonClickAndSelectEnglish() {
        languagebtn2.click();
        BrowserUtils.waitFor(2);
        englishbtn.click();
    }
    @Then("Verify that the language is selected as English")
    public void verifyThatTheLanguageIsSelectedAsEnglish() {
        BrowserUtils.waitFor(2);
        BrowserUtils.verifyElementDisplayed(englishverify);
    }
}