package com.avinashsinha.SN23_Selenium_CDP;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SCDP02_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to execute CDP Command to construct the own CDP functions")
    @Owner("Avinash Sinha")
    public void test_CdpCommandsTest() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 600);
        deviceMetrics.put("height", 1000);
        deviceMetrics.put("deviceScaleFactor", 50);
        deviceMetrics.put("mobile", true);

        // executeCDP Command to construct the own CDP functions
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By hamburgerIconLocator = By.cssSelector(".navbar-toggler");
        WebElement hamburgerIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerIconLocator));
        hamburgerIcon.click();

        By libraryLinkLocator = By.linkText("Library");
        WebElement libraryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(libraryLinkLocator));
        libraryLink.click();

        driver.quit();

    }
}