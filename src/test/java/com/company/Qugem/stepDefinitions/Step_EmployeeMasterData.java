package com.company.Qugem.stepDefinitions;

import com.company.Qugem.pages.Page_EmployeeMasterData;
import com.company.Qugem.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

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

    @Given("Verify employees table column titles are all displayed")
    public void verifyEmployeesTableColumnTitlesAreAllDisplayed() {
        boolean allTitlesDisplayed = true;

        for (WebElement employeesTableTitle : Employees_TableTitles) {
            if (!employeesTableTitle.isDisplayed()) {
                System.out.println("employeesTableTitle.getText() = " + employeesTableTitle.getText());
                allTitlesDisplayed = false;
            }
        }

        Assert.assertTrue("not all column titles are displayed", allTitlesDisplayed);

    }


    @When("user uses {string}, personal No comes to first row and first column of table")
    public void userUsesPersonalNoComesToFirstRowAndFirstColumnOfTable(String no) {
        Filter_No.click();
        Filter_No.clear();
        Filter_No.sendKeys(no);

        WebElement row1_column1 = driver.findElement(By.xpath("//table//tbody//tr[1]//td[.=" + no + "]"));
        Assert.assertEquals(row1_column1.getText(), no);
    }

    @When("user uses {string}, personal name comes to first row and second column of table")
    public void userUsesPersonalNameComesToFirstRowAndSecondColumnOfTable(String firstName) {
        Filter_FirstName.click();
        Filter_FirstName.clear();
        Filter_FirstName.sendKeys(firstName);
        WebElement row1_column2 = driver.findElement(By.xpath("//table//tbody//tr[1]//td[2]"));
        Assert.assertEquals(row1_column2.getText(), firstName);

    }

    @When("user uses {string} , personal lastname comes to first row and third column of table")
    public void userUsesPersonalLastnameComesToFirstRowAndThirdColumnOfTable(String LastName) {
        Filter_LastName.click();
        Filter_LastName.clear();
        Filter_LastName.sendKeys(LastName);
        WebElement row1_column3 = driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]"));
        Assert.assertEquals(row1_column3.getText(), LastName);
    }


    @When("the user clicks the Lines Per Page select arrow")
    public void theUserClicksTheSelectArrow() throws InterruptedException {
        BrowserUtils.scrollToElement(LinesPerPageDownArrowBox);
        LinesPerPageDownArrowBox.click();
       // new Actions(driver).click(LinesPerPageDownArrowBox);
        Thread.sleep(4000);
    }


    @And("chooses a {int}, click and verify list doesn't have more than this number of personal")
    public void choosesAClickAndVerifyListDoesntHaveMoreThanThisNumberOfPersonal(int number_of_personal) {
        //li[.='50']
       WebElement el_number_perpage= driver.findElement(By.xpath("//li[.='" + number_of_personal + "']"));
        el_number_perpage.click();
        List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
        Assert.assertTrue(rows.size() <= number_of_personal);
    }


    @When("user clicks the next page arrow in employee list")
    public void userClicksTheNextPageArrowInEmployeeList() {
        BrowserUtils.scrollToElement(Next_page);
        BrowserUtils.waitFor(2);
        Next_page.click();
    }

    @And("user is still in the employee list page that has Employees tableTitle")
    public void userIsStillInTheEmployeeListPageThatHasEmployeesTableTitle() {
        Assert.assertTrue(Employees.isDisplayed());
    }
}
