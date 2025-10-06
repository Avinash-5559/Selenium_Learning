package com.avinashsinha.SN02_Selenium_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class SL02_Test_Selenium_Mini_Project_2 {

    @Test
    @Description("TC#1 : Verify to Click the VWO Trial Link")
    public void test_VerifyClickTrialLink() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.manage().deleteAllCookies();

        driver.navigate().to("https://app.vwo.com/#/login");

        /*
        <a 
            href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage" 
            class="text-link Td(n)" 
            data-qa="bericafeqo">Start a free trial
        </a>
        */

        WebElement linkText = driver.findElement(By.linkText("Start a free trial"));

        linkText.click();

        Thread.sleep(3000);

        driver.quit();

    }
}