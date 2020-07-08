package com.guru99.demo.testcase;
//-----
import com.guru99.demo.pages.*;
import com.guru99.demo.Excel_Export_And_FileIO.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
//-----
public class RunTestCase {

    private WebDriver driver;
    private Home_Page homePage;
    private SignIn_Page login_account;

    //@BeforeMethod: set for the case when check the test case input according to loop test data
    @BeforeClass(alwaysRun = true)
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.demo.guru99.com/V4/");

    }

    //@BeforeMethod: set for the case when check the test case input according to loop test data
    @BeforeMethod(alwaysRun = true)
    public void openLoginPage(){
        login_account = new SignIn_Page(driver).open();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    //Expected Result:
    //1. Login successful
    @Test
    public void TestCase_1(){
        Home_Page homePage = login_account.signIn("mngr269746","sabUgAv");
    }


    public static String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    String actualTitle;
    //Expected Result:
    //1. Login successful
    //2. Verify Title of the Homepage.
    @Test
    public void TestCase_2(){
        Home_Page homePage = login_account.signIn("mngr269746", "sabUgAv");
        if(driver.getTitle().contains(EXPECT_TITLE)){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
    }

    @Test
    public void TestCase_3(String...strings) throws IOException{
        //Create an object of ReadGuru99ExcelFile class
        ReadGuru99ExcelFile objExcelfile = new ReadGuru99ExcelFile();

        //Prepare the path of excel file
        String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\guru99\\demo\\Excel_Export_And_FileIO";
        //String filePath = System.getProperty("D:\\testData.xlsx");

        //Call read file method of the class to read data
        objExcelfile.readExcel(filePath,"testData.xlsx","Sheet1");
    }
}
