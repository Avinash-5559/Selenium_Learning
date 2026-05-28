package com.avinashsinha.SN23_Selenium_CDP;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v145.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class SCDP01_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to Device metrics override function to simulate browser as mobile")
    @Owner("Avinash Sinha")
    public void test_MobileEmulatorTest() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Send Command to CDP Methods -> CDP Methods will invoke and get access to Chrome dev tools
        devTools.send(Emulation.setDeviceMetricsOverride(
                        600,
                        1000,
                        50,
                        true,
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()
                )
        );

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