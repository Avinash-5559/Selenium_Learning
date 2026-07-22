package com.avinashsinha.SN23_Selenium_CDP;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v148.network.Network;
import org.openqa.selenium.devtools.v148.network.model.Request;
import org.openqa.selenium.devtools.v148.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Optional;

public class SCDP04_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to extract Network Responses and status codes")
    @Owner("Avinash Sinha")
    public void test_NetworkLogActivity() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()
                )
        );

        // Request Event
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
            //System.out.println("\nRequest URL : " + req.getUrl());
        });

        // Response Event
        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            System.out.println("\nResponse URL : " + res.getUrl() + " | " + "Status Code : " + res.getStatus());
            if (res.getStatus().toString().startsWith("4")) {
                System.out.println(res.getUrl() + " is failing with Status Code " + res.getStatus());
            }
        });

        driver.navigate().to("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

        driver.quit();

    }

}