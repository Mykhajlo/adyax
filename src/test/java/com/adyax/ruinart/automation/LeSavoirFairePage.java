package com.adyax.ruinart.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class LeSavoirFairePage {
    private static final Logger LOGGER = Logger.getLogger(LeSavoirFairePage.class);
    public static final By bottom_arrow_button = By.xpath("//span[@class='icon-scroll small-arrow']");
    public static final By right_arrow_button = By.xpath("//button[@aria-label='Next']");
    public static final By left_arrow_button = By.xpath("//button[@aria-label='Previous']");
    public static final By title_LeSavoirFairePage = By.xpath("//*[@id=\"ajax-redirect\"]/div/div/div[1]/div[1]/div/div/h1");
}
