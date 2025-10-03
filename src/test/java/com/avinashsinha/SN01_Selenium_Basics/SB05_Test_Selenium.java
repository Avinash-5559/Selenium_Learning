package com.avinashsinha.SN01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SB05_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to Open the URL")
    public void test_VerifyOpenURL() throws Exception {

        WebDriver driver = new EdgeDriver();

        Thread.sleep(3000);

        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.get("https://www.google.com/?zx=1759499687300&no_sw_cr=1");

        Thread.sleep(3000);

        // Using Navigation Methods

        driver.navigate().to("https://www.bing.com/?toWww=1&redig=D8A4D3B43D2647E8969E687200943600");

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.quit();

    }
}