package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
    public static final By third_slide_dot_button = By.xpath("//*[@id=\"slick-slide03\"]/button");
    public static final By wine_title = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/ul/div/div/li[2]/div/div[2]/div/h2");
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

    public  static void clickBottomArrow(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(bottom_arrow));// "Right" is clickable
        driver.findElement(bottom_arrow).click();// Click "Right"
    }
    public  static void clickLeftSlider(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating")));// "Left" is clickable
        //wait.until(ExpectedConditions.attributeContains(test, "class","product-gallery gallery-is-animating"));// "Left" is clickable
        driver.findElement(prev_arrow_slide_first).click();// Click "Left"
    }
    public  static void clickRightSlider(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(next_arrow_slide_first));// "Right" is clickable
        driver.findElement(next_arrow_slide_first).click();// Click "Right"
    }

}
