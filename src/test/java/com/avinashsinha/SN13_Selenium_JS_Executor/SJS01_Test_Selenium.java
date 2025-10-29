package com.avinashsinha.SN13_Selenium_JS_Executor;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SJS01_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the JavaScript Executor")
    public void test_JavaScriptExecutor() {

        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement toScroll = driver.findElement(By.xpath("//div[@id='userName']"));

        js.executeScript("arguments[0].scrollIntoView(true);", toScroll);
        //js.executeScript("window.scrollBy(0,1000);");
        //js.executeScript("alert(1);");

        WebElement userInputBox = (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('input#kils')", toScroll);
        userInputBox.sendKeys("Enter the Data into the Input Box");

        String pageUrl = js.executeScript("return document.URL;").toString();
        System.out.println("\nPage URL : " + pageUrl);

        String pageTitle = js.executeScript("return document.title;").toString();
        System.out.println("\nPage Title : " + pageTitle);

    }
}