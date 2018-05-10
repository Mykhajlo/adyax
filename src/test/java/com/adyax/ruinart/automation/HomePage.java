package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;

public class HomePage {
    private static final Logger LOGGER = Logger.getLogger( HomePage.class);
    public static final By ruinart_logo_arms = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/a[1]/span[1]/svg");
    public static final By ruinart_logo_name = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/a[1]/span[2]/svg");
    public static final By ruinart_logo_text = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/a[1]/span[3]/svg");
    public static final By newsletter_button = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/a[2]/span/span/svg");
    public static final By menu_button = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/span/span[1]/span/svg");
    public static final By header = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/header");
    public static final By bottom_arrow = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/span");
    // slide 2 elements
    //public static final By prev_arrow_slide_first = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/button[1]");
    public static final By prev_arrow_slide_first = By.xpath("//button[@aria-label='Previous']");
    //public static final By next_arrow_slide_first = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/button[2]");
    public static final By next_arrow_slide_first = By.xpath("//button[@aria-label='Next']");
    public static final By test = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div");
    public static final By discover_button = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[2]/div/div/ul/div/div/li[2]/div/div[2]/div/a");
    public static final By first_slide_dot_button = By.xpath("//*[@id=\"slick-slide00\"]/button");
    public static final By slide_dot_button = By.xpath("//*[@id=\"slick-slide07\"]/button");
    //public static final String wine_title_part_1 = "//*[@id="ajax-redirect"]/div/div/div[1]/div[2]/div/div/ul/div/div/li[";
    public static final String wine_title_part_1 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li[";
    public static final String wine_title_part_2 = "]/div/div[2]/div/h2";
    public static  Integer index = 1;
    public static By wine_title = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li["+ index +"]/div/div[2]/div/h2");

    //public static final By wine_title1 = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li[6]/div/div[2]/div/h2");
     public static final By slide_block = By.xpath("//li");

                                                    //*[@id="ajax-redirect"]/div/div/div[1]/div[2]/div/div/ul/div/div/li[6]/div/div[2]/div/h2
    //public static final By wine_title = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li[2]/div/div[2]/div/h2");
    public static final By wine_description = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[2]/div/div/ul/div/div/li[4]/div/div[2]/div/p");
    // slide actualites/news elements
    public static final By prev_arrow_slide_news = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/button[1]");
    public static final By next_arrow_slide_news = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/button[2]");
    public static final By view_first_buttton = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[2]/div[1]/a");
    public static final By view_second_buttton = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[3]/div[1]/a");
    public static final By view_third_buttton = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[4]/div[1]/a");
    public static final By text_slide_slider_first = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[2]/div[1]/h3");
    public static final By text_slide_slider_second = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[3]/div[1]/h3");
    public static final By text_slide_slider_third = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[4]/div[1]/h3");
    public static final By dot_button_news = By.xpath("//*[@id=\"slick-slide12\"]/button");


    //social networks access
    public static final By facebook_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[1]/li[1]/a/span/span/svg");
    public static final By twitter_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[1]/li[2]/a/span/span/svg");
    public static final By instagram_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[1]/li[3]/a/span/span/svg");
    public static final By youtube_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[1]/li[4]/a/span/span/svg");
    // footer menu
    public static final By personal_data_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[1]/a");
    public static final By legal_notes_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[2]/a");
    public static final By newsletter_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[3]/a");
    public static final By espace_presse_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[4]/a");
    // language
    public static final By en_language = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[2]/li[6]/ul/li[1]/a");
    public static final By fr_language = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[2]/li[6]/ul/li[2]/a");
    public static final By it_language = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[2]/li[6]/ul/li[3]/a");
    public static final By de_language = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[2]/li[6]/ul/li[4]/a");

    public  static void returnToHomepage(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        //wait.until(ExpectedConditions.elementToBeClickable(bottom_arrow));// "Header"
        //refresh current page
        driver.navigate().refresh();
        //wait.until(ExpectedConditions.elementToBeClickable(ruinart_logo_name));// "Header" is present
        wait.until(ExpectedConditions.visibilityOfElementLocated(ruinart_logo_name));
        driver.findElement(ruinart_logo_name).click();// Click "Header" -> homepage is opened

    }

    public  static void clickBottomArrow(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(bottom_arrow));// "Right" is clickable
        driver.findElement(bottom_arrow).click();// Click "Right"
    }
    public  static void clickLeftArrowSlider(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        //wait.until(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating"));// "Left" is clickable
        if(!(driver.findElement(prev_arrow_slide_first)).getAttribute("class").contains("slick-prev slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.elementToBeClickable(prev_arrow_slide_first));// "Right" is clickable
            driver.findElement(prev_arrow_slide_first).click();// Click "Left"
        }else {
            LOGGER.info("Left arrow button is not available");
        }

    }
    public  static void clickRightArrowSlider(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        if(!(driver.findElement(next_arrow_slide_first)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.elementToBeClickable(next_arrow_slide_first));// "Right" is clickable
            driver.findElement(next_arrow_slide_first).click();// Click "Right"
        }else {
            LOGGER.info("Right arrow button is not available");
        }
    }
    public  static void showWineTitle(WebDriver driver, Integer index){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        LOGGER.info("test->>>> : " + index);
        wine_title = By.xpath(wine_title_part_1 + index + wine_title_part_2);
        //wine_title = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li["+ index +"]/div/div[2]/div/h2");
        LOGGER.info("Next wine is displayed : " + driver.findElement(wine_title).getText());
    }
    public  static void clickDotSlider(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        //wait.until(ExpectedConditions.elementToBeClickable(next_arrow_slide_first));// "Right" is clickable
        driver.findElement(slide_dot_button).click();// Click "Dot"
    }

}
