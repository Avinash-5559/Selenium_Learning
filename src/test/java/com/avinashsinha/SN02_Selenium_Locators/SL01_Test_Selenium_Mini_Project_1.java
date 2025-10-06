package com.avinashsinha.SN02_Selenium_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SL01_Test_Selenium_Mini_Project_1 {

    @Test
    @Description("TC#1 : Verify the Error message on the VWO Login Page")
    public void test_VWOLogin_Negative() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.manage().deleteAllCookies();

        driver.navigate().to("https://app.vwo.com/#/login");

        // 1. Find the email input box and enter the email.

        /*
        <input
            type="email"
            class="text-input W(100%)"
            name="username"
            placeholder="Enter email ID"
            id="login-username"
            data-qa="hocewoqisi"
         >
         */

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        // 2. Find the password input box and enter the password.

        /*
        <input
            type="password"
            class="text-input W(100%)"
            placeholder="Enter password"
            name="password"
            id="login-password"
            data-qa="jobodapuxe"
        >
         */

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        // 3. Find the Sign-in button and click on it.

        /*
        <button
            type="submit"
            id="js-login-btn"
            class="btn btn--primary btn--inverted W(100%) H(48px) Fz(16px)"
            onclick="login.login(event)"
            data-qa="sibequkica">
		</button>
        */

        WebElement buttonSignIn = driver.findElement(By.id("js-login-btn"));
        buttonSignIn.click();

        Thread.sleep(3000);

        // 4. Find the invalid error message and verify.

        /*
        <div
            class="notification-box-description"
            id="js-notification-box-msg"
            data-qa="rixawilomi">Your email, password, IP address or location did not match
        </div>
        */

        WebElement errorMessage = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(errorMessage.getText(), "Your email, password, IP address or location did not match");

        driver.quit();
    }
}