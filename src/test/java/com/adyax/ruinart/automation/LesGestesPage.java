package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LesGestesPage {
    private static final Logger LOGGER = Logger.getLogger(LesGestesPage.class);

    public static final By title_LesGestesPage = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/h1");
    public static final By LesGestes_Detail = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/p");

    public static final By loadLesGestesPage = By.xpath("/html");
    public static final By page_load = By.xpath("/html/body");
    public static final By page_load_content = By.xpath("//*[@id=\"ajax-redirect\"]/div");

    public static  By page_moving = By.xpath("//*[contains(@class,'pace-done')]");
    public static final String page_moving_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String page_moving_part_1 = "]";

    public static  By next_arrow_slide = By.xpath("//button[@aria-label='Next']");
    public static final String next_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String next_arrow_part_1 = "]/div/div/div/ul/button[2]";

    public static  By prev_arrow_slide = By.xpath("//button[@aria-label='Previous']");
    public static final String prev_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String prev_arrow_part_1 = "]/div/div/div/ul/button[1]";

    public static  By slide_title = By.xpath("");
    //*[@id="ajax-redirect"]/div/div/div[1]/div[2]/div/div/h2
    //*[@id="ajax-redirect"]/div/div/div[1]/div[3]/div/div/h2
    public static final String slide_title_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String slide_title_part_1 = "]/div/div/h2";

    public static  By bottom_arrow = By.xpath("//span[@class='icon-scroll small-arrow']");
    public static final String bottom_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String bottom_arrow_part_1 = "]/span";

    public static  By slide_block = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[5]/div/div/div/ul/div/div/li[1]");
    public static final String slide_block_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String slide_block_part_1 = "]/div/div/div/ul/div/div/li[";
    public static final String slide_block_part_2 = "]";

    public static  By artistiques_block = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[3]/div/div/div/ul/div/div/li[1]");
                                                    //*[@id="ajax-redirect"]/div/div/div[1]/div[3]/div/div/div/ul/div/div/li[1]
    public static final String artistiques_block_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String artistiques_block_part_1 = "]/div/div/div/ul/div/div/li[";
    public static final String artistiques_block_part_2 = "]";

    public static void checkLesGestesTitleDetail (WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        String artist_name = driver.findElement(title_LesGestesPage).getText();
        String artist_detail = driver.findElement(LesGestes_Detail).getText();
        LOGGER.info("LesGestes title = " + artist_name);
        LOGGER.info("LesGestes info = " + artist_detail);
    }
    public  static void clickBottomArrowLesGestesPage(WebDriver driver, Integer slide) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        bottom_arrow = By.xpath(bottom_arrow_part_0 + slide  + bottom_arrow_part_1);
        if (driver.findElement(bottom_arrow).isDisplayed()){
            wait.until(ExpectedConditions.elementToBeClickable(bottom_arrow));
            driver.findElement(bottom_arrow).click();// Click "Bottom"
            LOGGER.info("Bottom button is clicked!!");
        }else {
            LOGGER.info("Bottom  button is not available");
        }
    }
    public  static void clickRightArrowLesGestes(WebDriver driver, Integer slide, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class); //*[@id="ajax-redirect"]/div/div/div[1]/div[4]
        next_arrow_slide = By.xpath(next_arrow_part_0 + slide + next_arrow_part_1);
        artistiques_block = By.xpath(artistiques_block_part_0 + slide + artistiques_block_part_1 + index + artistiques_block_part_2);
        wait.until(ExpectedConditions.attributeContains(artistiques_block, "class","slick-current slick-active"));
        LOGGER.info("TT---> " + (driver.findElement(artistiques_block)).getAttribute("class").toString());
        if(!(driver.findElement(next_arrow_slide)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.elementToBeClickable(next_arrow_slide));
            driver.findElement(next_arrow_slide).click();// Click "Right"
            LOGGER.info("Right arrow button is clicked.");
            wait.until(ExpectedConditions.attributeToBe(next_arrow_slide, "aria-disabled","true"));
        }else {
            LOGGER.info("Right arrow button is not available!");//*[@id="ajax-redirect"]/div/div/div[1]/div[3]/div/div/div/ul/button[2]
        }
    }
    public  static void clickLeftArrowLesGeste(WebDriver driver, Integer slide, Integer index){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        prev_arrow_slide = By.xpath(prev_arrow_part_0 + slide + prev_arrow_part_1);
        artistiques_block = By.xpath(artistiques_block_part_0 + slide + artistiques_block_part_1 + index + artistiques_block_part_2);
        wait.until(ExpectedConditions.attributeContains(artistiques_block, "class","slick-current slick-active"));
        LOGGER.info("UU---> " + (driver.findElement(artistiques_block)).getAttribute("class").toString());
        if(!(driver.findElement(prev_arrow_slide)).getAttribute("class").contains("slick-prev slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.attributeToBe(prev_arrow_slide, "aria-disabled","false"));
            driver.findElement(prev_arrow_slide).click();// Click "Left"
            LOGGER.info("Left arrow button is clicked.");
            wait.until(ExpectedConditions.attributeToBe(prev_arrow_slide, "aria-disabled","true"));
        }else {
            LOGGER.info("Left arrow button is not available.");
        }
        //*[@id="ajax-redirect"]/div/div/div[1]/div[3]/div/div/div/ul/div/div/li[1]
        //*[@id="ajax-redirect"]/div/div/div[1]/div[3]/div/div/div/ul/div/div/li[2]

    }
}
