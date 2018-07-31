package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ArtFairsPage {
    private static final Logger LOGGER = Logger.getLogger(ArtFairsPage.class);
    public static final By artfair_page = By.xpath("/html");
    public static final By artfair_title = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/h1");
    public static final By artfair_subtitle = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/h2");
    public static final By artfair_text = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/p");

    public static final By artfair_block_title = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[3]/div/div[1]/div/div[1]/h2");
    public static final By artfair_block_title_1 = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[3]/div/div[1]/div/div[6]/h2");
    public static final By footer_text = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[4]/div/div[1]/footer/div/h2");

    public static  By page_moving = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]");
    public static final String page_moving_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String page_moving_part_1 = "]";
    public static final By page_load = By.xpath("/html/body");
    public static final By page_load_content = By.xpath("//*[@id=\"ajax-redirect\"]/div");
    public static void checkArtFairsDetail (WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + (slide +1) + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        String title = driver.findElement(artfair_title).getText();
        String subtitle = driver.findElement(artfair_subtitle).getText();
        String main_text = driver.findElement(artfair_text).getText();
        LOGGER.info("ArtFairs title = " + title);
        LOGGER.info("ArtFairs subtitle = " + subtitle);
        LOGGER.info("ArtFairs text : " + main_text);
    }
    public static void scrollToSomeElement (WebDriver driver, By element){
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        String title = webElement.getText();
        LOGGER.info("Block title = " + title);
    }
}
