package com.avinashsinha.SN17_Selenium_DataDrivenTesingPOI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class SDDT02_Test_Selenium {

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

        driver.get("https://app.vwo.com/");

        WebDriverWait wait_title = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait_title.until(ExpectedConditions.titleContains("Login - VWO"));
        String title = driver.getTitle();

        Assert.assertEquals(title, "Login - VWO");

        WebDriverWait wait_URL=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait_URL.until(ExpectedConditions.urlContains("https://app.vwo.com/#/login"));
        String url=driver.getCurrentUrl();

        Assert.assertEquals(url, "https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys(email);

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(password);

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        WebDriverWait wait_error = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait_error.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));

        WebElement errorMessage = driver.findElement(By.className("notification-box-description"));

        Assert.assertEquals(errorMessage.getText(), "Your email, password, IP address or location did not match");

    }

    @DataProvider
    public Object[][] getData() {
        /*
            - Read the Data from the Excel File
            - Give them in the 2D Array
        */

        return UtilExcel.getTestDataFromExcel("Sheet1");

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