package com.avinashsinha.SN04_Selenium_Waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class SW05_Test_Selenium_FluentWait {

    @Test
    @Description("TC#1 : Verify the Error message on the VWO Login Page")
    public void test_VWOLogin_Negative() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.manage().deleteAllCookies();

        driver.navigate().to("https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@id='login-username']"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='login-password']"));
        passwordInputBox.sendKeys("admin");

        WebElement buttonSignIn = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        buttonSignIn.click();

        //------------------------------ Fluent Wait ------------------------------

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement errorMessage = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
            }
        });

        Assert.assertEquals(errorMessage.getText(), "Your email, password, IP address or location did not match");

        driver.quit();
    }
}
