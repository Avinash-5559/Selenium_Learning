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

public class SJS02_Test_Selenium {

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
    public void test_matchList() {

        String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        driver.get(URL);

        String veggieName = "Rice";

        // Click on Column
        driver.findElement(By.xpath("//tr/th/span[text()='Veg/fruit name']")).click();

        // Capture all WebElements into List
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

        // Capture text of all WebElements into Original List
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        // Sort on the Original List into Sorted List
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // Compare Original List vs Sorted List
        Assert.assertEquals(sortedList, originalList);

        List<String> price;
        do {

            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            price = rows.stream().filter(s -> s.getText().contains(veggieName))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(s -> System.out.println("\nPrice of " + veggieName + " is : " + s));

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }

        } while (price.size() < 1);

    }

    private static String getPriceVeggie(WebElement s) {

        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return priceValue;

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