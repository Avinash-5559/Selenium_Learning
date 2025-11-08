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

public class SUI07_Test_Selenium_JavaScriptPrompt {

    @Test
    @Description("TC#1 : Verify the JavaScript Prompt")
    public void test_VerifyJavaScriptPrompt() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Avinash");
        alert.accept();
        //alert.dismiss();

        WebElement result = driver.findElement(By.xpath("//p[contains(text(),'You entered: Avinash')]"));
        Assert.assertEquals(result.getText(), "You entered: Avinash");
        //Assert.assertEquals(result.getText(),"You entered: null");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}