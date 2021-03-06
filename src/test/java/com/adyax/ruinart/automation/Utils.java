package com.adyax.ruinart.automation;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public static WebDriver driver;
    public static ChromeDriver setupEnvironment() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver.dmg");
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver_win.exe");
        }
        if (osName.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
        } else if (osName.contains("linux")
                || osName.contains("mpe/ix")
                || osName.contains("freebsd")
                || osName.contains("irix")
                || osName.contains("digital unix")
                || osName.contains("unix")) {
            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver_linux64");
        }
        //linux
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);
        //ChromeDriver driver = new ChromeDriver();
        Dimension d = new Dimension(1366, 768); // > HD resolution
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
        LOGGER.info("Test");
        wait.until(ExpectedConditions.elementToBeClickable(location_name_field));// Location dropdown is clickable
        Assert.assertTrue(ofNullable(driver.findElement((location_name_field))).isPresent());
        LOGGER.info("Location field is present");
        Assert.assertTrue(ofNullable(driver.findElement((date_birth_field))).isPresent());
        LOGGER.info("DateBirth field is present");
        selectLocation(driver);
        selectYear(driver);
        selectLanguage(driver,language_fr_fr);
        clickSubmitButton(driver);
        LOGGER.info(driver.getCurrentUrl());
}
    public static void loginFranceHomePage(WebDriver driver) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        driver.get(getURL());
        //driver.switchTo().alert().sendKeys("ruinart" + Keys.TAB + "geRu6eil");
        //driver.switchTo().alert().accept();
        //httpAuth(driver);
        driver.getWindowHandle();
        LOGGER.info("Test");
        //httpAuth(driver);
        acceptCookiesBanner(driver); // Accept Cookies Banner
        wait.until(ExpectedConditions.elementToBeClickable(location_name_field));// Location dropdown is clickable
        Assert.assertTrue(ofNullable(driver.findElement((location_name_field))).isPresent());
        LOGGER.info("Location field is present");
        Assert.assertTrue(ofNullable(driver.findElement((date_birth_field))).isPresent());
        LOGGER.info("DateBirth field is present");
        selectYear(driver);
        clickSubmitButton(driver);
        LOGGER.info("User at : " + driver.getCurrentUrl());
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
            input = new FileInputStream("src//test//resources//config");

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
    public static void scrollToElement(WebDriver driver, By element){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement elementFF = driver.findElement(element);
        je.executeScript("arguments[0].scrollIntoView(true);",elementFF); // now execute query which actually will scroll until that element is not appeared on page.
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(element));// Element is selected at dropdown
        //LOGGER.info("Your element : " + element.getText());
    }
    public static  void acceptCookiesBanner(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        if ((driver.findElement(cookies_banner)).isEnabled()){
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookies_banner));// "Accept" title is visible
            driver.findElement(cookies_banner).click();// Click "Accept"
            LOGGER.info("Cookies banner is accepted");
        }else
        LOGGER.info("Cookies banner is not present");
    }
    public static void httpAuth (WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.authenticateUsing(new UserAndPassword("ruinart", "geRu6eil"));
    }
    public static void takeScreenshot(WebDriver driver) throws Exception {
        String timeStamp;
        File screenShotName;
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//The below method will save the screen shot in d drive with name "screenshot.png"
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        screenShotName = new File("src//test//screenshots"+timeStamp+".png");
        FileUtils.copyFile(scrFile, screenShotName);

        String filePath = screenShotName.toString();
        String path = "";
        LOGGER.info(path);
    }
    /*public static  WebDriver getDriver(WebDriver driver) {
        LOGGER.info("Test is gogogogogog = " + driver);
        return driver;
    }*/
    /*public void failed(WebDriver driver){
        LOGGER.info("Test is gogogogogog = " + driver);
        File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File scrName = new File("C:\\Users\\adyax-021\\IdeaProjects\\ruinart_tests\\src\\test\\screenshots\\" + driver.getTitle() + ".png");
        try {
            FileUtils.copyFile(scrFile,scrName);
            Reporter.log("<br><img scr ='" + scrName + "' height ='400' width = '400'/><br>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
