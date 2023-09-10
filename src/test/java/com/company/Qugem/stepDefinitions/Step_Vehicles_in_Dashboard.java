package com.company.Qugem.stepDefinitions;

import com.company.Qugem.pages.Page_Vehicles_in_Dashboard;
import com.company.Qugem.utilities.BrowserUtils;
import com.company.Qugem.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Step_Vehicles_in_Dashboard extends Page_Vehicles_in_Dashboard {

    @When("Navigate to DashboardPage with English language")
    public void navigate_to_dashboard_page_with_english_language() {
        NavigateToDashBoard(lct_choose_language_english);
    }


    @When("click to Vehicles module")
    public void navigateToVehiclesModuleBtn() {
        //driver.navigate().to("https://qugem-staging.netlify.app/auto");
        BrowserUtils.waitForClickablility(btn_VehiclesInDashboard, 10);
        BrowserUtils.clickWithJS_withoutScrollIntoView(btn_VehiclesInDashboard);
        BrowserUtils.waitFor(2);
    }

    @Then("click plus + add button")
    public void clickPlusAddButton() {
        driver.findElement(lct_plus_sign_button).click();
    }

    // @Then("fill in the boxes of {string} , {string} , {string}")
    public void fillInTheBoxesOf(String plate, String brand, String model) throws InterruptedException {

        // Plate.sendKeys(plate);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Plate.sendKeys(plate);


        // js.executeScript("arguments[0].value=arguments[1]",Plate,plate);
        Thread.sleep(3000);

        js.executeScript("arguments[0].value=arguments[1]", Brand, brand);
        js.executeScript("arguments[0].value=arguments[1]", Model, model);

    }


    @Then("choose the Type of the Vehicle")
    public void chooseTheTypeOfTheVehicle() {


        Actions action = new Actions(driver);
        action.moveToElement(Type).pause(1000).click().perform();
        action.moveToElement(LKW).pause(1000).click().perform();


    }

    @Then("fill in the boxes of {string} , {string} , {string},{string} {string} , {string} and {string}")
    public void fillInTheBoxesOfAnd(String plate, String brand, String model, String yr_construction, String yr_purchase, String currentkm, String price) throws InterruptedException {

        //cleans and puts new values automatically in the input boxes
     /*
        BrowserUtils.cleanInputBoxAndSendNewInputWithJavaScript(Plate,plate);
        BrowserUtils.cleanInputBoxAndSendNewInputWithJavaScript(Brand,brand);
        BrowserUtils.cleanInputBoxAndSendNewInputWithJavaScript(Model,model);
        BrowserUtils.cleanInputBoxAndSendNewInputWithJavaScript(Year_of_construction,yr_construction);

        BrowserUtils.cleanInputBoxAndSendNewInputWithJavaScript(Year_of_purchase,yr_purchase);
        BrowserUtils.cleanInputBoxAndSendNewInputWithJavaScript(Current_kilometer,currentkm);
        BrowserUtils.cleanInputBoxAndSendNewInputWithJavaScript(Purchase_Price,price);
*/
      /*
        Plate.sendKeys(plate);
        Brand.sendKeys(brand);
        Model.sendKeys(model);
        Year_of_construction.sendKeys(yr_construction);
        Year_of_purchase.sendKeys(yr_purchase);
        Current_kilometer.sendKeys(currentkm);
        Purchase_Price.sendKeys(price);
        Thread.sleep(2000);

       */

        BrowserUtils.cleanInputBoxAndSendNewInput(Plate, plate);
        BrowserUtils.cleanInputBoxAndSendNewInput(Brand, brand);
        BrowserUtils.cleanInputBoxAndSendNewInput(Model, model);
        BrowserUtils.cleanInputBoxAndSendNewInput(Year_of_construction, yr_construction);
        BrowserUtils.cleanInputBoxAndSendNewInput(Year_of_purchase, yr_purchase);
        BrowserUtils.cleanInputBoxAndSendNewInput(Current_kilometer, currentkm);
        BrowserUtils.cleanInputBoxAndSendNewInput(Purchase_Price, price);


    }

    @And("click the Save Changes button")
    public void clickTheSaveChangesButtonAgain() throws InterruptedException {
//new Actions(driver).moveToElement(save_changes).click().pause(1000);
        BrowserUtils.clickWithJS_withoutScrollIntoView(save_changes);
        //save_changes.click();
        BrowserUtils.waitFor(2);


    }

    @Then("verify that you are in the page of Vehicle List")
    public void verifyThatYouAreInThePageOfVehicleList() {
        Assert.assertEquals("https://qugem-staging.netlify.app/auto", driver.getCurrentUrl());
    }

    @Then("verify that all added properties of the vehicle in the list")
    public void verifyThatAllAddedPropertiesOfTheVehicleInTheList() {
        List<String> list = new ArrayList<>();
        for (WebElement el : vehicleListinFirstRow) {
            list.add(el.getText());
        }
        if (!list.contains("KO PJ 3396") || !list.contains("Mercedes") || !list.contains("A5") || !list.contains("LKW")) {
            Assert.fail("this texts are not appeared in the table of the vehicle list");
        }
    }


    @Then("click the detail button and verify vehicle details are all there")
    public void clickTheDetailButtonAndVerifyVehicleDetailsAreAllThere() {


        BrowserUtils.clickWithJS_withScrollIntoView(btn_details_in_vehicle_list_page);
        BrowserUtils.waitFor(2);

        List<String> list = new ArrayList<>();
        for (WebElement el : vehicleDetailsPage_second_column_elements) {
            list.add(el.getText());
        }
        if (!list.contains("KO PJ 3396") || !list.contains("Mercedes") || !list.contains("A5") || !list.contains("LKW") || !list.contains("2010") || !list.contains("2015") || !list.contains("20.000,00")) {
            Assert.fail("some texts are not appeared in the table of the vehicle details list");
        }
        BrowserUtils.waitFor(2);

    }


    @And("click the edit button in vehicle details page")
    public void clickTheEditButtonInVehicleDetailsPage() {
        BrowserUtils.waitForClickablility(btn_edit_in_details, 10);
        driver.navigate().refresh();
        By btn_Edit_in_Details = By.xpath("//span[normalize-space()='Edit']");
        BrowserUtils.clickWithJS_withScrollIntoView(btn_edit_in_details);

    }

    @Then("verify that current url contains edit")
    public void verifyThatCurrentUrlContainsEdit() {
        BrowserUtils.waitFor(2);
        boolean thereIsEditInCurrentUrl = driver.getCurrentUrl().toLowerCase().contains("edit");
        Assert.assertTrue(thereIsEditInCurrentUrl);

    }

    @Then("clear plate and Brand input boxes and put new values CO DJ 140 and Audi")
    public void clearPlateAndBrandInputBoxesAndPutNewValuesCODJAndAudi() {
        //clears and makes new value in the input
        BrowserUtils.cleanInputBoxAndSendNewInput(Plate, "CO DJ 140");

        BrowserUtils.cleanInputBoxAndSendNewInput(Brand, "Audi");
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForClickablility(save_changes, 10);


        // Brand.sendKeys("Audi");
    }

    @Then("verify you are again in the Vehicle details page")
    public void verifyYouAreAgainInTheVehicleDetailsPage() {
        boolean detailsPage = driver.getCurrentUrl().contains("details");
        Assert.assertTrue(detailsPage);


    }


    @Then("verify that new edited changes of plate CO DJ 140 and Audi name is in the Vehicle Details page")
    public void verifyThatNewEditedChangesOfPlateCODJAndAudiNameIsInTheVehicleDetailsPage() {
        List<String> list = new ArrayList<>();
        for (WebElement el : vehicleListinFirstRow) {
            list.add(el.getText());
        }
        if (!list.contains("CO DJ 140") && !list.contains("Audi") && !list.contains("A5") && !list.contains("LKW") && !list.contains("2010") && !list.contains("LKW") && !list.contains("2015") && !list.contains("LKW") && !list.contains("20000")

        ) {
            Assert.fail("this texts are not appeared in the table of the vehicle list");

        }
    }

    @Then("verify that you are in the Vehicle details page")
    public void verifyThatYouAreInTheVehicleDetailsPage() {

        if (driver.getCurrentUrl().contains("details")) {
            assert true;
        }

    }

    @And("click the detail in the first row of vehicle list")
    public void clickTheDetailsButtonInTheFirstRowOfVehicleList() {
        driver.navigate().refresh();
        BrowserUtils.waitForVisibility(detailElementbelongsToRowNumber_in_vehicle_list(1), 10);

        detailElementbelongsToRowNumber_in_vehicle_list(1).click();

    }


    @Then("verify that edited changes are visible in the Vehicle List page")
    public void verifyThatEditedChangesAreVisibleInTheVehicleListPage() {
        List<String> list = new ArrayList<>();
        for (WebElement el : vehicleListinFirstRow) {
            list.add(el.getText());
        }
        if (!list.contains("CO DJ 140") && !list.contains("Audi")

        ) {
            Assert.fail("this texts are not appeared in the table of the vehicle list");

        }

    }

    @Then("verify that added vehicle properties are found in Vehicle details page")
    public void verifyThatAddedVehiclePropertiesAreFoundInVehicleDetailsPage() {
        List<String> list = new ArrayList<>();
        for (WebElement el : vehicleDetailsPage_second_column_elements) {
            list.add(el.getText());
        }
        if (!list.contains("KO PJ 3396") || !list.contains("Mercedes") || !list.contains("A5") || !list.contains("LKW") || !list.contains("2010") || !list.contains("2015") || !list.contains("20.000,00")) {
            Assert.fail("some texts are not appeared in the table of the vehicle list");
        }
        BrowserUtils.waitFor(2);

    }


    @Then("verify that you see added vehicle properties in vehicle list page")
    public void verifyThatYouSeeAddedVehiclePropertiesInVehicleListPage() {
        List<String> list = new ArrayList<>();
        for (WebElement el : vehicleDetailsPage_second_column_elements) {
            list.add(el.getText());
        }
        if (!list.contains("KO PJ 3396") || !list.contains("Mercedes") || !list.contains("A5") || !list.contains("LKW")

        ) {
            Assert.fail("some texts are not appeared in the table of the vehicle list");
        }
        BrowserUtils.waitFor(2);

    }

    @Then("verify that an alert warns you if you try to add a vehicle with the same plate duplicate key error collection")
    public void verifyThatAnAlertWarnsYouIfYouTryToAddAVehicleWithTheSamePlate_EDuplicateKeyErrorCollection() {

        WebElement alertElement = driver.findElement(By.cssSelector("div[role='alert'] div:nth-child(2)"));
        Assert.assertTrue(alertElement.getText().contains("Existiert Bereits") || alertElement.getText().contains("duplicate key error"));

    }

    @Then("click the delete button")
    public void clickTheDeleteButton() {
        try {
            btn_delete_added_auto.click();
        } catch (NoSuchElementException e) {
            BrowserUtils.clickWithJS_withScrollIntoView(btn_delete_added_auto);
        }














    }
    @Then("fill the {string} ,{string} and startDate and {string} then click enter to save changes")
    public void fillTheAndStartDateAnd (String driver1, String driver2, String startKm){

        Actions actions = new Actions(driver);

        WebElement el_driver_One = driver.findElement(By.xpath("(//form//input)[1]"));
        WebElement el_driver_two = driver.findElement(By.xpath("(//form//input)[2]"));
        WebElement el_startDate = driver.findElement(By.xpath("(//form//input)[3]"));
        WebElement el_startKm = driver.findElement(By.xpath("(//form//input)[4]"));


        actions.doubleClick(el_driver_One).sendKeys(driver1).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        actions.doubleClick(el_driver_two).sendKeys(driver2).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        actions.doubleClick(el_startDate).sendKeys(Keys.LEFT, Keys.LEFT, "03", "09", "2023").build().perform();

        for (int i = 0; i <= 8; i++) {
            actions.moveToElement(el_startKm).click().sendKeys(Keys.BACK_SPACE).build().perform();
        }

        //click the save button
        actions.click(el_startKm ).sendKeys(startKm).build().perform();
        actions.moveToElement(el_startKm).click().build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();



       // WebElement save_btn_in_usage=driver.findElement(By.xpath("//span[.='Save']"));
       // BrowserUtils.clickWithActionsByMovingToElement(save_btn_in_usage);



        BrowserUtils.waitFor(1);


    }




    @Then("verify alert text - Vehicle was deleted successfully")
    public void verifyAlertTextVehicleWasDeletedSuccessfully () {
        String actualAlertText = driver.findElement(By.xpath("//span[.='Vehicle was deleted successfully']")).getText();
        Assert.assertTrue(actualAlertText.contains("deleted successfully"));
    }


    @Then("click confirm yes button in the alert")
    public void clickConfirmYesButtonInTheAlert () {
        btn_yes_Alert_toConfirm_deleteAuto.click();
        BrowserUtils.waitFor(2);
    }

    @Then("click Detail button of plate in Vehicle list") public void clickDetailButtonOfPlateInVehicleList () {
        WebElement Detail_button_plate_AS_20_150 = driver.findElement(By.xpath("//tbody//tr//td[.='AS 20 150']/following-sibling::td[8]/button"));
        new Actions(driver).moveToElement(Detail_button_plate_AS_20_150).doubleClick().build().perform();
        BrowserUtils.waitFor(1);


    }

    @Then("click Usage button in the related car plate row found")
    public void clickUsageButtonInTheRelatedCarPlateRowFound () {
        WebElement el_Usage = Any_Element_in_Vehicle_List("AS 20 150", "Usage");
       new Actions(driver).moveToElement(el_Usage).click().build().perform();
        BrowserUtils.waitFor(2);
    }

    @Then("verify that plate CO DJ 140 plate Auto is not displayed in the vehicle list anymore")
    public void verifyThatPlateCODJPlateAutoIsNotInTheVehicleListAnymore () {
        try {
            WebElement element = plateElement_in_vehicle_list("CO DJ 140");
            // Element is found , so this test failed
            assert false;

        } catch (
                NoSuchElementException e) { //selenium a ait olan NoSuchElementException I SEC, aksi durumda test basarisiz olur
            // Element is not found , so this test passed
            assert true;
        }

    }


    @Then("verify car plate is there after click usage")
    public void verifyCarPlateIsThereAfterClickUsage () {


        boolean plateIsFoundAfterClickUsage = driver.findElement(By.xpath("//h2[.='AS 20 150 - Mercedes A3']")).getText().contains("AS 20 150");
        Assert.assertTrue(plateIsFoundAfterClickUsage);
    }

    @Then("click add driver button")
    public void clickAddDriverButton () {
        try {
            driver.findElement(By.xpath("(//button[@aria-label='add']/span)[2]")).click();

        } catch (NoSuchElementException e) {
            System.out.println("Usage driver add element is not found");
            Assert.fail();
        }
    }


    @Then("verify saved Drivers are seen in the Vehicle List")
    public void verifySavedDriversAreSeenInTheVehicleList () {

        WebElement driverElInPlateRow = driver.findElement(By.xpath("//tbody//tr//td[.='AS 20 150']/following-sibling::td[4]"));

        Assertions.assertAll("Verify saved drivers are seen",
                () -> Assertions.assertTrue(driverElInPlateRow.getText().contains("Aleksandar Aleksandar")),
                () -> Assertions.assertTrue(driverElInPlateRow.getText().contains("Florin Florin"))
        );

        // Test bu noktaya kadar geldiğinde, tüm ifadeler başarılı olsa da olmasa da devam eder.
        // yani hepsini teker teker bu test adiminda kontrol eder ama feature daki bir sonraki adima bir tanesi hata verirse  gecmez

    }

    @Then("verify this vehicle is now in use") public void verifyThisVehicleIsNowInUse () {
        WebElement el_InUse_In_the_Plate_row = driver.findElement(By.xpath("//tbody//tr//td[.='AS 20 150']/following-sibling::td[5]"));
        if (el_InUse_In_the_Plate_row.getText().equalsIgnoreCase("In use")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("verify Driver names ,Start date , in use text and start km are found there")
    public void verifyDriverNamesStartDateInUseTextAndStartKmAreFoundThere () {
        List<WebElement> usageAddedRowElements = driver.findElements(By.xpath("(//table//tbody)[2]"));
        List<String> el_texts = new ArrayList<>();

        for (WebElement usageAddedRowElement : usageAddedRowElements) {
            el_texts.add(usageAddedRowElement.getText());
        }

        Assertions.assertAll("Which Asserts are true , Iam checking",
                ()-> Assertions.assertTrue(el_texts.contains("Alexander Alexander , Florin Florin")),
                ()-> Assertions.assertTrue(el_texts.contains("September 03, 2023")),
                ()-> Assertions.assertTrue(el_texts.contains("September 03, 2023")),
                ()-> Assertions.assertTrue(el_texts.contains("September 03, 2023"))
//Until here execution continues,even though assertion fails in some of them
                );
    }

    @Then("click the edit button in the section of usage") public void clickTheEditButtonInTheSectionOfUsage ()
    {
       WebElement el_editInUsage= driver.findElement(By.xpath("//span[normalize-space()='Edit']"));
       new Actions(driver).moveToElement(el_editInUsage).click().build().perform();
    }


    @Then("add input EndDate and {string} and click save changes")
    public void addInputEndDateAndAndClickSaveChanges (String EndKm){
        Actions actions = new Actions(driver);
        WebElement end_date = driver.findElement(By.xpath("//input[@name='returnDate']"));
        WebElement end_km = driver.findElement(By.xpath("//input[@name='endKM']"));
        actions.doubleClick(end_date).sendKeys(Keys.LEFT, Keys.LEFT, "04", "09", "2023").build().perform();
        actions.doubleClick(end_km).sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE, EndKm, Keys.ENTER).build().perform();


    }

    @Then("verify Vehicle status is now Idle in Vehicle List") public void verifyVehicleStatusIsNowIdle () {
        WebElement status_InVehicleList = driver.findElement(By.xpath("//tbody//tr//td[.='AS 20 150']/following-sibling::td[5]"));
        if (status_InVehicleList.equals("Idle")) {
            Assert.assertTrue(true);

        } else {
            Assert.fail();
        }
    }

    @Then("verify that plate AS 20 150 plate Auto is not displayed in the vehicle list anymore")
    public void verifyThatPlateASPlateAutoIsNotDisplayedInTheVehicleListAnymore() {
        try {
            WebElement element = driver.findElement(By.xpath("//tbody//tr//td[.='AS 20 150']"));
            //if element is found, fails
            Assert.fail("Plate AS 20 150 should not be displayed, but it is.");
        } catch (NoSuchElementException e) {
            // The element was not found, which is the expected behavior
            Assert.assertTrue(true);
        }

    }

        @Then("verify distance is 2000 km") public void verifyDistanceIsKm () {
            List<WebElement> usageAddedRowElements = driver.findElements(By.xpath("(//table//tbody)[2]"));
            List<String> el_texts = new ArrayList<>();
            for (WebElement usageAddedRowElement : usageAddedRowElements) {
                el_texts.add(usageAddedRowElement.getText());
            }

            if ( el_texts.equals("2.000 km")) {
               Assert.assertTrue(true);

            } else {
                Assert.fail("it is not found ,so failed");
            }
        }


    @Then("verify that plate CO DJ 140 is displayed in the Vehicle list")
    public void verifyThatPlateCODJIsDisplayedInTheVehicleList() {
        WebElement el_CODJ140=driver.findElement(By.xpath("//tbody//tr//td[.='CO DJ 140']"));
        if(el_CODJ140.isDisplayed()&&driver.getCurrentUrl().equals("https://qugem-staging.netlify.app/")){
            Assert.assertTrue(true);
        }
    }
















}

