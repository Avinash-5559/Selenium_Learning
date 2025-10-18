package com.avinashsinha.SN10_Selenium_ActionClass;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SAC01_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Actions Methods")
    public void test_Actions() {

        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        WebElement firstnameInputBox = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .sendKeys(firstnameInputBox, "the testing academy")
                .keyUp(Keys.SHIFT)
                .build().perform();

    }
}