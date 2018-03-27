package com.adyax.ruinart.automation;

import org.openqa.selenium.By;

public class ArtistLandingPage {
    public static final By info_text_aggrement = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/p/text()");
    public static final By pdf_link_cross = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/span/span/svg");
    public static final By pdf_link = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/p/a");
    public static final By coat_of_arms = By.xpath("//*[@id=\"drupal-modal\"]/div/div[1]/div[1]/div");
    public static final By location_name = By.xpath("//*[@id=\"agegate-form\"]/fieldset/div[1]/div[1]/div/span/span[1]");
    public static final By date_birth = By.xpath("//*[@id=\"agegate-date\"]/div[3]/span/span[1]");
    public static final By submit_birth_button = By.xpath("//*[@id=\"agegate-form\"]/fieldset/div[3]");
    public static final By additional_info = By.xpath("//*[@id=\"mCSB_1_container\"]");



}
