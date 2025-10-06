package com.avinashsinha.SN02_Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SL03_Test_Selenium_Mini_Project_3 {

    @Test
    @Owner("Avinash Sinha")
    @Description("TC#1 : Verify the Error Message during Sign Up")
    @Severity(SeverityLevel.BLOCKER)
    public void test_VerifyErrorMessage() {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");

        WebElement linkText = driver.findElement(By.linkText("Start a free trial"));
        linkText.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abcd");

        WebElement checkBox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkBox.click();

        List<WebElement> button = driver.findElements(By.tagName("button"));
        button.get(0).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> errorMessage = driver.findElements(By.className("invalid-reason"));
        Assert.assertEquals(errorMessage.get(0).getText(), "The email address you entered is incorrect.");

        driver.quit();

    }
}