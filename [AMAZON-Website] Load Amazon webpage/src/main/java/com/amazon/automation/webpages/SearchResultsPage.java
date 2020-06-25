package com.amazon.automation.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private static By SEARCH_RESULT_ITEM_TITLE = By.className("s-image");
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getFirstResultTitle(){
        return driver.findElement(SEARCH_RESULT_ITEM_TITLE).getText();
    }

    public ProductDetailsPage clickFirstResultTitle(){
    driver.findElement(SEARCH_RESULT_ITEM_TITLE).click();
        return new ProductDetailsPage(driver);
    }
}
