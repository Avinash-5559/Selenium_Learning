package com.avinashsinha.SN08_Selenium_Mini_Project;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
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

public class SMP02_Test_Selenium {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");
        //edgeOptions.addArguments("--headless=new");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify to Enter the details on the Sign Up Page")
    @Owner("Avinash Sinha")
    public void test_enterDetailsOnSignUpPage() {

        String URL = "https://github.com/signup";
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Email Text Box
        By emailTextBoxLocator = By.id("email");
        WebElement emailTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBoxLocator));
        emailTextBox.sendKeys("emailid@email.com");

        // Password Text Box
        By passwordTextBoxLocator = By.id("password");
        WebElement passwordTexBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
        passwordTexBox.sendKeys("passWord!23456");

        // Username Text Box
        By userNameTextBoxLocator = By.id("login");
        WebElement userNameTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameTextBoxLocator));
        userNameTextBox.sendKeys("User-Name-123456");

        // Country DropDown
        By countryDropDownLocator = By.xpath("//button[contains(@id,'select-panel') and @aria-labelledby='country-dropdown-label']");
        WebElement countryDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropDownLocator));
        countryDropDown.click();

        // Country Search Box
        By countrySearchBoxLocator = By.xpath("//input[contains(@id,'select-panel') and @type='search']");
        WebElement countrySearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchBoxLocator));
        countrySearchBox.sendKeys("Latvia");

        // Country Name Button
        By countryButtonLocator = By.xpath("//span[contains(text(),'Latvia')]/..");
        WebElement countryButton = wait.until(ExpectedConditions.visibilityOfElementLocated(countryButtonLocator));
        countryButton.click();

        // User Consent Check Box
        By userConsentCheckBoxLocator = By.id("user_signup[marketing_consent]");
        WebElement userConsentCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(userConsentCheckBoxLocator));
        userConsentCheckBox.click();

    }

    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}