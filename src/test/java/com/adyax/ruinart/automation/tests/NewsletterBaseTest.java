package com.adyax.ruinart.automation.tests;

import com.adyax.ruinart.automation.MainTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.adyax.ruinart.automation.HomePage.header;
import static com.adyax.ruinart.automation.HomePage.openNewsletterPage;
import static com.adyax.ruinart.automation.NewsletterPage.*;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;

import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class NewsletterBaseTest extends MainTest {
    private static final Logger LOGGER = Logger.getLogger(NewsletterBaseTest.class);
    //public static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = setupEnvironment();
    }

    @BeforeMethod
    public void openPage() throws InterruptedException {
        loginFranceHomePage(driver);
    }
    @AfterClass
    public void tearDown() {
        //driver.close();
        driver.quit();
    }
    @Test
    public void NewsletterFeatureTest () throws Exception {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        Integer slide = 1;
        Integer index = 1;
        LOGGER.info("Header is present");
        openNewsletterPage(driver);
        fillEmail(driver,index);
        fillFirstName(driver,index);
        fillLastName(driver,index);
        fillLocation(driver,index);
        clickGDPR(driver);
        openAfiliates(driver);
        //Thread.sleep(2000);
        closeAafiliates(driver);
        clickEmailCheckbox(driver);
        clickSMSCheckbox(driver);
        fillSMS(driver, index);
        clickAddressCheckbox(driver);
        clickPhoneCheckbox(driver);
        fillPhone(driver, index);
        fillAddress(driver, index);
        //Thread.sleep(5000);
        clickSend(driver);
       // Thread.sleep(5000);
    }
}
