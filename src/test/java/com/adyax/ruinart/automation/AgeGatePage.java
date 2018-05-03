package com.adyax.ruinart.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class AgeGatePage {
    private static final Logger LOGGER = Logger.getLogger( AgeGatePage.class);

    public static final By info_text_aggrement = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/p/text()");
    public static final By pdf_link_cross = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/span/span/svg");
    public static final By pdf_link = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/p/a");
    public static final By coat_of_arms = By.xpath("//*[@id=\"drupal-modal\"]/div/div[1]/div[1]/div");
    public static final By location_name_field = By.xpath("//*[@id=\"agegate-form\"]/fieldset/div[1]/div[1]/div/span/span[1]");
    public static final By location_name  = By.xpath("//div[@class='jcf-option']"); // all locations 192 elements
    public static final By test = By.xpath("//*[@id=\"agegate-form\"]/fieldset/div[1]/div[1]/div/span/div/div/span/div/span/ul/li[12]/span");
    public static final By date_birth_field = By.xpath("//*[@id=\"agegate-date\"]/div[3]/span/span[1]");
    public static final By date_birth = By.xpath("//span[@class='jcf-option']"); // all date birth 105 elements
    public static final By submit_birth_button = By.xpath("//*[@id=\"agegate-form\"]/fieldset/div[3]");
    public static final By additional_info = By.xpath("//*[@id=\"mCSB_1_container\"]");

    public static final By language_field = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/h4");
    public static final By language_fr_fr = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/ul/li[1]/label");
    public static final By language_it = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/ul/li[2]/label");
    public static final By language_de = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/ul/li[3]/label");
    public static final By language_en_uk = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/ul/li[4]/label");
    // message if DOB not ok
    public static final By message_cannot_access = By.xpath("//*[@id=\"drupal-modal\"]/div/div[1]/div[1]/div[2]/ul/li");

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void clickPdfButton (WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(pdf_link));// "PDF" button is clickable
        driver.findElement(pdf_link).click();// Click "PDF" Button
    }
    public static void clickPdfCrossButton (WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(pdf_link_cross));// "PDF cross" button is clickable
        driver.findElement(pdf_link_cross).click();// Click "PDF cross" Button
    }
    public static void clickLocationDropdown (WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(location_name_field));// "Location" is clickable
        driver.findElement(location_name_field).click();// Click "Location"
    }
    public static void clickBirthDateDropdown  (WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(date_birth_field));// "BirthDate" is clickable
        driver.findElement(date_birth_field).click();// Click "BirthDate"
    }
    public static void clickSubmitButton(WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(submit_birth_button));// "Submit" button is clickable
        driver.findElement(submit_birth_button).click();// Click "Submit" Button
    }
    public static  void selectLocation (WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        //wait.until(ExpectedConditions.elementToBeClickable(test));
        LOGGER.info("Test 21");
        driver.findElement(test).click();// Click "Location"



        //Select drpLocation = new Select(driver.findElement(test));
       // drpLocation.selectByVisibleText("ALBANIA");
        /*LOGGER.info("Test 21");
        WebElement countrydropdown = driver.findElement(By.xpath("//span[@class='jcf-list-content']"));
        Select country = new Select(countrydropdown);
        country.selectByVisibleText("Japan");*/


        /*
        WebElement countryUL = driver.findElement(By.xpath("//span[@class='jcf-list-content']/ul"));
        List<WebElement> countriesList = countryUL.findElements(By.tagName("li"));
        for (WebElement li : countriesList) {
            if (li.getText().equals("Japan")) {
                li.click();
            }
        }  */
        LOGGER.info("Test 22");



        /*
        LOGGER.info("Test 21");
        List<WebElement> webElementLocation = driver.findElements(date_birth);
        LOGGER.info("Total responses = " + webElementLocation.size());
        String[] locationName = new String[webElementLocation.size()];
        Iterator<WebElement> iterator = webElementLocation.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            WebElement itemL = iterator.next();
            String labelR = itemL.getText();
            locationName[i] = labelR.trim();
            LOGGER.info(locationName[i]);
            //System.out.println(locationName[i]);
            // LOGGER.info("Results Response = " + responses[i]);
        }*/
    }
    public static  void selectYear (WebDriver driver){// not finished
        LOGGER.info("Test 22");
        List<WebElement> webElementBirthDate = driver.findElements(date_birth);
        LOGGER.info("Total responses = " + webElementBirthDate.size());
        int[] birthDate = new int[webElementBirthDate.size()];

        Iterator<WebElement> iterator = webElementBirthDate.iterator();
        LOGGER.info("Test 23");
        for (int i = 0; iterator.hasNext(); i++) {
            WebElement itemR = iterator.next();
            String labelR = itemR.getText();
            LOGGER.info(labelR);
           // birthDate[i] = Integer.parseInt(labelR);
           // LOGGER.info("Results Response = " + birthDate[i]);
        }
        LOGGER.info("Test 24");
        LocalDate localDate = LocalDate.now();
        String yearS = DateTimeFormatter.ofPattern("yyy").format(localDate);
        int yearI = Integer.parseInt(yearS);
        LOGGER.info(yearI);
        //System.out.println(yearI);
        for (int i = 0; i < webElementBirthDate.size(); i++) {
            // LOGGER.info("Results Response = " + responses[i]);
            if(birthDate[i] < (yearI -17)) {
            }
            }
        TreeSet<BirthDate> Years = new TreeSet<>();
        for (int i = 0; i < webElementBirthDate.size(); i++) {
            BirthDate selectedYear = new BirthDate(birthDate[i], webElementBirthDate.get(i));
            Years.add(selectedYear);
        }
        for (BirthDate good : Years)
            if (good.getYearValue() < (yearI -17) && good.getYearValue() > 1940) {
                LOGGER.info("Result is found: " + good.toString());
                good.getYearElement().click();
                LOGGER.info(good.getYearValue());
                LOGGER.info("Year is selected");
                break;
            }

        }
    public  static  void selectLanguage(WebDriver driver, By language){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.elementToBeClickable(language));// "PDF" button is clickable
        driver.findElement(language).click();// Click "PDF" Button
    }
}

