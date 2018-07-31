package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LaMatierePage {
    private static final Logger LOGGER = Logger.getLogger(LaMatierePage.class);

    public static final By title_LaMatierePage = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/h1");
    public static final By laMatierePage_subtitle= By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/h3");
    public static final By laMatierePage_text= By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/p");

    public static final By loadLaMatierePage = By.xpath("/html");
    public static final By page_load = By.xpath("/html/body");
    public static final By page_load_content = By.xpath("//*[@id=\"ajax-redirect\"]/div");

    public static  By page_moving = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]");
    //*[@id="ajax-redirect"]/div/div/div[1]/div[1]
    public static final String page_moving_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String page_moving_part_1 = "]";

    //*[@id="ajax-redirect"]/div/div/div[1]/div[1]
    //*[@id="ajax-redirect"]/div/div/div[1]/div[2]
    //*[@id="ajax-redirect"]/div/div/div[1]/div[3]
//*[@id="ajax-redirect"]/div/div/div[1]/div[2]

    public static final By block_title_0 = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[2]/div/div/h2");
    public static final By block_title_1 = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[3]/div/div/h2");
    public static final By block_title_2 = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[4]/div/div/h2");
    public static final By footer_text = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[5]/div/div[1]/footer/div/h2");

    public static  By next_arrow_slide = By.xpath("//button[@aria-label='Next']");
    public static final String next_arrow_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String next_arrow_part_1 = "]/div/div/div/ul/button[2]";
    public static  By block = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[3]/div/div/div/ul/div/div/li[1]");
    public static final String block_part_0 = "//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[";
    public static final String block_part_1 = "]/div/div/div/ul/div/div/li[";
    public static final String block_part_2 = "]";

    public static void checkLaMatiereDetail (WebDriver driver, Integer slide){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        String title = driver.findElement(title_LaMatierePage).getText();
        String subtitle = driver.findElement(laMatierePage_subtitle).getText();
        String main_text = driver.findElement(laMatierePage_text).getText();
        LOGGER.info("LaMatiere title = " + title);
        LOGGER.info("LaMatiere subtitle = " + subtitle);
        LOGGER.info("LaMatiere text : " + main_text);
    }
    public static void scrollToSomeElement (WebDriver driver, Integer slide, By element){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
       // page_moving = By.xpath(page_moving_part_0 + slide + page_moving_part_1);
        //wait.until(ExpectedConditions.attributeContains(page_moving, "class","active fp-completely"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load, "class","loading")));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(page_load_content, "class","anim-start")));
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        String title = webElement.getText();
        LOGGER.info("Block title = " + title);
    }
    public  static void clickRightArrowLaMatiere(WebDriver driver, Integer slide, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class); //*[@id="ajax-redirect"]/div/div/div[1]/div[4]
        next_arrow_slide = By.xpath(next_arrow_part_0 + slide + next_arrow_part_1);
        block = By.xpath(block_part_0 + slide + block_part_1 + index + block_part_2);
        wait.until(ExpectedConditions.attributeContains(block, "class","slick-current slick-active"));
        LOGGER.info("TT---> " + (driver.findElement(block)).getAttribute("class").toString());
        if(!(driver.findElement(next_arrow_slide)).getAttribute("class").contains("slick-next slick-arrow slick-disabled")){
            wait.until(ExpectedConditions.elementToBeClickable(next_arrow_slide));
            driver.findElement(next_arrow_slide).click();// Click "Right"
            LOGGER.info("Right arrow button is clicked .");
            wait.until(ExpectedConditions.attributeToBe(next_arrow_slide, "aria-disabled","true"));
        }else {
            LOGGER.info("Right arrow button is not available !");//*[@id="ajax-redirect"]/div/div/div[1]/div[3]/div/div/div/ul/button[2]
        }
    }
}
