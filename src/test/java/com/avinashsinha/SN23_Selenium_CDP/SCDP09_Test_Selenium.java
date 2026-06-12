package com.avinashsinha.SN23_Selenium_CDP;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.function.Predicate;

public class SCDP09_Test_Selenium {

    @Test
    @Description("TC#1 : Verify to the Basic Authentication using Selenium uriPredicate function")
    @Owner("Avinash Sinha")
    public void test_BasicAuthentication() {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
        ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");

    }
}