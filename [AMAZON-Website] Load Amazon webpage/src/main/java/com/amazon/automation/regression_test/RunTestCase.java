package com.amazon.automation.regression_test;

import com.amazon.automation.webpages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RunTestCase {
    private WebDriver driver;
    private HomePage homePage;

    //setUp(): method is annotated that will be run before the first test method in the current class is invoked.
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        //declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("http://amazon.com");
    }

    //openHomePage(): method to get Amazon page
    @BeforeMethod(alwaysRun = true)
    public void openHomePage(){
        homePage = new HomePage(driver).open();
    }

    //tearDown(): method to close browser window and safely end the session after all.
    @AfterClass(alwaysRun = true)
    public void tearDown(){
    }

    //test(): method to verify what has been done
    @Test
    public void testAddingItemToCart() {
        SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("All Departments", "cameras");
        String itemTitle = searchResultsPage.getFirstResultTitle();

        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();
        assert (productDetailsPage.getProductTitle().equals(itemTitle));

        AddItemToCart addItemToCart = productDetailsPage.addToCart();
        assert (addItemToCart.getConfirmationItem().equals("2 items added to Cart"));
    }
}
