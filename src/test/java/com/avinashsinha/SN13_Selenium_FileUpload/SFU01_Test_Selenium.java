package com.avinashsinha.SN13_Selenium_FileUpload;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SFU01_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the File Upload")
    @Owner("Avinash Sinha")
    public void test_FileUpload() {

        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);

        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));

        String workingDirectory = System.getProperty("user.dir");
        //System.out.println(workingDirectory);

        uploadFileInput.sendKeys(workingDirectory + "/src/test/java/com/avinashsinha/SN13_Selenium_FileUpload/FileUpload.txt");

        driver.findElement(By.name("submit")).click();

    }

}