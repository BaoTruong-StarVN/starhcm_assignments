package com.github.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Navigation extends PageObject {
    private final String IPHONE = "iPhone 11 Pro Max";
    private final String AIR_MACHINE = "Mammoth Air Ozone Machine";


    @FindBy(id = "twotabsearchtextbox")
    private WebElement textbox;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
    private WebElement submit_button;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement clear_text;

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public void enterIphone() {
        this.textbox.sendKeys(IPHONE);
    }

    public void enterAirMachine() {
        this.textbox.sendKeys(AIR_MACHINE);
    }

    public void pressSubmitButton() {
        this.submit_button.click();
    }

    public void clearText() {
        this.clear_text.clear();
    }

    @FindBy(xpath = "//span[contains(text(),'Mammoth 7,000mg Ozone Generator, Ozone Air Purifie')]")
    private WebElement mammothairozonemachine;


    public void clickMammothAirOzonMachine() {
        this.mammothairozonemachine.click();
    }

    @FindBy(id = "add-to-wishlist-button-group")
    private WebElement addlistbutton;

    public void pressAddListButton() {
        this.addlistbutton.click();
    }

    //Login
    @FindBy(id = "nav-link-accountList")
    private WebElement logingate;

    public void clickLoginGate() {
        this.logingate.click();
    }


    @FindBy(id = "continue")
    private WebElement continuebutton;

    public void pressContinueButton() {
        this.continuebutton.click();
    }

    //Click
    @FindBy(id = "signInSubmit")
    private WebElement signinbutton;

    public void pressSignInButton() {
        this.signinbutton.click();
    }

    //Search Cam 1080
    private static final String PAPALOOK = "Cam 1080p ";

    public void enterPapaLook() {
        this.textbox.sendKeys(PAPALOOK);
    }

    //PAPALOOK AF925 Stream Webcam, 1080P HD Computer C
    @FindBy(xpath = "//span[contains(text(),'Full HD Webcam 1080P with Microphone, Manual Focus')]")
    private WebElement papalook;

    public void clickPapaLook() {
        this.papalook.click();
    }

    //Add PAPALOOK to cart
    @FindBy(id = "add-to-cart-button")
    private WebElement addtocartbutton;

    public void pressAddToCartButton() {
        this.addtocartbutton.click();
    }

    //Assert number in cart.
    public void assertCount() {
        String actualString = driver.findElement(By.id("nav-cart-count")).getText();
        int actualInt = Integer.parseInt(actualString);
        Assert.assertEquals(actualInt, 2, "Having 2 products in cart.");
    }


}
