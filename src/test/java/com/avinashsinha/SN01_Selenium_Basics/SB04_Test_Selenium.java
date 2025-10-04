package com.avinashsinha.SN01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SB04_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to Open the URL")
    public void test_VerifyOpenURL() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        if (driver.getPageSource().contains("CURA Healthcare Service")) {
            System.out.println("CURA Healthcare Service IS VISIBLE");
            Assert.assertTrue(true);
        } else {
            //Assert.assertTrue(false);
            throw new Exception("CURA Healthcare Service IS NOT VISIBLE");
        }

        driver.quit();
    }
}