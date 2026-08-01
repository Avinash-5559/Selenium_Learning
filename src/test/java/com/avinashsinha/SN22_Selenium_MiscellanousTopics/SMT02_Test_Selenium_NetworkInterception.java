package com.avinashsinha.SN22_Selenium_MiscellanousTopics;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v148.fetch.Fetch;
import org.openqa.selenium.devtools.v148.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v148.fetch.model.RequestStage;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class SMT02_Test_Selenium_NetworkInterception {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions options = new EdgeOptions();
        //options.addArguments("--inprivate");
        options.addArguments("--start-maximized");

        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify to Handle the Network Interception of the Website")
    @Owner("Avinash Sinha")
    public void test_NetworkInterception() {

        // Access to the DevTools

        DevTools devTools = ((EdgeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Fetch.enable(
                        Optional.of
                                (
                                        List.of
                                                (new RequestPattern(
                                                                Optional.of("*"),
                                                                Optional.empty(),
                                                                Optional.of(RequestStage.REQUEST)
                                                        )
                                                )
                                ),
                        Optional.empty()
                )
        );

        devTools.addListener(Fetch.requestPaused(), request -> {

            System.out.println("Intercepted!!!");
            System.out.println(request.getRequest().getMethod());
            System.out.println(request.getRequest().getUrl());

            String url = request.getRequest().getUrl();

            if (url.contains("verify")) {

                String jsonResponse = """
                        {
                            "status": "SUCCESS",
                            "message": "Citizen registration verified successfully.",
                            "transaction_id": "MOCK-TXN-SELENIUM-LEARNING",
                            "amount_deducted": "₹00.00 (~$0.00 USD)",
                            "username": "Avinash",
                            "timestamp": "2026-03-14T18:39:56.656Z"
                        }
                        """;

                String jsonResponseBase64 = Base64.getEncoder().encodeToString(jsonResponse.getBytes(StandardCharsets.UTF_8));

                devTools.send(Fetch.fulfillRequest(request.getRequestId(), 200, Optional.empty(),
                        Optional.empty(), Optional.of(jsonResponseBase64), Optional.empty()));

            } else {

                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.empty(),
                        Optional.empty(), Optional.empty(), Optional.empty()));

            }

        });

        String url = "http://mock-api.techwithjatin.com/";
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement usernameTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameTextBox.sendKeys("Avinash");

        WebElement passwordTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordTextBox.sendKeys("avinash1234");

        WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerBtn")));
        registerButton.click();

        System.out.println("Register Button Clicked Successfully");

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