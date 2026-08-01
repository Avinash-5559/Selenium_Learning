package com.avinashsinha.SN22_Selenium_MiscellanousTopics;

/*
            Handling Window Authentication Pop Up
            driver.get("http://Username:Password@SiteURL");
*/

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
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
import org.testng.annotations.Test;

import java.time.Duration;

public class SMT03_Test_Selenium_HandleWindowPopUp {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        options.addArguments("--start-maximized");

        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify to Handle the Window Pop Up by Selenium")
    @Owner("Avinash Sinha")
    public void test_handleWindowPopUp() {

        driver.get("https:admin:admin@the-internet.herokuapp.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By basicAuthButtonLocator = By.cssSelector("[href*='basic']");
        WebElement basicAuthButton = wait.until(ExpectedConditions.visibilityOfElementLocated(basicAuthButtonLocator));
        basicAuthButton.click();

        String textMessage = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(textMessage, "Congratulations! You must have the proper credentials.");

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
