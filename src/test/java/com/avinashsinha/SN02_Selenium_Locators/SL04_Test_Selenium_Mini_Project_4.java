package com.avinashsinha.SN02_Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SL04_Test_Selenium_Mini_Project_4 {

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
    @Description("TC#1 : Verify the Links on the Page")
    @Owner("Avinash Sinha")
    public void test_VerifyTheLinks() {

        String URL = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(URL);

        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("'a' tag count : " + list.size());

        WebElement footerLocator = driver.findElement(By.id("gf-BIG"));
        System.out.println("Footer 'a' tag count : " + footerLocator.findElements(By.tagName("a")).size());

        WebElement columnLocator = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("Column 'a' tag count : " + columnLocator.findElements(By.tagName("a")).size());

        for (int i = 1; i < columnLocator.findElements(By.tagName("a")).size(); i++) {

            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnLocator.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

        }

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        while (iterator.hasNext()) {

            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());

        }

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(3000);
        driver.quit();

    }
}