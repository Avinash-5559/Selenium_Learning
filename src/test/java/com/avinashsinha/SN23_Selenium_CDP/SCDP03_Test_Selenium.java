package com.avinashsinha.SN23_Selenium_CDP;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SCDP03_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to set our own Location for Localization Testing")
    @Owner("Avinash Sinha")
    public void test_SetGeoLocation() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--use-fake-ui-for-media-stream"); // auto-allow location

        EdgeDriver driver = new EdgeDriver(options);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude", 40);
        coordinates.put("longitude", 3);
        coordinates.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("https://google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By searchTextBoxLocator = By.id("APjFqb");
        WebElement searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBoxLocator));
        searchTextBox.sendKeys("Netflix", Keys.ENTER);

        By firstSearchListedLocator = By.id("_-w6_aeiKA96ZseMPgbHRoQU_39");
        WebElement firstSearchListed = wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchListedLocator));
        firstSearchListed.click();

        By printedTextLocator = By.cssSelector(".eb5pmcc0");
        WebElement printedText = wait.until(ExpectedConditions.visibilityOfElementLocated(printedTextLocator));
        String text = printedText.getText();
        System.out.println(text);

        driver.quit();

    }
}