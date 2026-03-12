package com.avinashsinha.SN14_Selenium_Windows;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SWD02_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Window Handle")
    @Owner("Avinash Sinha")
    public void test_WindowHandles() {

        String URL = "https://rahulshettyacademy.com/loginpagePractise/#";
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        By blinkingTextLocator = By.cssSelector(".blinkingText");
        WebElement blinkingText = wait.until(ExpectedConditions.visibilityOfElementLocated(blinkingTextLocator));
        blinkingText.click();

        Set<String> windowHandles = driver.getWindowHandles();

        Iterator<String> iterator = windowHandles.iterator();

        String parentId = iterator.next();
        String childId = iterator.next();

        driver.switchTo().window(childId);

        String textExtractLocator = driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println("\nText Extract : " + textExtractLocator);

        String emailIdExtractLocator = textExtractLocator.split("at")[1].trim().split(" ")[0];
        System.out.println("\nEmailId Extract : " + emailIdExtractLocator);

        driver.switchTo().window(parentId);

        By usernameTextBoxLocator = By.id("username");
        WebElement usernameTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBoxLocator));
        usernameTextBox.sendKeys(emailIdExtractLocator);

    }

}