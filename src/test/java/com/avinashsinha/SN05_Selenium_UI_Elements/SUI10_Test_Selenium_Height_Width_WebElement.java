package com.avinashsinha.SN05_Selenium_UI_Elements;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SUI10_Test_Selenium_Height_Width_WebElement {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        //edgeOptions.addArguments("--headless=new");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify the Partial Screenshot")
    @Owner("Avinash Sinha")
    public void test_PartialScreenshot() throws IOException {

        String parentURL = "https://rahulshettyacademy.com/angularpractice/";
        driver.get(parentURL);

        String childURL = "https://rahulshettyacademy.com/client/#/auth/login";

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindowId = iterator.next();
        String childWindowId = iterator.next();
        driver.switchTo().window(childWindowId);

        driver.get(childURL);

        String textElement = driver.findElements(By.cssSelector("h1[class='title']")).get(0).getText();

        driver.switchTo().window(parentWindowId);

        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(textElement);

        System.out.println("\nHeight of the Tab is : " + name.getRect().getDimension().getHeight());
        System.out.println("\nWidth of the Tab is : " + name.getRect().getDimension().getWidth());

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(3000);
        driver.quit();

    }

}
