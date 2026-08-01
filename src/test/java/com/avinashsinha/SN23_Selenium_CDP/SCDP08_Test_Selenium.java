package com.avinashsinha.SN23_Selenium_CDP;

import com.google.common.collect.ImmutableList;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v148.network.Network;
import org.openqa.selenium.devtools.v148.network.model.ConnectionType;
import org.openqa.selenium.devtools.v148.network.model.NetworkConditions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class SCDP08_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to emulate the network speed ")
    @Owner("Avinash Sinha")
    public void test_NetworkSpeed() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty())
        );

        NetworkConditions conditions = new NetworkConditions(
                "default",                              // Rule ID (replaces offline boolean)
                3000,                                           // Latency (ms)
                20000,                                          // Download throughput
                100000,                                         // Upload throughput
                Optional.of(ConnectionType.ETHERNET),           // Connection type
                Optional.empty(),                               // packet loss (optional)
                Optional.empty(),                               // queue length (optional)
                Optional.empty()                                // reordering (optional)
        );

        devTools.send(Network.emulateNetworkConditionsByRule(
                false,
                ImmutableList.of(conditions)
        ));

        devTools.addListener(Network.loadingFailed(), loadingFailed ->
        {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });

        driver.navigate().to("https://rahulshettyacademy.com/angularAppdemo/");

        long startTime = System.currentTimeMillis();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By virtualButtonLocator = By.cssSelector("button[routerlink*='library']");
        WebElement virtualButton = wait.until(ExpectedConditions.visibilityOfElementLocated(virtualButtonLocator));
        virtualButton.click();

        long endTime = System.currentTimeMillis();

        System.out.println("\nTotal execution time : " + (endTime - startTime) + " ms");

        driver.quit();

    }
}
