package com.avinashsinha.SN05_Selenium_UI_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SUI03_Test_Selenium_RadioButton {

    @Test
    @Description("TC#1 : Verify the RadioButton")
    public void test_VerifyRadioButton() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement radioButton = driver.findElement(By.id("sex-0"));
        radioButton.click();

    }
}
