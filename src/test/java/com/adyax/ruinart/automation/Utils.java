package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.adyax.ruinart.automation.AgeGatePage.*;
import static java.util.Optional.ofNullable;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author mykhail on 21.11.17.
 */
public class Utils {
    private static final Logger LOGGER = Logger.getLogger(Utils.class);


    public static ChromeDriver setupEnvironment() {
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver.dmg");
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver_win.exe");
        }
        if (osName.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
        }
        //linux
        ChromeDriver driver = new ChromeDriver();
        Dimension d = new Dimension(1400, 900); // > HD resolution
        driver.manage().window().setSize(d);
        //driver.manage().window().maximize(); // full size  of screen
        return driver;
    }
    public static void openAgeGate(WebDriver driver) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        //driver.get("https://pp2.ruinart.com/fr-e");
        driver.get(getURL());
        driver.getWindowHandle();
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(coat_of_arms));// "R" coat of arms is visible
        Assert.assertTrue(ofNullable(driver.findElement((location_name_filed))).isPresent());
        LOGGER.info("Location field is present");
        Assert.assertTrue(ofNullable(driver.findElement((date_birth_field))).isPresent());
        LOGGER.info("DateBirth field is present");
}
    public static void openHomePageAnonymous (WebDriver driver, String login, String password)throws InterruptedException{
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(location_name));// "Location" title is visible
        // selectLocation(driver);
        //selectYear(driver);
        clickSubmitButton(driver);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        for (String handleGame : driver.getWindowHandles()) {
            driver.switchTo().window(handleGame);
        }
        LOGGER.info(driver.getCurrentUrl());
        //Open url
    }
    public static String getURL() {
        Properties prop = new Properties();
        InputStream input;
        String link = new String();
        try {
            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);
            // get the property value and print it out
            LOGGER.info(prop.getProperty("pp_link_fr_e"));
            link = prop.getProperty("pp_link_fr_e");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return link;
        }

}
