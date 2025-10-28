package com.avinashsinha.SN16_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SE02_Test_Selenium_StaleElement_FIX {

    public WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        //edgeOptions.addArguments("--headless=new");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @Test
    @Description("TC#1 : Verify the Stale Element")
    public void test_StaleElement() {

        driver.get("https://www.google.com/?zx=1760353619725&no_sw_cr=1");

        System.out.println("Start of the Program");

        WebElement searchInputBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));

        driver.navigate().refresh();

        /*
            When working with a React application (SPA - Single Page Application), the DOM structure can change dynamically
            due to client-side rendering. These changes are typically triggered by navigation, user actions,
            or asynchronous events (e.g., AJAX calls). Since these DOM updates are managed
            by the framework (React, Vue.js, Angular, etc.), they are not directly in your control.

            If the page is refreshed or a navigation occurs, previously located elements may no longer be valid.
            In such cases, the WebDriver may throw a StaleElementReferenceException, indicating that the
            element reference is no longer attached to the current DOM.

            For example, if you located an element before a DOM refresh:
            WebElement searchInputBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            And the DOM changed afterward, this reference may become stale.

            To avoid stale element exceptions:

            - Re-locate the element after the DOM has changed.
            - Use explicit waits to ensure the element is present and stable before interacting with it.
        */

        try {
            searchInputBox.sendKeys("the testing academy" + Keys.ENTER);
        } catch (StaleElementReferenceException e) {

            WebElement searchInputBox1 = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            searchInputBox1.sendKeys("the testing academy" + Keys.ENTER);

        }

        System.out.println("End of the Program");
    }

    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}