package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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


}
