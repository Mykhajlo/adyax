package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LeSavoirFairePage {
    private static final Logger LOGGER = Logger.getLogger(LeSavoirFairePage.class);

    public static final By title_LeSavoirFairePage = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/h1");
    public static final By loadLeSavoirFairePage = By.xpath("/html");
    public static final By page_load = By.xpath("/html/body");
    public static final By page_load_content = By.xpath("//*[@id=\"ajax-redirect\"]/div");

    public static  By page_moving = By.xpath("//*[contains(@class,'pace-done')]");
    public static final String page_moving_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String page_moving_part_1 = "]";

    public static  By bottom_arrow = By.xpath("//span[@class='icon-scroll small-arrow']");
    public static final String bottom_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String bottom_arrow_part_1 = "]/span";

    public static  By next_arrow_slide = By.xpath("//button[@aria-label='Next']");
    public static final String next_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String next_arrow_part_1 = "]/div/div/div/ul/button[2]";

    public static  By prev_arrow_slide = By.xpath("//button[@aria-label='Previous']");
    public static final String prev_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String prev_arrow_part_1 = "]/div/div/div/ul/button[1]";

    public static  By slide_title = By.xpath("");
    public static final String slide_title_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String slide_title_part_1 = "]/div/div/h2";

     public  static void clickBottomArrowLeSavoirFairePage(WebDriver driver, Integer slide) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        LOGGER.info("page_moving = " + page_moving);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        bottom_arrow = By.xpath(bottom_arrow_part_0 + slide  + bottom_arrow_part_1);
        //*[@id="ajax-redirect"]/div/div/div[1]/div[1]/span
        if (driver.findElement(bottom_arrow).isDisplayed()){
            wait.until(ExpectedConditions.elementToBeClickable(bottom_arrow));
            LOGGER.info("bottom_arrow = " + bottom_arrow);
            driver.findElement(bottom_arrow).click();// Click "Bottom"
            LOGGER.info("Bottom arrow is clicked");//*[@id="ajax-redirect"]/div/div/div[1]/div[3]/div
        }else {
            LOGGER.info("Bottom arrow button is not available");
        }
    }
    public  static void clickRightArrowLeSavoirFairePage(WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class); //*[@id="ajax-redirect"]/div/div/div[1]/div[4]
        next_arrow_slide = By.xpath(next_arrow_part_0 + slide + next_arrow_part_1);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        LOGGER.info("page_moving = " + page_moving);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));

        if(!(driver.findElement(next_arrow_slide)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.attributeContains(next_arrow_slide, "aria-disabled","false"));
            //wait.until(ExpectedConditions.elementToBeClickable(next_arrow_slide));// "Right" is clickable
            driver.findElement(next_arrow_slide).click();// Click "Right"
        }else {
            LOGGER.info("Right arrow button is not available");
        }
    }
    public  static void clickLeftArrowLeSavoirFairePage(WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        prev_arrow_slide = By.xpath(prev_arrow_part_0 + slide + prev_arrow_part_1);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));

        if(!(driver.findElement(prev_arrow_slide)).getAttribute("class").contains("slick-prev slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.attributeContains(prev_arrow_slide, "aria-disabled","false"));
            //wait.until(ExpectedConditions.elementToBeClickable(prev_arrow_slide));// "Left" is clickable
            driver.findElement(prev_arrow_slide).click();// Click "Left"
        }else {
            LOGGER.info("Left arrow button is not available");
        }

    }
    public static By slideTitleLeSavoirFairePage(WebDriver driver, Integer slide){
        slide_title = By.xpath(slide_title_part_0 + slide + slide_title_part_1);
        LOGGER.info("slide_title = " + slide_title);
        LOGGER.info("Header is present = " + driver.findElement(slide_title).getText());
        return slide_title;
    }
}
