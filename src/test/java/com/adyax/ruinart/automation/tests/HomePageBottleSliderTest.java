package com.adyax.ruinart.automation.tests;

import com.adyax.ruinart.automation.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;

import static com.adyax.ruinart.automation.HomePage.*;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;
import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.Optional.ofNullable;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePageBottleSliderTest {
    private static final Logger LOGGER = Logger.getLogger(HomePageBottleSliderTest.class);
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
    public void HomePageBottleArrowSliderStart () throws Exception{
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        Integer index = 2;
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        LOGGER.info("KK");
        clickBottomArrow(driver);

        //Thread.sleep(2000);
        //wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        //driver.findElement(wine_title);
        wait.until(ExpectedConditions.presenceOfElementLocated(bottom_arrow));
        LOGGER.info("PP");
        showWineTitle(driver,index);
        clickRightArrowSlider(driver);
        index = index + 1;
        showWineTitle(driver,index);
        //scrollToElement(driver, prev_arrow_slide_first);
        clickLeftArrowSlider(driver);
        index = index - 1;
        showWineTitle(driver,index);
        clickRightArrowSlider(driver);
        index = index + 1;
        showWineTitle(driver,index);
        clickRightArrowSlider(driver);
        index = index + 1;
        showWineTitle(driver,index);
        clickLeftArrowSlider(driver);
        index = index - 1;
        showWineTitle(driver,index);

        while(ofNullable(driver.findElement(next_arrow_slide_first)).isPresent() &&
                !(driver.findElement(next_arrow_slide_first)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")) {
            clickRightArrowSlider(driver);
            index = index + 1;
            showWineTitle(driver,index);
        }
        clickLeftArrowSlider(driver);
        index = index - 1;
        showWineTitle(driver,index);
        clickRightArrowSlider(driver);
        index = index + 1;
        showWineTitle(driver,index);
        clickLeftArrowSlider(driver);
        index = index - 1;
        showWineTitle(driver,index);
        clickRightArrowSlider(driver);
        index = index + 1;
        showWineTitle(driver,index);
        clickDotSlider(driver);
        LOGGER.info("Test Dot Button - ok");
        clickLeftArrowSlider(driver);
        clickRightArrowSlider(driver);
        LOGGER.info("Test is finished");
    }
}
