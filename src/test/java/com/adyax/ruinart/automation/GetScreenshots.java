package com.adyax.ruinart.automation;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class  GetScreenshots extends  MainTest {
    private static final Logger LOGGER = Logger.getLogger(GetScreenshots.class);
    public static String failed(String screenshotName)throws IOException{
        LOGGER.info("Test is gogogogogog = " + driver);
        File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String scrName = "C:\\Users\\adyax-021\\IdeaProjects\\ruinart_tests\\src\\test\\screenshots\\" + driver.getTitle()+ "_" + screenshotName + "_" + timeStamp +".png";
        //String scrName = System.getProperty("user.dir") + driver.getTitle()+ "_" + screenshotName + "_" + timeStamp +".png";

        File destination = new File(scrName);
        //File destination = new File (scrName);
        try {
            FileUtils.copyFile(scrFile,destination);
            LOGGER.info("<br><img scr ='" + scrName + "' height ='400' width = '400'/><br>");
        } catch (IOException e) {
            LOGGER.info("Test is Bla-NE to" );
            e.printStackTrace();
        }
        return scrName;
    }
}
