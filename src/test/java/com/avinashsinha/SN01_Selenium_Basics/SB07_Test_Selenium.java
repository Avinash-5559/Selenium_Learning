package com.avinashsinha.SN01_Selenium_Basics;

// Extension for CRX File Download : https://chromewebstore.google.com/detail/crx-extractordownloader/ajkhmmldknmfjnmeedkbkkojgobmljda

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class SB07_Test_Selenium {

    @Test
    @Description("TC#1 : Option Class")
    public void test_VerifyOptionClass() {

        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.addArguments("--window-size=800,600");

        edgeOptions.addExtensions(new File("C:\\Users\\HP\\Documents\\Selenium_Learning\\Unconfirmed 694829.crdownload"));

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");
    }
}