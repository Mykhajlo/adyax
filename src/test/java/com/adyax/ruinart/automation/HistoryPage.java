package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static com.adyax.ruinart.automation.HomePage.header;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HistoryPage {
    private static final Logger LOGGER = Logger.getLogger(HistoryPage.class);
    public static final By loadHistoryPage = By.xpath("/html");
    public static final By title_HistoryPage = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/h1");
    public static  By page_moving = By.xpath("//*[contains(@class,'pace-done')]");
    public static final String page_moving_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String page_moving_part_1 = "]";
    public static  By bottom_arrow = By.xpath("//span[@class='icon-scroll small-arrow']");
    public static final String bottom_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String bottom_arrow_part_1 = "]/span";
    public static final By page_load = By.xpath("/html/body");
    public static final By page_load_content = By.xpath("//*[@id=\"ajax-redirect\"]/div");
    public static final By top_button = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/button");

    public static  By slide_title = By.xpath("");
    public static final String slide_title_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String slide_title_part_1 = "]/div/div/h2";

    public  static void clickBottomArrowHistoryPage(WebDriver driver, Integer slide) throws InterruptedException {
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
            LOGGER.info("Bottom arrow is clicked");
        }else {
            LOGGER.info("Bottom arrow button is not available");
        }
    }
    public static By slideTitleHistoryPage(WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        slide_title = By.xpath(slide_title_part_0 + slide + slide_title_part_1);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
       if (driver.findElement(slide_title).getText().isEmpty())
       {
           wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
       }
        //LOGGER.info("Header is present = " + driver.findElement(slide_title).getText());
        return slide_title;
    }
    public static void clickUpButtonHistoryPage(WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        if (driver.findElement(top_button).isDisplayed()){
            wait.until(ExpectedConditions.attributeContains(top_button, "class","is-show"));
            driver.findElement(top_button).click();// Click "Top"
            LOGGER.info("Top button is clicked");
            wait.until(ExpectedConditions.visibilityOfElementLocated(title_HistoryPage));
        }else {
            LOGGER.info("Top button is not available");
        }
    }
}
