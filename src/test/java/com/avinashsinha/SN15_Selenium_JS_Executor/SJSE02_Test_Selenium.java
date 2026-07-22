package com.avinashsinha.SN15_Selenium_JS_Executor;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SJSE02_Test_Selenium {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify the Sum of Amount is equal to the Actual Result")
    @Owner("Avinash Sinha")
    public void test_ScrollAndCheck() {

        String URL = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.navigate().to(URL);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        waitJVM(2000);

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int actualSum = 0;

        for (int i = 0; i < values.size(); i++) {
            actualSum += Integer.parseInt(values.get(i).getText());
        }

        System.out.println("Total Amount Sum : " + actualSum);

        System.out.println(driver.findElement(By.cssSelector(".totalAmount")).getText());

        int expectedSum = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1]);

        Assert.assertEquals(expectedSum, actualSum);

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(2000);
        driver.quit();

    }
}