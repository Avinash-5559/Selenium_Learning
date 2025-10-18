package com.avinashsinha.SN10_Selenium_ActionClass;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SAC02_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Actions Methods")
    public void test_Actions() {

        String URL = "https://www.spicejet.com/";
        driver.get(URL);

        WebElement source = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(source)
                .click()
                .sendKeys(source,"BLR")
                .build().perform();

    }
}