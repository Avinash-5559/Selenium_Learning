package com.avinashsinha.SN01_Selenium_Basics;

// Website : https://peter.sh/experiments/chromium-command-line-switches/

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class SB06_Test_Selenium {

    @Test
    @Description("TC#1 : Option Class")
    @Owner("Avinash Sinha")
    public void test_VerifyOptionClass() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();

        // edgeOptions.addArguments("--inprivate");

        /*
            For Chrome  : --private-window
            For Edge    : --inprivate
            For Firefox : --incognito
        */

        // edgeOptions.addArguments("--window-size=800,600");

        // edgeOptions.addArguments("--start-maximized");

        edgeOptions.addArguments("--headless-new");

        EdgeDriver driver = new EdgeDriver(edgeOptions);

        Thread.sleep(3000);

        driver.quit();
    }
}