package com.avinashsinha.SN23_Selenium_CDP;

import com.google.common.collect.ImmutableList;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v148.fetch.Fetch;
import org.openqa.selenium.devtools.v148.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v148.fetch.model.RequestStage;
import org.openqa.selenium.devtools.v148.network.model.ErrorReason;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class SCDP07_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to blocking unwanted Network request calls to speed up the execution")
    @Owner("Avinash Sinha")
    public void test_BlockNetworkRequests() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Fetch.enable(
                Optional.of(ImmutableList.of(
                                new RequestPattern(
                                        Optional.of("*.jpg"),
                                        Optional.empty(),
                                        Optional.of(RequestStage.REQUEST)
                                ),
                                new RequestPattern(
                                        Optional.of("*.css"),
                                        Optional.empty(),
                                        Optional.of(RequestStage.REQUEST)
                                )
                        )
                ),
                Optional.empty()
        ));

        devTools.addListener(Fetch.requestPaused(), request -> {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });

        driver.navigate().to("https://rahulshettyacademy.com/angularAppdemo/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By browseProductButtonLocator = By.cssSelector(".btn-success");
        WebElement browseProductButton = wait.until(ExpectedConditions.visibilityOfElementLocated(browseProductButtonLocator));
        browseProductButton.click();

        By productButtonLocator = By.xpath("//div[contains(@class,'media-body')]/a[contains(@href,'products/1')]");
        WebElement productButton = wait.until(ExpectedConditions.visibilityOfElementLocated(productButtonLocator));
        productButton.click();

        By addToCartButtonLocator = By.cssSelector(".add-to-cart");
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButtonLocator));
        addToCartButton.click();

        By alreadyAddedTextLocater = By.cssSelector("p");
        WebElement alreadyAddedText = wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyAddedTextLocater));
        String addedText = alreadyAddedText.getText();

        System.out.println(addedText);

        driver.quit();

    }

}