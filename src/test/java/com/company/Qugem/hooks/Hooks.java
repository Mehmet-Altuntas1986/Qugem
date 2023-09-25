package com.company.Qugem.hooks;

import com.company.Qugem.pages.AbstractBasePage;
import com.company.Qugem.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.*;

import java.time.Duration;

public class Hooks extends AbstractBasePage {


    @BeforeAll()

    public static void Before_AllTests_I_Run_Once() {
        if (driver == null || driver != Driver.getDriver()) {
            driver = Driver.getDriver();
        }

    }

    // @Before: This annotation is used to perform setup actions before each scenario.

    @Before()   //before every scenario
    public void setUp() {

        try {

            System.out.println("Hooks Before is running before the Scenario");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.err.println("Error during WebDriver setup: " + e.getMessage());
        }
    }


    @BeforeStep
    public void beforeStep() {
        if (driver == null || driver != Driver.getDriver()) {
            driver = Driver.getDriver();
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Diğer adımlar ve senaryolar burada tanımlanır.


    @After()
    public void tearDown(Scenario scenario) throws InterruptedException {
        System.out.println("Attach screenshot to html report after a test execution");
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }


    }

    @AfterAll()
    public static void closeDriverAfterAllTestsRun() {
        Driver.closeDriver();

    }
}







/*
Be careful when you are using order
    in @Before io cucumber java  annotations    order=0  order=1  order=2   -->execution first 0 , then 1 then 2
but in @After io cucumber java  annotations     order=0  order=1  order=2   -->execution first 2 , then 1 then 0
https://www.youtube.com/watch?v=0S3mbjuwmMc

 @Before(order = 2,value ="@smoke")  parameters are like this
*/

