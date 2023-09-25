package com.company.Qugem.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BrowserUtils {
    final private static WebDriver driver = Driver.getDriver();

    public static WebDriver getMydriver() {
        return driver;
    }


    // Returns a positive random number as integer between 0 to upper bound
    public static int randomNumber(int bound) {
        // creating an object of Random class
        Random random = new Random();
        // Generates random integer between 0 to upper bound
        int x = random.nextInt(bound);
        return x;
    }


    //  This method will accept int (in seconds) and execute Thread.sleep for given duration
    public static void sleep(int second) {

        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {


        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     *
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL) {
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInURL));
    }


    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text in a List of String.
     *
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement) {

        Select select = new Select(dropdownElement);
        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month <options> as a string
        List<String> actualOptionsAsString = new ArrayList<>();

        //add each element's text to the actualOptionsAsString List
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return actualOptionsAsString;

    }


    /**
     * This method will accept a group radio buttons as a List of WebElement.
     * It will loop through the List, and click to the radio button with provided attributeValue
     *
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {

        for (WebElement each : radioButtons) {

            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }

    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     *
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     *
     * @param locator
     * @return list of strings
     */
    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        //iter
        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void getElementsFromTagName(WebElement element, String TagName) {
        List<WebElement> elements = element.findElements(By.tagName(TagName));
        for (WebElement e : elements) {
            System.out.println(e.getText());
        }
    }


    /**
     * Waits for element matching the locator to be visible on the page
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {

        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                driver = Driver.getDriver();
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     *
     * @param by
     * @throws AssertionError if the element matching the provided locator is not found or not displayed
     */
    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element not visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);

        }
    }

    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     *
     * @param by
     * @throws AssertionError the element matching the provided locator is displayed
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element should not be visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();

        }
    }


    /**
     * Verifies whether the element is displayed on page
     *
     * @param element
     * @throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }


    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static synchronized void clickWithJS_withScrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static synchronized void clickWithJS_withoutScrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * Highlighs an element by changing its background and border color
     *
     * @param element
     */
    public static void highlight(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    /**
     * attempts to click on provided element until given time runs out
     *
     * @param element
     * @param timeout
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command, element);

    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command);

    }


    /**
     * This method will recover in case of exception after unsuccessful the click,
     * and will try to click on element again.
     *
     * @param by
     * @param attempts
     */
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                clickWithJS_withScrollIntoView(Driver.getDriver().findElement(by));
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                //print attempt
                e.printStackTrace();
                ++counter;
                //wait for 1 second, and try to click again
                waitFor(1);
            }
        }
    }

    /**
     * checks that an element is present on the DOM of a page. This does not
     * * necessarily mean that the element is visible.
     *
     * @param by
     * @param time
     */
    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * clean input box with keys ,then sendkeys("new value")
     *
     * @param inputElement
     * @param newInputvalue
     */
    public static void cleanInputBoxAndSendNewInput(WebElement inputElement, String newInputvalue) {
        Actions actions = new Actions(driver);
        actions.moveToElement(inputElement).doubleClick(inputElement).perform();
        inputElement.sendKeys(Keys.chord(Keys.COMMAND, "a")); // IN WINDOWS CONTROL
        inputElement.sendKeys(Keys.DELETE); //IN WINDOWS BACKSPACE
        //sends the new input value
        inputElement.sendKeys(newInputvalue);

    }

    /**
     * clean input box with javaScript
     * this code cleans and gives new value to the input box
     *
     * @param inputElement
     * @param inputValue
     */

    public static void cleanInputBoxAndSendNewInputWithJavaScript(WebElement inputElement, String inputValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputElement, inputValue);

    }

    public static void clickWithActionsByMovingToElement(WebElement el) {
        new Actions(driver).moveToElement(el).pause(1000).click();

    }


}
