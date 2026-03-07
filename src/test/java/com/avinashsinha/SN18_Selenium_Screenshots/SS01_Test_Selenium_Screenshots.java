package com.avinashsinha.SN18_Selenium_Screenshots;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SS01_Test_Selenium_Screenshots {

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
    @Description("TC#1 : Verify to Take the Screenshot of the WebPage")
    @Owner("Avinash Sinha")
    public void test_TakeScreenshot() throws IOException {

        String URL = "https://www.google.com";
        driver.get(URL);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFolder = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }

        File destinationFolder = new File(screenshotDir, "screenshot_" + timeStamp + ".png");

        FileUtils.copyFile(sourceFolder, destinationFolder);

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