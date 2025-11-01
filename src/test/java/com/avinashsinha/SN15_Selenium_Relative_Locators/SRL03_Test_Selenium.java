package com.avinashsinha.SN15_Selenium_Relative_Locators;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SRL03_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Relative Locators")
    public void test_RelativeLocators() {

        String URL = "https://www.aqi.in/real-time-most-polluted-city-ranking";
        driver.get(URL);

        waitJVM(5000);

        WebElement svgElement = driver.findElement(By.xpath("//div[contains(@class,'close-button')]/*[local-name()='svg']"));
        svgElement.click();

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox.sendKeys("India" + Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement toScroll = driver.findElement(By.xpath("//div[contains(@class,'footer flex')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", toScroll);

        waitJVM(1000);

        List<WebElement> locations = driver.findElements(By.cssSelector("div.location-name>p"));

        for (WebElement location : locations) {

            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();
            String aqi = driver.findElement(with(By.tagName("div")).toRightOf(location)).getText();

            System.out.println(" | " + rank + " | " + location.getText() + " | " + aqi + " | ");

        }
    }
}