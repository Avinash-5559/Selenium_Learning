package com.avinashsinha.SN09_Selenium_WebTables;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class SWT02_Test_Selenium_DynamicWebTable {

    @Test
    @Description("Verify the Web Dynamic Tables")
    @Owner("Avinash Sinha")
    public void test_WebTables() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");
        //edgeOptions.addArguments("--headless=new");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

        driver.get("https://awesomeqa.com/webtable1.html");

        // XPath = //table[@summary='Sample Table']/tbody

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 0; i < rows.size(); i++) {

            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            for (WebElement printColumnsData : columns) {
                System.out.println(printColumnsData.getText());
            }
        }

        Thread.sleep(3000);
        driver.quit();

    }
}