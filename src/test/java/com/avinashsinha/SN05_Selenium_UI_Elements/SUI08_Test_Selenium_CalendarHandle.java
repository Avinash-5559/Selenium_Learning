package com.avinashsinha.SN05_Selenium_UI_Elements;

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

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SUI08_Test_Selenium_CalendarHandle {

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
    @Description("TC#1 : Verify to Expected Date is equal to the Actual Date")
    @Owner("Avinash Sinha")
    public void test_CalendarHandle() {

        String monthNumber = "6";
        String dayNumber = "15";
        String yearNumber = "2027";

        String[] expectedList = {monthNumber, dayNumber, yearNumber};

        String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        driver.get(URL);

        // Click the Calendar
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

        // Navigate to the Year
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();

        // Select Year
        driver.findElement(By.xpath("//button[text()='" + yearNumber + "']")).click();

        // Select Month
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber) - 1).click();

        // Select Day
        driver.findElement(By.xpath("//abbr[text()='" + dayNumber + "']")).click();

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        System.out.print("\nSelected Calendar Date : ");
        for (int i = 0; i < actualList.size(); i++) {
            System.out.print(actualList.get(i).getAttribute("value") + (i < 2 ? "/" : ""));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(5000);
        driver.quit();

    }

}