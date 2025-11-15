package com.avinashsinha.SN12_Selenium_Windows;

import com.avinashsinha.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SWD01_Test_Selenium extends TestCaseBoilerPlate {

    @Test
    @Description("TC#1 : Verify the Windows Handle")
    public void test_WindowsHandle() {

        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);

        String parentWindow = driver.getWindowHandle();
        System.out.println("\nParent Window : " + parentWindow);

        WebElement clickButton = driver.findElement(By.partialLinkText("Click Here"));
        clickButton.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("\nChild Window  : " + windowHandles);

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("New Window")) {
                System.out.println("\nTest Case is Passed");
                waitJVM(3000);
            }
        }
        driver.switchTo().window(parentWindow);
    }
}