package com.adyax.ruinart.automation.tests;

import com.adyax.ruinart.automation.MainTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.adyax.ruinart.automation.ArtFairsPage.*;
import static com.adyax.ruinart.automation.HomePage.*;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;
import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ArtFairTest extends MainTest {
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
    public void ArtFairPageTest () throws Exception {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        Integer slide = 1;
        Integer index = 1;
        LOGGER.info("Header is present");
        openMenu(driver);
        Assert.assertTrue(menu_block.findElement(driver).isEnabled());
        LOGGER.info("Menu is present");
        openMenuPage(driver, 4, 3, artfair_page);
        checkArtFairsDetail(driver, slide);
        scrollToSomeElement(driver, artfair_block_title);
        scrollToSomeElement(driver, artfair_block_title_1);
        scrollToSomeElement(driver, artfair_block_title);
        scrollToSomeElement(driver, footer_text);
        Thread.sleep(5000);
    }
}
