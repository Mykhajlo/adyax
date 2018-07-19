package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ArtistPage {
    private static final Logger LOGGER = Logger.getLogger(ArtistPage.class);
    public static final By loadArtistPage = By.xpath("/html");
    public static final By artist_Name = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/div[2]/h2");
    public static final By artist_Detail = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/div[2]/p");

    public static  By page_moving = By.xpath("//*[contains(@class,'pace-done')]");
    public static final String page_moving_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String page_moving_part_1 = "]";
    public static  By bottom_arrow = By.xpath("//span[@class='icon-scroll small-arrow']");
    public static final String bottom_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String bottom_arrow_part_1 = "]/span";

    public static final By page_load = By.xpath("/html/body");
    public static final By page_load_content = By.xpath("//*[@id=\"ajax-redirect\"]/div");

    public static  By next_artistiques = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[6]/div/div/ul/button[2]");
    public static final String next_artistiques_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String next_artistiques_part_1 = "]/div/div/div/ul/button[2]";

    public static  By previous_artistiques = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[6]/div/div/ul/button[1]");
    public static final String previous_artistiques_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String previous_artistiques_part_1 = "]/div/div/div/ul/button[1]";

    public static  By artistiques_block = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[5]/div/div/div/ul/div/div/li[1]");
    public static final String artistiques_block_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String artistiques_block_part_1 = "]/div/div/div/ul/div/div/li[";
    public static final String artistiques_block_part_2 = "]";


    public static void checkArtistNameDetail (WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        String artist_name = driver.findElement(artist_Name).getText();
        String artist_detail = driver.findElement(artist_Detail).getText();
        LOGGER.info("Artist name = " + artist_name);
        LOGGER.info("Artist info = " + artist_detail);

    }

    public  static void clickBottomArrowArtistPage(WebDriver driver, Integer slide) throws InterruptedException {
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
            LOGGER.info("Bottom button is clicked!");
        }else {
            LOGGER.info("Bottom  button is not available");
        }
    }
    public  static void clickRightArrowCarouselArtistiques(WebDriver driver, Integer slide, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class); //*[@id="ajax-redirect"]/div/div/div[1]/div[4]
        next_artistiques = By.xpath(next_artistiques_part_0 + slide + next_artistiques_part_1);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        artistiques_block = By.xpath(artistiques_block_part_0 + slide + artistiques_block_part_1 + index + artistiques_block_part_2);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        LOGGER.info("Bingo 1 = " + artistiques_block);
        wait.until(ExpectedConditions.attributeContains(artistiques_block, "class","slick-current"));
        if(!(driver.findElement(next_artistiques)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")){
           // Thread.sleep(2000);

           // wait.until(ExpectedConditions.attributeContains(next_artistiques, "aria-disabled","false"));
            driver.findElement(next_artistiques).click();// Click "Right"
            LOGGER.info("Right arrow button is clicked");
            artistiques_block = By.xpath(artistiques_block_part_0 + slide + artistiques_block_part_1 + (index + 3) + artistiques_block_part_2);
            wait.until(ExpectedConditions.attributeContains(artistiques_block, "class","slick-active"));
            LOGGER.info("Bingo");
        }else {
            LOGGER.info("Right arrow button is not available!");
        }
    }
    public  static void clickLeftArrowCarouselArtistiques (WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class); //*[@id="ajax-redirect"]/div/div/div[1]/div[4]
        previous_artistiques = By.xpath(previous_artistiques_part_0 + slide + previous_artistiques_part_1);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        if(!(driver.findElement(previous_artistiques)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.attributeContains(previous_artistiques, "aria-disabled","false"));
            driver.findElement(previous_artistiques).click();// Click "Left"
            LOGGER.info("Left arrow button is clicked!");
        }else {
            LOGGER.info("Left arrow button is not available!!");
        }
    }

}
