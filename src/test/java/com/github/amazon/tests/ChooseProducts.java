package com.github.amazon.tests;

import com.github.amazon.pages.Navigation;
import com.github.amazon.pages.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChooseProducts {
    private static final WebDriver driver = new FirefoxDriver();
    @BeforeSuite
    private static void main(String args[]){
        //FirefoxDriver location setup in com.github.amazon.pages.Utils class
        System.setProperty("webdriver.gecko.driver", Utils.FIREFOX_DRIVER_LOCATION);
    }
    @Test
    public static void searchSelectCount(){
        driver.get(Utils.BASE_URL);
        Navigation navigation = new Navigation(driver);
        //Search PAPALOOK
        navigation.enterPapaLook();
        navigation.pressSubmitButton();
        //Add PAPALOOK to cart
        navigation.clickPapaLook();
        navigation.pressAddToCartButton();

        //Search Air Machine
        navigation.enterAirMachine();
        navigation.pressSubmitButton();
        //Add to cart Air Machine
        navigation.clickMammothAirOzonMachine();
        navigation.pressAddToCartButton();

        //Assert product count in cart
        navigation.assertCount();

    }
}
