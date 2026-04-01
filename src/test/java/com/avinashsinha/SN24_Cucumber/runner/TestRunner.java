package com.avinashsinha.SN24_Cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/avinashsinha/SN23_Cucumber/feature",
        glue = {"com.avinashsinha.SN23_Cucumber"},
        tags = "@Smoke",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // No code needed inside, extending AbstractTestNGCucumberTests is enough
}