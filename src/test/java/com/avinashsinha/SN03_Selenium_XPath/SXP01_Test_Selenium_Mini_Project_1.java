package com.avinashsinha.SN03_Selenium_XPath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SXP01_Test_Selenium_Mini_Project_1 {

    @Test
    @Description("TC#1 : Verify that valid Email, password on Appointment Page")
    public void test_KatalonLogin() throws Exception {

        WebDriver driver = new EdgeDriver();

        driver.manage().deleteAllCookies();

        driver.manage().window().maximize();

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment_btn = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment_btn.click();

        Thread.sleep(3000);

        List<WebElement> usernameInput_Box = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        usernameInput_Box.get(1).sendKeys("John Doe");

        List<WebElement> passwordInput_Box = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        passwordInput_Box.get(1).sendKeys("ThisIsNotAPassword");

        WebElement btnClick = driver.findElement(By.xpath("//button[@id='btn-login']"));
        btnClick.click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        WebElement appointText = driver.findElement(By.xpath("//h2[contains(text(),'Make Appointment')]"));
        Assert.assertEquals(appointText.getText(), "Make Appointment");

        driver.quit();

    }
}