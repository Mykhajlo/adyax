package com.adyax.ruinart.automation.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import static com.adyax.ruinart.automation.Utils.*;
/**
 * @author mykail
 */

public class FirstTest {
    private static final Logger LOGGER = Logger.getLogger(FirstTest.class);
    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = setupEnvironment();
    }

    @BeforeMethod
    public void openPage() throws InterruptedException {
        openAgeGate(driver);
    }

    @AfterClass
    public void tearDown() {
//      driver.close();
        driver.quit();
    }
    @Test
    public void FirstTestStart () throws Exception{
        Thread.sleep(10000);
        LOGGER.info("Test is finished");
    }
}
