package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.sql.DriverManager.getDriver;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class NewsletterPage {
    private static final Logger LOGGER = Logger.getLogger(NewsletterPage.class);
    public static final By newsletter_title = By.xpath("//*[@id=\"webform-submission-newsletter-newsletter-12-add-form\"]/fieldset/h1");
    public static final By newsletter_subtitle = By.xpath("//*[@id=\"webform-submission-newsletter-newsletter-12-add-form\"]/fieldset/p");

    public static final By email_field = By.xpath("//*[@id=\"edit-email-address\"]");
    public static final By user_name = By.xpath("//*[@id=\"edit-first-name\"]");
    public static final By user_surname = By.xpath("//*[@id=\"edit-last-name\"]");
    public static final By user_location = By.xpath("//*[@id=\"webform-submission-newsletter-newsletter-12-add-form\"]/fieldset/div[2]/div/div[4]/div/span");
    public static final By test_location = By.xpath("//*[@id=\"webform-submission-newsletter-newsletter-12-add-form\"]/fieldset/div[2]/div/div[4]/div/span/div/div/span/div/span/ul/li[91]");


    public static final By day = By.xpath("//*[@id=\"edit-birth-date\"]/div[1]/span");
    public static final By month = By.xpath("//*[@id=\"edit-birth-date\"]/div[2]/span");
    public static final By year = By.xpath("//*[@id=\"edit-birth-date\"]/div[3]/span");

    public static final By gdpr = By.xpath("//*[@id=\"edit-gdpr--wrapper\"]/div[2]/span");
   // public static final By gdpr_email_checkbox = By.xpath("//div[@class='form-item-gdpr-gdpr-use-email']");
    public static final By gdpr_email_checkbox = By.xpath("//div[contains(@class, 'form-item-gdpr-gdpr-use-email')]");

    public static final By gdpr_sms_checkbox = By.xpath("//div[contains(@class, 'form-item-gdpr-gdpr-use-sms js-form-item-gdpr-gdpr-use-sms')]");
    public static final By gdpr_sms_field = By.xpath("//*[@id=\"edit-gdpr-gdpr-sms-phone-number\"]");

    public static final By gdpr_phone_checkbox = By.xpath("//div[contains(@class, 'form-item-gdpr-gdpr-use-phone')]");
    public static final By gdpr_phone_field = By.xpath("//*[@id=\"edit-gdpr-gdpr-phone-number\"]");

    public static final By gdpr_address_checkbox = By.xpath("//div[contains(@class, 'form-item-gdpr-gdpr-use-postal')]");
    public static final By gdpr_address_field = By.xpath("//*[@id=\"edit-gdpr-gdpr-loaction-autocomplete\"]");

    public static final By affiliates_link = By.xpath("//*[@id=\"edit-gdpr-gdpr-agreement--description\"]/a[1]");
    public static final By affiliates_cross = By.xpath("/html/body/div[7]/div[1]/button");
    public static final By send_button = By.xpath("//*[@id=\"edit-actions-submit\"]");
    public static final By thanks_message_title = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/h1");
    public  static void fillEmail(WebDriver driver, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        index = 5 + (int)(Math.random() * ((100 - 5) + 1));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(newsletter_title, "class","active")));
        if(driver.findElement(email_field).isDisplayed()){
            driver.findElement(email_field).clear();
            driver.findElement(email_field).sendKeys("mrozputn" + index + "@adyax.com");
            LOGGER.info("Email : " + driver.findElement(email_field).getText());
        }
       }
    public  static void fillFirstName(WebDriver driver, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        index = 5 + (int)(Math.random() * ((100 - 5) + 1));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(user_name, "class","active")));
        if(driver.findElement(user_name).isDisplayed()){
            driver.findElement(user_name).clear();
            driver.findElement(user_name).sendKeys("Kroto-" + index + "-LO");
            LOGGER.info("User Name is filled");
        }
    }
    public  static void fillLastName(WebDriver driver, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        index = 5 + (int)(Math.random() * ((100 - 5) + 1));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(user_surname, "class","active")));
        if(driver.findElement(user_surname).isDisplayed()){
            driver.findElement(user_surname).clear();
            driver.findElement(user_surname).sendKeys("Tony-" + index + "-MS");
            LOGGER.info("User Name is filled");
        }
    }
    public  static void fillLocation (WebDriver driver, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(user_location));// Location dropdown is clickable
        LOGGER.info("Location dropdown is readysdsdsdsds");
        clickLocation(driver);
        WebElement element = driver.findElement(test_location);

        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        LOGGER.info("Location : " + element.getText());
        builder.click().perform();
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(user_location, "class","jcf-drop-active")));

    }
    public static void clickLocation (WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        //wait.until(ExpectedConditions.elementToBeClickable(user_location));// "Location" is clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(user_location));
        driver.findElement(user_location).click();// Click "Location"
    }
    public static void clickSend (WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        //wait.until(ExpectedConditions.elementToBeClickable(user_location));// "Location" is clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(send_button));
        driver.findElement(send_button).click();// Click "Location"
        LOGGER.info("Button is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(thanks_message_title));
    }
    public static void openAfiliates(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(affiliates_link));
        driver.findElement(affiliates_link).click();// Click ""
        LOGGER.info("Afiliates list is opened");
    }
    public static void closeAafiliates (WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(affiliates_cross));
        driver.findElement(affiliates_cross).click();// Click ""
        LOGGER.info("Afiliates list is closed");
    }
    public static void clickGDPR(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(gdpr));
        driver.findElement(gdpr).click();// Click ""
    }
    public static void clickEmailCheckbox(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(gdpr_email_checkbox));
        driver.findElement(gdpr_email_checkbox).click();// Click ""
        LOGGER.info("Email checkbox is clicked");
    }
    public static void clickSMSCheckbox(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(gdpr_sms_checkbox));
        driver.findElement(gdpr_sms_checkbox).click();// Click ""
        LOGGER.info("SMS checkbox is clicked");
    }
    public static void clickPhoneCheckbox(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(gdpr_phone_checkbox));
        driver.findElement(gdpr_phone_checkbox).click();// Click ""
        LOGGER.info("Phone checkbox is clicked");
    }
    public static void clickAddressCheckbox(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(gdpr_address_checkbox));
        driver.findElement(gdpr_address_checkbox).click();// Click ""
        LOGGER.info("Address checkbox is clicked");
    }
    public  static void fillSMS(WebDriver driver, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        index = 5 + (int)(Math.random() * ((100 - 5) + 1));
       // wait.until(ExpectedConditions.attributeContains(gdpr_sms_field, "id","jcf-checked"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(gdpr_sms_field));
        if(driver.findElement(gdpr_sms_field).isDisplayed()){
            driver.findElement(gdpr_sms_field).clear();
            driver.findElement(gdpr_sms_field).sendKeys("937-" + index + "-92");
            LOGGER.info("SMS field is filled");
        }else {
            LOGGER.info("SMS field is not available!!");
        }
    }
    public  static void fillPhone(WebDriver driver, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        index = 5 + (int)(Math.random() * ((100 - 5) + 1));
         wait.until(ExpectedConditions.visibilityOfElementLocated(gdpr_phone_field));
        if(driver.findElement(gdpr_phone_field).isDisplayed()){
            driver.findElement(gdpr_phone_field).clear();
            driver.findElement(gdpr_phone_field).sendKeys("937-" + index + "-92");
            LOGGER.info("Phone field is filled");
        } else {
            LOGGER.info("Phone field is not available!!");
        }
    }
    public  static void fillAddress(WebDriver driver, Integer index) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        index = 5 + (int)(Math.random() * ((99 - 5) + 1));
        // wait.until(ExpectedConditions.attributeContains(gdpr_sms_field, "id","jcf-checked"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(gdpr_address_field));
        if(driver.findElement(gdpr_address_field).isDisplayed()){
            driver.findElement(gdpr_address_field).clear();
            driver.findElement(gdpr_address_field).sendKeys( index + " East Avenue, Pitman, NJ, USA"  );
            LOGGER.info("Address field is filled");
        } else {
            LOGGER.info("Address field is not available!!");
        }
    }
}
