package com.avinashsinha.SN04_Selenium_Waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SW01_Test_Selenium_ThreadSleep {

    @Test
    @Description("TC#1 : Verify the Error message on the VWO Login Page")
    public void test_VWOLogin_Negative() throws Exception {

        WebDriver driver = new EdgeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@id='login-username']"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='login-password']"));
        passwordInputBox.sendKeys("admin");

        WebElement buttonSignIn = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        buttonSignIn.click();

        //------------------------------ Thread.sleep ------------------------------

        Thread.sleep(5000);

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));

        Assert.assertEquals(errorMessage.getText(), "Your email, password, IP address or location did not match");

        driver.quit();

    }
}