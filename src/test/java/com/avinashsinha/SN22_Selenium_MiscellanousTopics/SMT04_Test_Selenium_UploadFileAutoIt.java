package com.avinashsinha.SN22_Selenium_MiscellanousTopics;

/*
        Procedure :
                    1) Shift the focus to the file upload Windows
                    2) Set text/path into file name edit box
                    3) Click open to upload file

        Process :
                    1) Go the Script Editor for this go to C:\Program Files (x86)\AutoIt3\SciTE and click SciTE.exe file
                    2) Text Editor box will open
                    3) Record Window Component objects for this go to C:\Program Files (x86)\AutoIt3 and click AutoIt3.exe file
                    4) Write Script on the Editor and save it .au3 extension
                    5) Convert the .au3 file to .exe by compilation for this right click the mouse and then select Compile Script(x86)
                    6) .exe file is now created
                    7) Call this .exe file with "Runtime class" in Java into your selenium tests
*/

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

import java.io.IOException;
import java.time.Duration;

public class SMT04_Test_Selenium_UploadFileAutoIt {

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
    @Description("TC#1 : Verify to handle the Window Page to Upload file by the help of AutoIt")
    @Owner("Avinash Sinha")
    public void test_fileUploadAutoIt() throws IOException, InterruptedException {

        driver.get("https://www.ilovepdf.com/pdf_to_jpg");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By selectPdfFileLocator = By.id("pickfiles");
        WebElement selectPdfFile = wait.until(ExpectedConditions.visibilityOfElementLocated(selectPdfFileLocator));
        selectPdfFile.click();

        Thread.sleep(3000);

        Runtime.getRuntime().exec("C:\\Users\\HP\\Documents\\AutoIt\\fileupload.exe");

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