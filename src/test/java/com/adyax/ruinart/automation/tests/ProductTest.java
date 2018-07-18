package com.adyax.ruinart.automation.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.adyax.ruinart.automation.HomePage.*;

import static com.adyax.ruinart.automation.ProductPage.*;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;
import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ProductTest {
    private static final Logger LOGGER = Logger.getLogger(ProductTest.class);
    public static WebDriver driver;

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
    public void ProductPageTest () throws Exception {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        int slide = 1;
        LOGGER.info("Header is present");
        openMenu(driver);
        Assert.assertTrue(menu_block.findElement(driver).isEnabled());
        LOGGER.info("Menu is present");
        openMenuPage(driver, 3, 2, loadProductPage);
        //Thread.sleep(2000);
        LOGGER.info("User at : " + checkUrlProductPage(driver,slide) );
        String url1 = checkUrlProductPage(driver,slide);
        clickRightArrowSliderProductPage(driver,slide);
        LOGGER.info("User at : " + checkUrlProductPage(driver,slide) );
        clickLeftArrowProductPage(driver,slide);
        LOGGER.info("User at : " + checkUrlProductPage(driver,slide));
        String url2 = checkUrlProductPage(driver,slide);
        Assert.assertTrue(url1.equals(url2));

        //Thread.sleep(2000);
        LOGGER.info("Test is passed");
    }
}
