package com.amazon.automation.components;

import com.amazon.automation.webpages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class NavigationMenu {
    private static By SEARCH_DROPDOWN_BOX = By.id("searchDropdownBox");
    private static By SEARCH_INPUT_ITEM = By.id("twotabsearchtextbox");
    private static By SEARCH_GO_BUTTON = By.xpath("//*[@value='Go']");
    private WebDriver driver;

    public NavigationMenu(WebDriver driver){

        this.driver = driver;
    }

    //Steps reproduce:
    // 1. Open Amazon
    // 2. Select any value in dropdown
    // 3. Input value items in textbox
    // 4. Click button "Find" to search
    public SearchResultsPage searchFor(String category, String searchKey){
        new Select(driver.findElement(SEARCH_DROPDOWN_BOX)).selectByVisibleText(category);
        driver.findElement(SEARCH_INPUT_ITEM).sendKeys(searchKey);
        driver.findElement(SEARCH_GO_BUTTON).click();
        return new SearchResultsPage(driver);
    }

}
