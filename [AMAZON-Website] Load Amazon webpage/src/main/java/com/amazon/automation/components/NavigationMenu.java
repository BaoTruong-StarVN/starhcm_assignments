//Define: Select category from search dropdown & enter search key & Click "Find" button => at Navigation Menu

package com.amazon.automation.components;

import com.amazon.automation.webpages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NavigationMenu {
    private static By SEARCH_DROPDOWN_BOX = By.id("searchDropdownBox");
    private static By SEARCH_INPUT_ITEM = By.id("twotabsearchtextbox");
    private static By SEARCH_GO_BUTTON = By.xpath("//*[@value='Go']");
    private static By EMAIL_INPUT = By.id("ap_email");
    private static By PASSWORD_INPUT = By.id("ap_password");
    private static By SIGNIN_BUTTON = By.id("signInSubmit");
    private WebDriver driver;

    public NavigationMenu(WebDriver driver){

        this.driver = driver;
    }

    public SignIn signIn(String email, String password){
        // 1. Click SignIn label
        Actions actions = new Actions(driver);
        WebElement SignInAccount = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(SignInAccount).moveToElement(driver.findElement(By.className("nav-action-inner"))).click().build().perform();

        // 2. Input Email
        driver.findElement(EMAIL_INPUT).clear();
        driver.findElement(EMAIL_INPUT).sendKeys(email);

        // 3. Click "Continue" button
        driver.findElement(By.id("continue")).click();

        // 4. Input Password
        driver.findElement(PASSWORD_INPUT).clear();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);

        // 5. Click "Sign-In" button
        driver.findElement(SIGNIN_BUTTON).click();

        return new SignIn(driver);
    }

    public SearchResultsPage searchFor(String category, String searchKey){
        // 1. Open Amazon
        // 2. Select any value in dropdown
        new Select(driver.findElement(SEARCH_DROPDOWN_BOX)).selectByVisibleText(category);

        // 3. Input value items in textbox
        driver.findElement(SEARCH_INPUT_ITEM).sendKeys(searchKey);

        // 4. Click button "Find" to search
        driver.findElement(SEARCH_GO_BUTTON).click();

        return new SearchResultsPage(driver);
    }
}
