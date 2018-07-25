package com.adyax.ruinart.automation.tests;

import com.adyax.ruinart.automation.MainTest;
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

import static com.adyax.ruinart.automation.HistoryPage.*;
import static com.adyax.ruinart.automation.HomePage.*;
import static com.adyax.ruinart.automation.LeSavoirFairePage.slideTitleLeSavoirFairePage;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;
import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class MaisonRuinartTest extends MainTest {
    private static final Logger LOGGER = Logger.getLogger(MaisonRuinartTest.class);
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
    public void MaisonRuinartPageTest () throws Exception {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        int slide = 1;
        Assert.assertTrue(header.findElement(driver).isEnabled());
        LOGGER.info("Header is present");
        openMenu(driver);
        Assert.assertTrue(menu_block.findElement(driver).isEnabled());
        LOGGER.info("Menu is present");
        openMenuPage(driver, 1,1,loadHistoryPage);
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title_HistoryPage));
        Assert.assertTrue(title_HistoryPage.findElement(driver).isEnabled());
        LOGGER.info("Header is present = " + driver.findElement(title_HistoryPage).getText());
        //Thread.sleep(2000);
        clickBottomArrowHistoryPage(driver,slide);
        slide = slide +1;
        Assert.assertTrue((slideTitleHistoryPage(driver,slide)).findElement(driver).isEnabled());
        LOGGER.info("Slide title = " + driver.findElement(slideTitleHistoryPage(driver,slide)).getText());
        clickBottomArrowHistoryPage(driver,slide);
        slide = slide +1;
        Assert.assertTrue((slideTitleHistoryPage(driver,slide)).findElement(driver).isEnabled());
        LOGGER.info("Slide title = " + driver.findElement(slideTitleHistoryPage(driver,slide)).getText());
        clickBottomArrowHistoryPage(driver,slide);
        slide = slide +1;
        Assert.assertTrue((slideTitleHistoryPage(driver,slide)).findElement(driver).isEnabled());
        LOGGER.info("Slide title = " + driver.findElement(slideTitleHistoryPage(driver,slide)).getText());
        clickBottomArrowHistoryPage(driver,slide);
        slide = slide +1;
        clickUpButtonHistoryPage(driver,slide);
        slide = 1;
        //Thread.sleep(2000);
        LOGGER.info("Test is finished");
    }
}
