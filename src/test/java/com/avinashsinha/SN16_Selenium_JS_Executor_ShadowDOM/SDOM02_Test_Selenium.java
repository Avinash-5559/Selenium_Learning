package com.avinashsinha.SN16_Selenium_JS_Executor_ShadowDOM;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SDOM02_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify Selenium Shadow DOM")
    @Owner("Avinash Sinha")
    public void test_ShadowDOM() throws InterruptedException {

        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);

        WebElement userNameHost = driver.findElement(By.cssSelector("div#userName"));

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", userNameHost);

        Thread.sleep(3000);

        // First Shadow Root
        SearchContext shadowRoot1 = userNameHost.getShadowRoot();

        // Second Shadow Host inside first Shadow Root
        WebElement app2Host = shadowRoot1.findElement(By.cssSelector("div#app2"));

        // Second Shadow Root
        SearchContext shadowRoot2 = app2Host.getShadowRoot();

        // Locate pizza input inside second Shadow Root
        WebElement pizzaInputBox = shadowRoot2.findElement(By.cssSelector("input#pizza"));

        pizzaInputBox.sendKeys("FarmHouse");
    }
}