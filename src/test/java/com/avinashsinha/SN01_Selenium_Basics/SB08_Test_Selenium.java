package com.avinashsinha.SN01_Selenium_Basics;

// Proxy : You can use the Proxy to access the internet without showing your own location or IP address.

import io.qameta.allure.Description;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class SB08_Test_Selenium {

    @Test
    @Description("TC#1 : Verify the Proxy")
    public void test_VerifyProxy() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("188.255.245.205:1080");
        edgeOptions.setCapability("proxy", proxy);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://www.google.com/?zx=1759499687300&no_sw_cr=1");

        Thread.sleep(3000);

        driver.quit();

    }
}