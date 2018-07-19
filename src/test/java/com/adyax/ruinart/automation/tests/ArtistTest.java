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

import static com.adyax.ruinart.automation.ArtistPage.*;
import static com.adyax.ruinart.automation.HomePage.*;
import static com.adyax.ruinart.automation.ProductPage.loadProductPage;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;
import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ArtistTest {
    private static final Logger LOGGER = Logger.getLogger(ArtistTest.class);
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
    public void ArtistPageTest () throws Exception {
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
        openMenuPage(driver, 4, 1, loadArtistPage);
        //Thread.sleep(2000);
        checkArtistNameDetail(driver,slide);
        clickBottomArrowArtistPage(driver,slide);
        slide = slide+1;
        clickBottomArrowArtistPage(driver,slide);
        slide = slide+1;
        clickBottomArrowArtistPage(driver,slide);
        slide = slide+1;
        clickBottomArrowArtistPage(driver,slide);       //*[@id="ajax-redirect"]/div/div/div[1]/div[5]/div/div/ul/button[2]
        slide = slide+1;
        clickRightArrowCarouselArtistiques(driver,slide,index); //*[@id="ajax-redirect"]/div/div/div[1]/div[5]/div/div/div/ul/button[2]
        index = index + 1;
        clickRightArrowCarouselArtistiques(driver,slide,index); //*[@id="ajax-redirect"]/div/div/div[1]/div[5]/div/div/div/ul/button[2]
        index = index + 1;
       // clickLeftArrowCarouselArtistiques(driver,slide);
        /*clickRightArrowCarouselArtistiques(driver,slide,index);
        index = index + 1;
        clickRightArrowCarouselArtistiques(driver,slide,index);
        index = index + 1;*/
        Thread.sleep(2000);
        LOGGER.info("Test is passed");
    }
}
