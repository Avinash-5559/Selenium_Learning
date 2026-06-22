package com.avinashsinha.SN11_Selenium_FramesHandle;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SFH01_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify to Handle the Frame")
    @Owner("Avinash Sinha")
    public void test_FramesHandle() {

        String URL = "https://jqueryui.com/";
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        By droppableMenuLocator = By.xpath("//a[contains(text(),'Droppable')]");
        WebElement droppableMenu = wait.until(ExpectedConditions.elementToBeClickable(droppableMenuLocator));
        droppableMenu.click();

        By iframeLocator = By.cssSelector("iframe[class='demo-frame']");
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));

        /*

            // Switch to the Frame and handle by the indexing
            driver.switchTo().frame(0);

        */

        // Switch to the Frame and handle by the WebElement
        driver.switchTo().frame(iframe);

        By sourceLocator = By.id("draggable");
        WebElement source = wait.until(ExpectedConditions.elementToBeClickable(sourceLocator));
        source.click();

        By targetLocator = By.id("droppable");
        WebElement target = wait.until(ExpectedConditions.elementToBeClickable(targetLocator));
        target.click();

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target)
                .build().perform();

        // Move outside from the Frame
        driver.switchTo().defaultContent();

        By outsideFrameLocator = By.xpath("//a[contains(text(),'Resizable')]");
        WebElement outsideFrame = wait.until(ExpectedConditions.elementToBeClickable(outsideFrameLocator));
        outsideFrame.click();

    }
}