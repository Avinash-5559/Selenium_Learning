package com.avinashsinha.SN22_Selenium_MiscellanousTopics;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SMT01_Test_Selenium_HandleHTTPSCertificate {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");

        edgeOptions.setAcceptInsecureCerts(true);           // This line of code is used to accept the permission

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify to Handling HTTPS Certification Website")
    @Owner("Avinash Sinha")
    public void test_HandlingHTTPSCertificateWebsite() {

        String URL = "https://expired.badssl.com/";
        driver.get(URL);
        System.out.println("\nTitle : " + driver.getTitle());

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(2000);
        driver.quit();

    }
}