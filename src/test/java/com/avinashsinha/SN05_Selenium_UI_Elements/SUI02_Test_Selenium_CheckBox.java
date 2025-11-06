package com.avinashsinha.SN05_Selenium_UI_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SUI02_Test_Selenium_CheckBox {

    @Test
    @Description("TC#1 : Verify the CheckBox")
    public void test_VerifyCheckBox() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement checkBox = driver.findElement(By.id("tool-1"));
        checkBox.click();

    }
}
