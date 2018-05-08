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
        //driver.close();
        driver.quit();
    }

    @Test
    public void HomePageBottleArrowSliderStart () throws Exception{
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        //Thread.sleep(5000);

        clickBottomArrow(driver);
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(wine_title));
        String wine = driver.findElement(wine_title).getText();
        LOGGER.info("Next wine is displayed : " + wine);

        clickRightArrowSlider(driver);

        //scrollToElement(driver, prev_arrow_slide_first);
        //wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(slide_block, "class","slide-block slick-slide slick-current slick-active next-slide")));// "Left" is clickable

       // wait.until(ExpectedConditions.visibilityOfElementLocated(wine_title));
        Integer element_title = 2;
        By wine_title1 = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li["+ element_title +"]/div/div[2]/div/h2");
        wine = driver.findElement(wine_title1).getText();
        LOGGER.info("Next wine is displayed : " + wine);

        clickLeftArrowSlider(driver);

        //Thread.sleep(2000);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        element_title = 1;
        wine_title1 = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li["+ element_title +"]/div/div[2]/div/h2");
        wine = driver.findElement(wine_title1).getText();
        LOGGER.info("Next wine is displayed : " + wine);
        clickRightArrowSlider(driver);

        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        element_title = 2;
        wine_title1 = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li["+ element_title +"]/div/div[2]/div/h2");
        wine = driver.findElement(wine_title1).getText();
        LOGGER.info("Next wine is displayed : " + wine);

        clickRightArrowSlider(driver);
        clickLeftArrowSlider(driver);
/*
        while(ofNullable(driver.findElement(next_arrow_slide_first)).isPresent() &&
                !(driver.findElement(next_arrow_slide_first)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")) {
            clickRightArrowSlider(driver);
        }
        clickLeftArrowSlider(driver);
        clickRightArrowSlider(driver);
        LOGGER.info("Test 2");
        clickLeftArrowSlider(driver);
        clickRightArrowSlider(driver);
        clickDotSlider(driver);
        LOGGER.info("Test Dot Button - ok");
        clickLeftArrowSlider(driver);
        clickRightArrowSlider(driver);*/
        LOGGER.info("Test is finished");
    }
}
