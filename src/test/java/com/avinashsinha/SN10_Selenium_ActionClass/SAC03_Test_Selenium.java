package com.avinashsinha.SN10_Selenium_ActionClass;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SAC03_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Actions Methods")
    public void test_Actions() {

        String URL = "https://www.makemytrip.com/";
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement bigPopBox = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        bigPopBox.click();

        WebElement smallPopBox = driver.findElement(By.xpath("//span[@data-testid='travel-card-close']"));
        smallPopBox.click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity)
                .click()
                .sendKeys(fromCity,"IXC")
                .build().perform();

        waitJVM(3000);

        List<WebElement> listAutoSuggestion = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));

        for (WebElement suggest : listAutoSuggestion) {
            if (suggest.getText().contains("Chandigarh Airport")) ;
            suggest.click();
        }
    }
}