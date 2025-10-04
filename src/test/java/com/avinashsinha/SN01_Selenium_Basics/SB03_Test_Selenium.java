package com.avinashsinha.SN01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SB03_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to Open the URL on Edge Browser")
    public void test_VerifyOpenURL() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com/");

        driver.manage().window().maximize();

        String titleURL = driver.getTitle();
        System.out.println("\n------------------------- Title of the URL -------------------------\n");
        System.out.println(titleURL);

        String currentURL = driver.getCurrentUrl();
        System.out.println("\n------------------------- Current URL -------------------------\n");
        System.out.println(currentURL);

        String pageSource = driver.getPageSource();
        System.out.println("\n------------------------- Page Source of the URL -------------------------\n");
        System.out.println(pageSource);

        driver.manage().window().minimize();

        driver.quit();
    }
}