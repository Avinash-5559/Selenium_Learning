package com.avinashsinha.SN05_Selenium_UI_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SUI06_Test_Selenium_JavaScriptConfirm {

    @Test
    @Description("TC#1 : Verify the JavaScript Confirm")
    public void test_VerifyJavaScriptConfirm() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsConfirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        jsConfirm.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        //alert.accept();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        //Assert.assertEquals(result.getText(), "You clicked: Ok");
        Assert.assertEquals(result.getText(), "You clicked: Cancel");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}