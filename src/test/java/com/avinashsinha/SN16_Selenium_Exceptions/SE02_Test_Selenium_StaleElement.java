package com.avinashsinha.SN16_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SE02_Test_Selenium_StaleElement {

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

    @Test
    @Description("TC#1 : Verify the Stale Element")
    public void test_StaleElement() {

        driver.get("https://www.google.com/?zx=1760353619725&no_sw_cr=1");

        System.out.println("Start of the Program");

        WebElement searchInputBox = driver.findElement(By.id("APjFqb"));

        driver.navigate().refresh();

        try {
            searchInputBox.sendKeys("the testing academy" + Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException");
        }

        //org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found

        System.out.println("End of the Program");
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