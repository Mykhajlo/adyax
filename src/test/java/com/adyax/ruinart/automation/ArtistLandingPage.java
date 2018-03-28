package com.adyax.ruinart.automation;

import org.openqa.selenium.By;

public class ArtistLandingPage {
    public static final By info_text_aggrement = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/p/text()");
    public static final By pdf_link_cross = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/span/span/svg");
    public static final By pdf_link = By.xpath("//*[@id=\"drupal-modal\"]/div/div[2]/div/p/a");
    public static final By coat_of_arms = By.xpath("//*[@id=\"drupal-modal\"]/div/div[1]/div[1]/div");
    public static final By location_name_filed = By.xpath("//*[@id=\"agegate-form\"]/fieldset/div[1]/div[1]/div/span/span[1]");
    public static final By date_birth_field = By.xpath("//*[@id=\"agegate-date\"]/div[3]/span/span[1]");
    public static final By submit_birth_button = By.xpath("//*[@id=\"agegate-form\"]/fieldset/div[3]");
    public static final By additional_info = By.xpath("//*[@id=\"mCSB_1_container\"]");
    //search by data-index attribute (from 0 to 191)
    public static final By location_name = By.xpath("//*[@id=\"agegate-form\"]/fieldset/div[1]/div[1]/div/span/div/div/span/div/span/ul/li[1]/span");
    //search by data-index attribute (from 0 to 104)
    public static final By date_birth = By.xpath("//*[@id=\"agegate-date\"]/div[3]/span/div/div/span/div/span/ul/li[1]/span");
    // appeared after selecting NO France as location
    public static final By language_field = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/h4");
    public static final By language_fr_fr = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/ul/li[1]/label");
    public static final By language_it = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/ul/li[2]/label");
    public static final By language_de = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/ul/li[3]/label");
    public static final By language_en_uk = By.xpath("//*[@id=\"mh-agegate-lang-block\"]/ul/li[4]/label");
    // message if DOB not ok
    public static final By message_cannot_access = By.xpath("//*[@id=\"mCSB_1_container\"]");
    //*[@id="drupal-modal"]/div/div[1]/div[1]/div[2]/ul/li



}
