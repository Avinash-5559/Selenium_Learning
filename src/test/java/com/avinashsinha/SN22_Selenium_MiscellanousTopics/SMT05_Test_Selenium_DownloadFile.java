package com.avinashsinha.SN22_Selenium_MiscellanousTopics;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SMT05_Test_Selenium_DownloadFile {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        options.addArguments("--start-maximized");

        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify to Download file and check it exist in the system or not")
    @Owner("Avinash Sinha")
    public void test_fileDownload() throws IOException, InterruptedException {

        driver.get("https://www.ilovepdf.com/pdf_to_jpg");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By selectPdfFileLocator = By.id("pickfiles");
        WebElement selectPdfFile = wait.until(ExpectedConditions.visibilityOfElementLocated(selectPdfFileLocator));
        selectPdfFile.click();

        Thread.sleep(3000);

        Runtime.getRuntime().exec("C:\\Users\\HP\\Documents\\Selenium_Learning\\fileupload.exe");

        By convertToJpgButtonLocator = By.id("processTaskTextBtn");
        WebElement convertToJpgButton = wait.until(ExpectedConditions.visibilityOfElementLocated(convertToJpgButtonLocator));
        convertToJpgButton.click();

        By downloadJpgImageButtonLocator = By.id("pickfiles");
        WebElement downloadJpgImageButton = wait.until(ExpectedConditions.visibilityOfElementLocated(downloadJpgImageButtonLocator));
        downloadJpgImageButton.click();

        File file = new File("C:\\Users\\HP\\Downloads\\PDF_page-0001.jpg");

        if (file.exists()) {
            System.out.println("\nFile already downloaded");
        } else {
            System.out.println("\nFile doesn't downloaded");
        }

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