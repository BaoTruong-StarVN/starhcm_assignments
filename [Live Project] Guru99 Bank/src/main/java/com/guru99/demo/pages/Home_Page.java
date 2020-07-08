package com.guru99.demo.pages;

import org.openqa.selenium.WebDriver;

public class Home_Page {

    private WebDriver driver;
    private static String HOME_PAGE_URL = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";

    public Home_Page(WebDriver driver){
        this.driver = driver;
    }

    public Home_Page open(){
        driver.get(HOME_PAGE_URL);
        return this;
    }
}
