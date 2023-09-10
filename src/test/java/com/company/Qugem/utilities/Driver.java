package com.company.Qugem.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


   // Creating a private constructor, so we are closing  access to the object of this class from outside the class

    private Driver(){
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if (driverPool.get() == null){
            String browser =
                    System.getProperty("browser") != null
                            ? browser = System.getProperty("browser")
                            : ConfigurationReader.getProperty("browser");

            switch (browser) {

                case "chrome" ->{
                    driverPool.set(new ChromeDriver());
                    break;
                }

                case "chrome-headless"->{
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(options));
                    break;
                }

                case "firefox"->{
                   // WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                }

                case "firefox-headless"->{
                    //WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions op = new FirefoxOptions();
                    op.addArguments("-headless");
                    driverPool.set(new FirefoxDriver(op));
                    break;
                }


                case "ie"->{

                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;
                }


                case "edge"->{
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");

                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    /*
                      EdgeOptions options = new EdgeOptions();
                      driver = new EdgeDriver(options);
                     */
                    break;
                }


                case "edge-headless"->{

                    EdgeOptions opt = new EdgeOptions();
                    opt.addArguments("--headless=new");
                    driverPool.set(new EdgeDriver(opt));
                }



                case "safari"->{
                    //In safari browser , in developer section , we should allow test automation , then we can use
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;
                }
            }

        }

        return driverPool.get();

    }

    public static synchronized void closeDriver() {
        WebDriver driver = driverPool.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error while quitting the WebDriver: " + e.getMessage());
            } finally {
                driverPool.remove();
            }
        }
    }
}


//driverPool.get()  --  returns WebDriver
