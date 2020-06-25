package com.amazon.automation.webpages;

import com.amazon.automation.components.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddItemToCart {
    private static By CONFIRM_TEXT_FIELD = By.id("confirm-text");
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public AddItemToCart(WebDriver driver){
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public String getConfirmationItem(){
        return driver.findElement(CONFIRM_TEXT_FIELD).getText();
    }

    public NavigationMenu navigationMenu(){
        return navigationMenu;
    }
}
