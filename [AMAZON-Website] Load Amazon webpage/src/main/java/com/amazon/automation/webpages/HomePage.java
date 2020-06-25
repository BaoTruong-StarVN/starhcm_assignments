package com.amazon.automation.webpages;

import com.amazon.automation.components.NavigationMenu;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private NavigationMenu navigationMenu;

    //Page URl
    private static String PAGE_URL = "https://www.amazon.com";

    //Locators

    //Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public HomePage open(){
        driver.get(PAGE_URL);
        return this;
    }

    public NavigationMenu navigationMenu(){
        return navigationMenu;
    }
}
