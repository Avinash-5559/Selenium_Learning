package com.avinashsinha.SN23_Selenium_CDP;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v148.fetch.Fetch;
import org.openqa.selenium.devtools.v148.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v148.network.model.ErrorReason;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SCDP06_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to failed Network request calls")
    @Owner("Avinash Sinha")
    public void test_NetworkFailedRequest() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(
                        new RequestPattern(Optional.of("*GetBook*"),
                                Optional.empty(),
                                Optional.empty()
                        )
                )
        );

        devTools.send(Fetch.enable(patterns, Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), request -> {

            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));

        });

        driver.navigate().to("https://rahulshettyacademy.com/angularAppdemo/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        By virtualButtonLocator = By.cssSelector("button[routerlink*='library']");
        WebElement virtualButton = wait.until(ExpectedConditions.visibilityOfElementLocated(virtualButtonLocator));
        virtualButton.click();

        //driver.quit();

    }

}