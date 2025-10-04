package com.avinashsinha.SN01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SB02_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to Open the URL on Edge Browser")
    public void test_VerifyOpenURL() {

        // Open the URL
        WebDriver driver = new EdgeDriver();

        // Navigate the URL
        driver.get("https://google.com/");

        // Assert the URL i.e. Validation
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");

        // AsseertJ Validation
        assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");

        driver.quit();
    }
}