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

import static com.adyax.ruinart.automation.CrayeresPage.*;
import static com.adyax.ruinart.automation.HomePage.*;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;
import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LesCrayeresTest extends MainTest {
    private static final Logger LOGGER = Logger.getLogger(LesCrayeresTest.class);
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
    public void LesCrayeresPageTest () throws Exception {
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
        openMenuPage(driver, 1, 2, loadCrayersPage);
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title_CrayersPage));
        Assert.assertTrue(title_CrayersPage.findElement(driver).isEnabled());
        LOGGER.info("Header is present = " + driver.findElement(title_CrayersPage).getText());
        clickBottomArrowCrayeresPage(driver,slide);
        slide = slide +1;
        clickBottomArrowCrayeresPage(driver,slide);
        slide = slide +1;
        clickBottomArrowCrayeresPage(driver,slide);
        slide = slide +1;
        clickBottomArrowCrayeresPage(driver,slide);
        slide = slide +1;
        clickUpButtonCrayeresPage(driver,slide);
        slide = 1 ;
        LOGGER.info("Test is finished");
    }
}
