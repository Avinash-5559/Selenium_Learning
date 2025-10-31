package com.avinashsinha.SN15_Selenium_Relative_Locators;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SRL01_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Relative Locators")
    public void test_RelativeLocators() {

        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        WebElement spanElement = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));

        driver.findElement(with(By.id("exp-2")).toRightOf(spanElement)).click();
    }
}