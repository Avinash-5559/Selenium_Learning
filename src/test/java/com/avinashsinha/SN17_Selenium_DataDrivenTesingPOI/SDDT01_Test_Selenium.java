package com.avinashsinha.SN17_Selenium_DataDrivenTesingPOI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SDDT01_Test_Selenium {

    public WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        //edgeOptions.addArguments("--headless=new");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @Test(dataProvider = "getData")
    public void test_VWOLogin(String email, String password) {

        System.out.println(" | " + email + " | " + password + " | ");

        //Here we will write the code to Login

    }

    //It is a Hard Coated Test Data
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass124"}
        };
    }

    //It is Data Driven Test Data
    @DataProvider
    public Object[][] getDataXLSX() {
        /*
            - Read the Data from the Excel File
            - Give them in the 2D Array
        */
        return new Object[][]{};
    }

    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}