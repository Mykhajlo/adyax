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

public class GetScreenshots extends  MainTest {
    private static final Logger LOGGER = Logger.getLogger(GetScreenshots.class);
    public static File failed(String screenshotName)throws IOException{
        LOGGER.info("Test is gogogogogog = " + driver);
        File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        File scrName = new File("C:\\Users\\adyax-021\\IdeaProjects\\ruinart_tests\\src\\test\\screenshots\\" + driver.getTitle()+ "_" + screenshotName + "_" + timeStamp +".png");
       // File destination = new File (dest);
        try {
            FileUtils.copyFile(scrFile,scrName);
            Reporter.log("<br><img scr ='" + scrName + "' height ='400' width = '400'/><br>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scrName;
    }
}
