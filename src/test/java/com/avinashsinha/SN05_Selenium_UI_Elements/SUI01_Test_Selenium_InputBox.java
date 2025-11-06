package com.avinashsinha.SN05_Selenium_UI_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SUI01_Test_Selenium_InputBox {

    @Test
    @Description("TC#1 : Verify the InputBox")
    public void test_VerifyInputBox() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement inputBox = driver.findElement(By.name("firstname"));
        inputBox.sendKeys("the testing academy");

    }
}