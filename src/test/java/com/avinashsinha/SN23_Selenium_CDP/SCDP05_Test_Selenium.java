package com.avinashsinha.SN23_Selenium_CDP;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v145.fetch.Fetch;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Optional;

public class SCDP05_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to Intercept (or Mocking) the Network / API Responses")
    @Owner("Avinash Sinha")
    public void test_NetworkMocking() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Fetch.enable(
                        Optional.empty(),
                        Optional.empty()
                )
        );

        devTools.addListener(Fetch.requestPaused(), request -> {
            if (request.getRequest().getUrl().contains("shetty")) {
                String mockURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println("\nMock URL : " + mockURL);

                devTools.send(Fetch.continueRequest(request.getRequestId(),
                                Optional.of(mockURL),
                                Optional.of(request.getRequest().getMethod()),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()
                        )
                );

            } else {

                devTools.send(Fetch.continueRequest(request.getRequestId(),
                                Optional.empty(),
                                Optional.of(request.getRequest().getUrl()),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()
                        )
                );

            }
        });

        driver.navigate().to("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

        //System.out.println(driver.findElement(By.cssSelector("p")).getText());

        driver.quit();

    }

}