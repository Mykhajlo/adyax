package com.adyax.ruinart.automation.tests;

import com.adyax.ruinart.automation.HomePage;
import com.adyax.ruinart.automation.MainTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.adyax.ruinart.automation.HomePage.*;
import static com.adyax.ruinart.automation.Utils.loginFranceHomePage;
import static com.adyax.ruinart.automation.Utils.setupEnvironment;
import static java.util.Optional.ofNullable;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePageBottleSliderTest extends MainTest {
    private static final Logger LOGGER = Logger.getLogger(HomePageBottleSliderTest.class);
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
    public void HomePageBottleArrowSliderStart () throws Exception{
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        Integer index = 2;
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        Assert.assertTrue(header.findElement(driver).isEnabled());
        LOGGER.info("Header is present");
        //int slide = 2;
        clickBottomArrowHomePage(driver);
        //Thread.sleep(2000);
        //wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        //driver.findElement(wine_title);
        wait.until(ExpectedConditions.presenceOfElementLocated(bottom_arrow));
        Assert.assertTrue(bottom_arrow.findElement(driver).isEnabled());
        LOGGER.info("Bottom arrow button is present");
        showWineTitle(driver,index);
        clickRightArrowSliderHomePage(driver,index);
        index = index + 1;
        showWineTitle(driver,index);
        //scrollToElement(driver, prev_arrow_slide_first);
        clickLeftArrowSliderHomePage(driver,index);
        index = index - 1;
        showWineTitle(driver,index);
        clickRightArrowSliderHomePage(driver,index);
        index = index + 1;
        showWineTitle(driver,index);
        clickRightArrowSliderHomePage(driver,index);
        index = index + 1;
        showWineTitle(driver,index);
        clickLeftArrowSliderHomePage(driver,index);
        index = index - 1;
        showWineTitle(driver,index);
        LOGGER.info("Bingo loop = " + index);

        //LOGGER.info("index = " + Integer.parseInt(driver.findElement(slide_dot_button).getText()));
        while(ofNullable(driver.findElement(next_arrow_slide)).isPresent() &&
                !(driver.findElement(next_arrow_slide)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")&&(index!= Integer.parseInt(driver.findElement(slide_dot_button).getText()) + 1)) {
            clickRightArrowSliderHomePage(driver,index);
            index = index + 1; //*[@id="slick-slide07"]/button/text()
            showWineTitle(driver,index);
            LOGGER.info("Bingo = " + index);
        }
        clickLeftArrowSliderHomePage(driver,index);
        index = index - 1;
        showWineTitle(driver,index);
        clickRightArrowSliderHomePage(driver,index);
        index = index + 1;
        showWineTitle(driver,index);
        clickLeftArrowSliderHomePage(driver,index);
        index = index - 1;
        showWineTitle(driver,index);
        clickRightArrowSliderHomePage(driver,index);
        index = index + 1;
        showWineTitle(driver,index);
        clickDotSlider(driver);
        clickLeftArrowSliderHomePage(driver,index);
        index = index - 1;
        showWineTitle(driver,index);
        clickRightArrowSliderHomePage(driver,index);
        LOGGER.info("Test is finished");
    }
}
