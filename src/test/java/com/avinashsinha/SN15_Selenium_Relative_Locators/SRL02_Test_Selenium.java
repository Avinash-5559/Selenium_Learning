package com.avinashsinha.SN15_Selenium_Relative_Locators;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SRL02_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Relative Locators")
    public void test_RelativeLocators() {

        String URL = "https://codepen.io/AbdullahSajjad/full/LYGVRgK";
        driver.get(URL);

        driver.switchTo().frame("result");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();

        WebElement userNameInputBox = driver.findElement(By.xpath("//input[@id='username']"));

        WebElement errorMessage = driver.findElement(with(By.tagName("small")).below(userNameInputBox));

        String errorText = errorMessage.getText();

        Assert.assertEquals(errorText, "Username must be at least 3 characters");

    }
}