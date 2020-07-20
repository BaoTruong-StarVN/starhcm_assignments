package com.amazon.automation.regression_test;

import com.amazon.automation.webpages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RunTestCase {
    private WebDriver driver;
    private HomePage homePage;
    private SignIn signIn;
    private CartPage cartPage;

    //setUp(): method is annotated that will be run before the first test method in the current class is invoked.
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        //declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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
        driver.quit();
    }

    //test(): method to verify what has been done using Page Object Model
    @Test
    public void testAddingItemToCartPOM() throws InterruptedException {
        //1. Login account
        SignIn signIn = homePage.navigationMenu().signIn("hoangbao0966@gmail.com","hoangbao12345");

        //1. Verify the account after sign in successful
        assert (driver.findElement(By.id("nav-link-accountList")).getText().contains("Hello, waynebird"));

        //2. Search items in dropdown
        Thread.sleep(1000);
        SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("All Departments", "canon eos rebel t6 digital slr camera battery");

        //3. Display search items & Select 1st item
        Thread.sleep(1000);
        String itemTitle = searchResultsPage.getFirstResultTitle();
        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();

        // Verify select 1st item
        //assert (productDetailsPage.getProductTitle().equals(itemTitle));
        Assert.assertEquals(itemTitle, productDetailsPage.getProductTitle());

        // Set quantity = '2' & Confirm Items
        Thread.sleep(1000);
        AddItemToCart addItemToCart = productDetailsPage.addToCart();

        //Verify itemTile in Shopping Cart
        assert (cartPage.ConfirmItemToCartPage().contains(itemTitle));
    }

    //test(): method to verify the output without Page Object Model
    @Test
    public void testAddingItemToCard() throws InterruptedException {
        new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("All Departments");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("canon eos rebel t6 digital slr camera battery");
        driver.findElement(By.xpath("//*[@value='Go']")).click();

        Thread.sleep(2000);
        //get first book
        WebElement firstItemTitleElement = driver.findElement(By.className("s-image"));
        String firstItemTitle = firstItemTitleElement.getText();
        firstItemTitleElement.click();

        // add items to cart:
        Thread.sleep(2000);
        Select quantity = new Select(driver.findElement(By.id("quantity")));
        quantity.selectByVisibleText("2");
        driver.findElement(By.id("add-to-cart-button")).click();

        //Confirm items
        Thread.sleep(2000);
        driver.findElement(By.className("a-button-input")).click();

        // Back homepage
        Thread.sleep(2000);
        driver.findElement(By.id("nav-logo")).click();
    }
    
}
