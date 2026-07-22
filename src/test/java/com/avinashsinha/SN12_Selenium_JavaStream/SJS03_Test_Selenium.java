package com.avinashsinha.SN12_Selenium_JavaStream;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SJS03_Test_Selenium {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");
        //edgeOptions.addArguments("--headless=new");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify the Expected List and Actual List")
    @Owner("Avinash Sinha")
    public void test_searchBox() {

        String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        driver.get(URL);

        String veggieName = "Apple";

        driver.findElement(By.id("search-field")).sendKeys(veggieName);

        List<WebElement> veggiesList = driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> filteredList = veggiesList.stream().filter(veggie -> veggie.getText().contains(veggieName))
                .collect(Collectors.toList());

        Assert.assertEquals(veggiesList.size(),filteredList.size());
    }

    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}