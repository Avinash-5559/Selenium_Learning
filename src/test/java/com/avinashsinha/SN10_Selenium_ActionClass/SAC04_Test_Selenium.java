package com.avinashsinha.SN10_Selenium_ActionClass;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SAC04_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Actions Methods")
    public void test_Actions() {

        String URL = "https://thetestingacademy.com/";
        driver.get(URL);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN)
                .keyDown(Keys.PAGE_DOWN)
                .build().perform();
    }
}