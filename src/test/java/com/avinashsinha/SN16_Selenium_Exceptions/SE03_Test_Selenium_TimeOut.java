package com.avinashsinha.SN16_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SE03_Test_Selenium_TimeOut {

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
    @Description("TC#1 : Verify the Time Out Exception")
    public void test_TimeOutException() {

        System.out.println("Start of the Program");

        driver.get("https://www.google.com/?zx=1760353619725&no_sw_cr=1");

        try {

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='abc']")));

            /*
                org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by
                By.xpath: //textarea[@id='abc'] (tried for 10 second(s) with 500 milliseconds interval)
            */

            WebElement searchInputBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            searchInputBox.sendKeys("the testing academy");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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