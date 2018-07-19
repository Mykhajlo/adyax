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

    public static  By next_carouse = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[6]/div/div/ul/button[2]");
    public static final String next_carousel_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String next_carousel_part_1 = "]/div/div/ul/button[2]";

    public static  By previous_carouse = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[6]/div/div/ul/button[1]");
    public static final String previous_carouse_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String previous_carouse_part_1 = "]/div/div/ul/button[1]";



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
        if(driver.findElement(next_product).isDisplayed()){
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
    public  static void clickBottomArrowProductPage(WebDriver driver, Integer slide) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        bottom_arrow = By.xpath(bottom_arrow_part_0 + slide  + bottom_arrow_part_1);
        LOGGER.info("Bottom arrow is clicked");
        if (driver.findElement(bottom_arrow).isDisplayed()){
            wait.until(ExpectedConditions.elementToBeClickable(bottom_arrow));
            driver.findElement(bottom_arrow).click();// Click "Bottom"
            LOGGER.info("Bottom button is clicked!");
        }else {
            LOGGER.info("Bottom arrow button is not available");
        }
    }
    public  static void clickRightArrowCarouselProductPage(WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class); //*[@id="ajax-redirect"]/div/div/div[1]/div[4]
        next_carouse = By.xpath(next_carousel_part_0 + slide + next_carousel_part_1);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));

        if(!(driver.findElement(next_carouse)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.attributeContains(next_carouse, "aria-disabled","false"));
            //wait.until(ExpectedConditions.elementToBeClickable(next_arrow_slide));// "Right" is clickable
            driver.findElement(next_carouse).click();// Click "Right"
        }else {
            LOGGER.info("Right arrow button is not available");
        }
    }
    public  static void clickLeftArrowCarouselProductPage(WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class); //*[@id="ajax-redirect"]/div/div/div[1]/div[4]
        previous_carouse = By.xpath(previous_carouse_part_0 + slide + previous_carouse_part_1);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));

        if(!(driver.findElement(previous_carouse)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.attributeContains(previous_carouse, "aria-disabled","false"));
            //wait.until(ExpectedConditions.elementToBeClickable(next_arrow_slide));// "Right" is clickable
            driver.findElement(previous_carouse).click();// Click "Right"
            LOGGER.info("Left arrow button is clicked!");
        }else {
            LOGGER.info("Left arrow button is not available!");
        }
    }
}
