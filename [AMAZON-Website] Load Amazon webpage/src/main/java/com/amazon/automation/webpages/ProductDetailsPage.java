//Define: Verify that product is correct & click "Add to Cart" button => on ProductDetailsPage
package com.amazon.automation.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
    private static By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");
    private static By SET_QUANTITY_DROPDOWN = By.id("quantity");
    private static By CONFIRM_CART_BUTTON = By.className("a-button-input");
    private static By HOMEPAGE_LOGO = By.id("nav-logo");
    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductTitle(){
        return driver.findElement(By.id("productTitle")).getText();
    }

    public AddItemToCart addToCart(){
        //Select quantity items
        Select quantity = new Select(driver.findElement(SET_QUANTITY_DROPDOWN));
        quantity.selectByVisibleText("2");

        driver.findElement(ADD_TO_CART_BUTTON).click();

        driver.findElement(CONFIRM_CART_BUTTON).click();

        driver.findElement(HOMEPAGE_LOGO).click();
        return new AddItemToCart(driver);
    }
    
}
