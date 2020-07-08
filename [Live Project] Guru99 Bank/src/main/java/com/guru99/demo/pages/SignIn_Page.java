package com.guru99.demo.pages;
//-----
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
//-----
import java.io.File;

//-----
public class SignIn_Page {

    private WebDriver driver;

    private static By USERID_LOGIN = By.name("uid");
    private static By PASSWORD_LOGIN = By.name("password");
    private static By CLICK_BUTTON_LOGIN = By.name("btnLogin");
    private static String LOGIN_PAGE_URL = "http://www.demo.guru99.com/V4/";

    // Expected Output
    public static String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    public static String EXPECT_ERROR = "User or Password is not valid";

    // Get data from file excel
    public static String FILE_PATH = "testData.xls"; //File Path
    public static String SHEET_NAME = "Data"; //Sheet Name
    public static String TABLE_NAME = "testData"; //Name of data table

    public SignIn_Page(WebDriver driver) {
        this.driver = driver;
    }

    public SignIn_Page open() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    // Verify the Login Section
    // 1. Go to http://www.demo.guru99.com/V4/
    // 2. Enter valid UserID
    // 3. Enter valid Password
    // 4.Click Login
    public Home_Page signIn(String username, String password) {
        driver.findElement(USERID_LOGIN).clear();
        driver.findElement(USERID_LOGIN).sendKeys(username);

        driver.findElement(PASSWORD_LOGIN).clear();
        driver.findElement(PASSWORD_LOGIN).sendKeys(password);

        driver.findElement(CLICK_BUTTON_LOGIN).click();
        return new Home_Page(driver);
    }
}
