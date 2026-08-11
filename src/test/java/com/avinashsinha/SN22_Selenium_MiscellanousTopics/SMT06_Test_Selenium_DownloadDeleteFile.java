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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class SMT06_Test_Selenium_DownloadDeleteFile {

    WebDriver driver;

    String downloadPath = System.getProperty("user.dir");

    @BeforeTest
    public void openBrowser() {

        // These HashMap Lines comes from the Documentation
        HashMap<String, Object> broswerPrefs = new HashMap<String, Object>();
        broswerPrefs.put("profile.default_content_settings.popups", 0);
        broswerPrefs.put("download.default_directory", downloadPath);

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", broswerPrefs);               // This line of code is used for preferences to set the path for downloaded file from browser

        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify to Download the file from Preference Path for browser and once its download it will delete as well")
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

        Thread.sleep(5000);

        File file = new File(downloadPath + "/PDF_page-0001.jpg");

        if (file.exists()) {
            Assert.assertTrue(file.exists());
            System.out.println("\nFile is downloaded");
            if (file.delete()) {
                System.out.println("\nFile is now deleted");
            }
        } else {
            System.out.println("\nFile doesn't exist");
            Assert.assertTrue(file.exists());
        }

    /*

    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

    */

    }

}