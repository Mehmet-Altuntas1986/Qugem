package com.company.Qugem.stepDefinitions;

import com.company.Qugem.pages.Page_EmployeeMasterData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Step_EmployeeMasterData extends Page_EmployeeMasterData {


    @When("user logins and clicks module employee_master_data")
    public void user_logins_and_clicks_module_employee_master_data() {
        NavigateToModule_WithLogin(lct_choose_language_english, Employee_Master_Data_module);
    }


    @Given("verify user is on the employee information page")
    public void theUserIsOnTheEmployeeInformationPage() {
        String Actual_url = driver.getCurrentUrl();
        String Expected_url = "https://qugem-staging.netlify.app/employee";
        Assert.assertEquals(Actual_url, Expected_url);

    }


    @Then("verify employee information should be displayed")
    public void theEmployeeInformationShouldBeDisplayed() {
        if (Employee_information.isDisplayed()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Employee information is not displayed");
        }
    }

    @And("verify Employees table title is displayed")
    public void theUserShouldBeOnTheEmployeePage() {
        Assert.assertTrue(Employees.isDisplayed());

    }

    @Given("verify that add personal button is displayed")
    public void verifyThatAddPersonalButtonIsDisplayed() {
        Assert.assertTrue(Add_new_employees_plus_buttonSign.isDisplayed());
    }

    @Then("verify that add personal button is enabled-functional")
    public void verifyThatAddPersonalButtonClickable() {
        Assert.assertTrue(Add_new_employees_plus_buttonSign.isEnabled());

    }
}
