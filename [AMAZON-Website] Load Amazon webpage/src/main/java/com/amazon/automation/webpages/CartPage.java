package com.amazon.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CartPage {
    private static By LIST_ITEM = By.className("a-list-item");
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String ConfirmItemToCartPage(){
        return driver.findElement(LIST_ITEM).getText();
    }


}
