package com.adyax.ruinart.automation.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.adyax.ruinart.automation.HomePage.*;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;
import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePageBottleSliderTest {
    private static final Logger LOGGER = Logger.getLogger(FirstTest.class);
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
//      driver.close();
        driver.quit();
    }
    @Test
    public void HomePageBottleSliderStart () throws Exception{
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));// is clickable
        //Thread.sleep(5000);
        //scrollToElement(driver, next_arrow_slide_first);
        clickBottomArrow(driver);
       // Thread.sleep(2000);
        clickRightSlider(driver);
        String vine = driver.findElement(wine_title).getText();
        LOGGER.info("Next Vine is displayed : " + vine);
        //scrollToElement(driver, prev_arrow_slide_first);
       // Thread.sleep(2000);
        clickLeftSlider(driver);
        LOGGER.info("Next Vine is displayed : " + driver.findElement(wine_title).getText());
        //Thread.sleep(2000);
        clickRightSlider(driver);
        LOGGER.info("Test is finished");
    }
}
