package com.avinashsinha.SN09_Selenium_WebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class SWT01_Test_Selenium_StaticWebTable {

    @Test
    @Description("Verify the Web Tables")
    public void test_WebTables() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless=new");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable.html");

        // XPath : //table[@id='customers']/tbody/tr[5]/td[2]

        /*
            XPath :
                    //table[@id='customers']/tbody/tr[
                    i
                    ]/td[
                    j
                    ]
         */


        String first_part = "//table[@id='customers']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[5]/td")).size();

        for (int i = 2; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {

                String dynamicXPath = first_part + i + second_part + j + third_part;
                String tableData = driver.findElement(By.xpath(dynamicXPath)).getText();
                //System.out.println(tableData);

                if (tableData.contains("Helen Bennett")) {
                    String countryPath = dynamicXPath + "/following-sibling::td";
                    String countryText = driver.findElement(By.xpath(countryPath)).getText();
                    System.out.println("\nHelen Bennett is in : " + countryText);
                }
            }
        }

        Thread.sleep(3000);
        driver.quit();

    }
}