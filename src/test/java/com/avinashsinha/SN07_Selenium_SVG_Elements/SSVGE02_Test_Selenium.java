package com.avinashsinha.SN07_Selenium_SVG_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SSVGE02_Test_Selenium {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);

    }

    @Description("Verify Tripura is present in the map and click to zoom it")
    @Test
    public void test_India_Map_SVG() {

        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);

        driver.findElement(By.xpath("//button[text()='I understand and agree']")).click();

        List<WebElement> stateNames = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        for (WebElement state : stateNames) {
            System.out.println(state.getAttribute("aria-label"));
            if (state.getAttribute("aria-label").contains("Tripura")){
                state.click();
            }
        }
    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(3000);
        driver.quit();
    }
}