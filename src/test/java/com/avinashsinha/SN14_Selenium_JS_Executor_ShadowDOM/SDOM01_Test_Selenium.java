package com.avinashsinha.SN14_Selenium_JS_Executor_ShadowDOM;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SDOM01_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the JS Executor Shadow DOM")
    public void test_JSExecutorShadowDOM() {

        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement toScroll = driver.findElement(By.xpath("//div[@id='userName']"));

        js.executeScript("arguments[0].scrollIntoView(true);", toScroll);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement pizzaInputBox = (WebElement) js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('div#app2').shadowRoot.querySelector('input#pizza')");
        pizzaInputBox.sendKeys("FarmHouse");

    }
}