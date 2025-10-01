package com.avinashsinha.SN01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SB01_Test_Selenium {

    @Test(priority = 1)
    @Description("TC#1 : Verify to open the VWO Login Page on Chrome Browser")
    public void test_VerifyVWOLogin_Chrome() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https:app.vwo.com");
        System.out.println(driver.getTitle());
    }

    @Test(priority = 2)
    @Description("TC#2 : Verify to open the VWO Login Page on Firefox Browser")
    public void test_VerifyVWOLogin_Firefox() {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https:app.vwo.com");
        System.out.println(driver.getTitle());

    }
}