package com.avinashsinha.SN07_Selenium_SVG_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.checkVisibility;
import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SSVGE01_Test_Selenium {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);

    }

    @Description("Verify the SVG Icon on Flipkart search Bar")
    @Test
    public void test_Flipkart_Search_SVG_Icon() {

        String URL = "https://www.flipkart.com/search";
        driver.get(URL);

        // Step 1 - Enter the "macmini" in the input box
        driver.findElement(By.name("q")).sendKeys("macmini");

        // Step 2 - Click on the SVG Element
        List<WebElement> svgElement = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElement.get(0).click();

        checkVisibility(driver, By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));

        List<WebElement> titleResult = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));

        for (WebElement title : titleResult)
            System.out.println(title.getText());

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(5000);
        driver.quit();

    }
}