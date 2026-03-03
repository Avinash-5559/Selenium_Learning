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

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SMP03_Test_Selenium {

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
    @Description("TC#1 : Verify to Enter the Product and go for Checkout")
    @Owner("Avinash Sinha")
    public void test_e2eTesting() {

        String URL = "https://www.saucedemo.com/";
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By usernameTextFieldLocator = By.id("user-name");
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextFieldLocator));
        usernameTextField.sendKeys("standard_user");

        By passwordTextFieldLocator = By.id("password");
        WebElement passwordTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextFieldLocator));
        passwordTextField.sendKeys("secret_sauce");

        By loginButtonLocator = By.id("login-button");
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        loginButton.click();

        By addToCartButtonLocator = By.xpath("(//button[contains(@id,'add-to-cart')])[4]");
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButtonLocator));
        addToCartButton.click();

        By cartButtonLocator = By.id("shopping_cart_container");
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cartButtonLocator));
        cartButton.click();

        By checkoutButtonLocator = By.id("checkout");
        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButtonLocator));
        checkoutButton.click();

        By firstNameTextFieldLocator = By.id("first-name");
        WebElement firstNameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTextFieldLocator));
        firstNameTextField.sendKeys("First Name");

        By lastNameTextFieldLocator = By.id("last-name");
        WebElement lastNameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameTextFieldLocator));
        lastNameTextField.sendKeys("Last Name");

        By postalCodeTextFieldLocator = By.id("postal-code");
        WebElement postalCodeTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeTextFieldLocator));
        postalCodeTextField.sendKeys("123456");

        By continueButtonLocator = By.id("continue");
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator));
        continueButton.click();

        By finishButtonLocator = By.id("finish");
        WebElement finishButton = wait.until(ExpectedConditions.visibilityOfElementLocated(finishButtonLocator));
        finishButton.click();

        By backHomeButtonLocator = By.id("back-to-products");
        WebElement backHomeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(backHomeButtonLocator));
        backHomeButton.click();

        By hamburgerMenuButtonLocator = By.id("react-burger-menu-btn");
        WebElement hamburgerMenuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuButtonLocator));
        hamburgerMenuButton.click();

        By logoutButtonLocator = By.id("logout_sidebar_link");
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator));
        logoutButton.click();

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(3000);
        driver.quit();

    }
}