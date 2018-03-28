package com.adyax.ruinart.automation;

import org.openqa.selenium.By;

public class HomePage {
    public static final By ruinart_logo_arms = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/a[1]/span[1]/svg");
    public static final By ruinart_logo_name = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/a[1]/span[2]/svg");
    public static final By ruinart_logo_text = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/a[1]/span[3]/svg");
    public static final By newsletter_button = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/a[2]/span/span/svg");
    public static final By menu_button = By.xpath("//*[@id=\"ajax-redirect\"]/div/header/span/span[1]/span/svg");
    // slide 1 elements
    public static final By prev_arrow_slide_first = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[2]/div/div/ul/button[1]");
    public static final By next_arrow_slide_first = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[2]/div/div/ul/button[2]");
    public static final By discover_button = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[2]/div/div/ul/div/div/li[2]/div/div[2]/div/a");
    public static final By first_slide_dot_button = By.xpath("//*[@id=\"slick-slide00\"]/button");
    public static final By third_slide_dot_button = By.xpath("//*[@id=\"slick-slide03\"]/button");
    public static final By wine_title = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[2]/div/div/ul/div/div/li[4]/div/div[2]/div/h2");
    public static final By wine_description = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[2]/div/div/ul/div/div/li[4]/div/div[2]/div/p");
    // slide actualites/news elements
    public static final By prev_arrow_slide_news = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/button[1]");
    public static final By next_arrow_slide_news = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/button[2]");
    public static final By view_first_buttton = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[2]/div[1]/a");
    public static final By view_second_buttton = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[3]/div[1]/a");
    public static final By view_third_buttton = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[4]/div[1]/a");
    public static final By text_slide_slider_first = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[2]/div[1]/h3");
    public static final By text_slide_slider_second = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[3]/div[1]/h3");
    public static final By text_slide_slider_third = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[3]/div/div/div/ul/div/div/li[4]/div[1]/h3");
    public static final By dot_button_news = By.xpath("//*[@id=\"slick-slide12\"]/button");




    //social networks access
    public static final By facebook_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[1]/li[1]/a/span/span/svg");
    public static final By twitter_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[1]/li[2]/a/span/span/svg");
    public static final By instagram_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[1]/li[3]/a/span/span/svg");
    public static final By youtube_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[1]/li[4]/a/span/span/svg");
    // bottom menu
    public static final By personal_data_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[1]/a");
    public static final By legal_notes_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[2]/a");
    public static final By newsletter_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[3]/a");
    public static final By espace_presse_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[4]/a");
    public static final By contact_link = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[4]/div/div[1]/footer/div/ul[2]/li[5]/a");
    // language
    public static final By en_language = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[2]/li[6]/ul/li[1]/a");
    public static final By fr_language = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[2]/li[6]/ul/li[2]/a");
    public static final By it_language = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[2]/li[6]/ul/li[3]/a");
    public static final By de_language = By.xpath("//*[@id=\"ajax-redirect\"]/div/div[1]/div[5]/div/div[1]/footer/div/ul[2]/li[6]/ul/li[4]/a");


    public static final By additional_info = By.xpath("template");
}
