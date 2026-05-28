package com.avinashsinha.SN24_Cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void openBrowser() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        options.addArguments("--start-maximized");

        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");

    }

    @After
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }

    }

}