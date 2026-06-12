package com.avinashsinha.SN23_Selenium_CDP;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

public class SCDP10_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to log javascript errors from Selenium Script to console for debugging")
    @Owner("Avinash Sinha")
    public void test_ConsoleLogsCapture() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        By broseProductsButtonLocator = By.cssSelector("[class*='btn-success']");
        WebElement broseProductsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(broseProductsButtonLocator));
        broseProductsButton.click();

        By seleniumTextButtonLocator = By.cssSelector("[href*='/products/1']");
        WebElement seleniumTextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(seleniumTextButtonLocator));
        seleniumTextButton.click();

        By addToCartButtonLocator = By.cssSelector(".add-to-cart");
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButtonLocator));
        addToCartButton.click();

        By cartButtonLocator = By.cssSelector("[href*='cart']");
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cartButtonLocator));
        cartButton.click();

        By quantityTextBoxLocator = By.id("exampleInputEmail1");
        WebElement quantityTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityTextBoxLocator));
        quantityTextBox.clear();

        quantityTextBox.sendKeys("2");

        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);       // Get LogEntries object
        List<LogEntry> logEntries = entries.getAll();                           // LogEntry-object- getAll method return all logs in list

        for (LogEntry logEntry : logEntries) {                                  // iterating through list and printing each log message
            System.out.println(logEntry.getMessage());
        }

        driver.quit();

    }
}