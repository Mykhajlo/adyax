package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ProductPage {
    private static final Logger LOGGER = Logger.getLogger(ProductPage.class);
    public static final By loadProductPage = By.xpath("/html");
    public static final By title_ProductPage = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/div/h1");

    public static  By page_moving = By.xpath("//*[contains(@class,'pace-done')]");
    public static final String page_moving_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String page_moving_part_1 = "]";
    public static  By bottom_arrow = By.xpath("//span[@class='icon-scroll small-arrow']");
    public static final String bottom_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String bottom_arrow_part_1 = "]/span";
    public static final By page_load = By.xpath("/html/body");
    public static final By page_load_content = By.xpath("//*[@id=\"ajax-redirect\"]/div");
    public static final By top_button = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/button");

    public static final By next_product = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/ul/a[2]");
    public static final By previous_product = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/ul/a[1]");

    public static  By next_arrow_slide = By.xpath("//button[@aria-label='Next']");
    public static final String next_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String next_arrow_part_1 = "]/div/div/div/ul/button[2]";

    public static  By prev_arrow_slide = By.xpath("//button[@aria-label='Previous']");
    public static final String prev_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String prev_arrow_part_1 = "]/div/div/div/ul/button[1]";

    public static String checkUrlProductPage (WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        for (String handleGame : driver.getWindowHandles()) {
            driver.switchTo().window(handleGame);
        }
        String url = driver.getCurrentUrl();
        return  url;
    }
    public  static void clickRightArrowSliderProductPage(WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        if(driver.findElement(bottom_arrow).isDisplayed()){
            driver.findElement(next_product).click();// Click "Right"
        }else {
            LOGGER.info("Right arrow button is not available");
        }
    }
    public  static void clickLeftArrowProductPage(WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        //prev_arrow_slide = By.xpath(prev_arrow_part_0 + slide + prev_arrow_part_1);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        if(!(driver.findElement(previous_product)).getAttribute("class").contains("slick-prev slick-arrow slick-disabled")){
                  driver.findElement(previous_product).click();// Click "Left"
        }else {
            LOGGER.info("Left arrow button is not available!");
        }

    }
}
