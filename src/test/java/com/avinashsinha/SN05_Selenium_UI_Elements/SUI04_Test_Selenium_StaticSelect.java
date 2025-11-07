package com.avinashsinha.SN05_Selenium_UI_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SUI04_Test_Selenium_StaticSelect {

    @Test
    @Description("TC#1 : Verify the Static Select")
    public void test_VerifyStaticSelect() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement staticSelect = driver.findElement(By.id("dropdown"));

        Select select = new Select(staticSelect);
        //select.selectByIndex(0);
        select.selectByVisibleText("Option 2");
        select.selectByValue("1");

    }
}