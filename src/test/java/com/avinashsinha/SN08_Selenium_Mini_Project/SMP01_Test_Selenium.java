package com.avinashsinha.SN08_Selenium_Mini_Project;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SMP01_Test_Selenium {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        //edgeOptions.addArguments("--headless=new");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @Test
    @Description("TC#1 : Verify to entering the Details and Logout from the Website")
    public void test_CURA_HealthService() {

        String URL = "https://katalon-demo-cura.herokuapp.com/";
        driver.navigate().to(URL);

        WebElement makeAppointButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointButton.click();

        WebElement userInputBox = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userInputBox.sendKeys("John Doe");

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='txt-password']"));
        passwordInputBox.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("https://katalon-demo-cura.herokuapp.com/#appointment"));

        WebElement checkBox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkBox.click();

        WebElement radioButton = driver.findElement(By.id("radio_program_none"));
        radioButton.click();

        WebElement calendar = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        calendar.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'datepicker-dropdown')]")));

        String monthYear= driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).getText();

        while (!monthYear.equals("July 2026")){

            driver.findElement(By.xpath("(//th[@class=\"next\"])[1]")).click();
            monthYear= driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).getText();

        }

        driver.findElement(By.xpath("(//td[@class='day'])[26]")).click();

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Book the Appointment");

        WebElement bookAppointButton = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointButton.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2.until(ExpectedConditions.urlContains("https://katalon-demo-cura.herokuapp.com/appointment.php#summary"));

        WebElement commentText = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println("\nComment Text : " + commentText.getText());

        if (commentText.getText().equals("Book the Appointment")) {
            System.out.println("\nTest Case is Passed");

            WebElement sideBar = driver.findElement(By.xpath("//i[@class='fa fa-bars']"));
            sideBar.click();

            WebElement logoutButton = driver.findElement(By.linkText("Logout"));
            logoutButton.click();

            WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait4.until(ExpectedConditions.urlContains("https://katalon-demo-cura.herokuapp.com/"));

        } else {
            System.out.println("\nText Case is Failed");
        }

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(3000);
        driver.quit();

    }
}