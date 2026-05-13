package com.avinashsinha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestCaseBoilerPlate {

    public WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--inprivate");
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();

    }

    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}