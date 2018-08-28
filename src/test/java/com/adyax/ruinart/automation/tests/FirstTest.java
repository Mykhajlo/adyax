package com.adyax.ruinart.automation.tests;

import com.adyax.ruinart.automation.MainTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import static com.adyax.ruinart.automation.HomePage.*;
import static com.adyax.ruinart.automation.NewsletterPage.user_location;
import static com.adyax.ruinart.automation.Utils.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * @author mykhail
 */
///@Listeners(Listener.class)
public class FirstTest extends MainTest{
    private static final Logger LOGGER = Logger.getLogger(FirstTest.class);
   // public static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = setupEnvironment();
    }

    @BeforeMethod
    public void openPage() throws InterruptedException {
        openAgeGate(driver);
    }

    @AfterClass
    public void tearDown() {
//      driver.close();
        driver.quit();
    }
    @Test(description = "First initial test for app")
    //@Description("Test Description: Login test")
    public void FirstTestStart () throws Exception{
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));// Header dropdown is clickable
//        WebElement file_input = driver.findElement(header);
//        file_input.sendKeys("C:\\Selenium\\ImageUpload_FF.exe");
        Assert.assertTrue(user_location.findElement(driver).isEnabled());
        //failed(driver);
        LOGGER.info("Test is finished");
       // Reporter.log("Test is finished");
    }
}
