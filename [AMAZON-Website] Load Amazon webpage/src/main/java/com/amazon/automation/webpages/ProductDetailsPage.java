package com.amazon.automation.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
    private static By PRODUCT_TITLE_FIELD = By.id("productTitle");
    private static By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");
    private static By SET_ITEM_QUANTITY = By.className("a-dropdown-label");
    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductTitle(){
        return driver.findElement(PRODUCT_TITLE_FIELD).getText();
    }

    public AddItemToCart addToCart(){
        //Select quantity items
        Select quantity = new Select(driver.findElement(SET_ITEM_QUANTITY));
        quantity.selectByVisibleText("2");

        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new AddItemToCart(driver);

    }

}
