package com.avinashsinha.SN10_Selenium_ActionClass;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SAC05_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Actions Methods")
    public void test_Actions() {

        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);

        WebElement blockA = driver.findElement(By.id("column-a"));
        WebElement blockB = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(blockA, blockB)
                .build().perform();
    }
}