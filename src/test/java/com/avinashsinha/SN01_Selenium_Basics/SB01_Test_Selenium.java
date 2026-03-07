package com.avinashsinha.SN01_Selenium_Basics;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SB01_Test_Selenium {

    @Test(priority = 1)
    @Description("TC#1 : Verify to open the VWO Login Page on Chrome Browser")
    @Owner("Avinash Sinha")
    public void test_VerifyVWOLogin_Chrome() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https:app.vwo.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    @Test(priority = 2)
    @Description("TC#2 : Verify to open the VWO Login Page on Edge Browser")
    @Owner("Avinash Sinha")
    public void test_VerifyVWOLogin_Edge() {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https:app.vwo.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    @Test(priority = 3)
    @Description("TC#3 : Verify to open the VWO Login Page on Firefox Browser")
    @Owner("Avinash Sinha")
    public void test_VerifyVWOLogin_Firefox() {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https:app.vwo.com");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}