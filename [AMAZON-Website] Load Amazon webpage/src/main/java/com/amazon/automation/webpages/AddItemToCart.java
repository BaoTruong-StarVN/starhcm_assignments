//Define: Verify confirmation test appears: "2 items added to Cart" => on AddItemToCart
package com.amazon.automation.webpages;

import com.amazon.automation.components.NavigationMenu;
import org.openqa.selenium.WebDriver;

public class AddItemToCart {

    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public AddItemToCart(WebDriver driver){
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public NavigationMenu navigationMenu(){
        return navigationMenu;
    }
}
