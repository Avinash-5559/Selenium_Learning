package com.avinashsinha.SN09_Selenium_WebTables;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.avinashsinha.SN06_Selenium_WaitHelper.SWH01_Test_Selenium_WaitHelper.waitJVM;

public class SWT03_Test_Selenium_IPLAutomation {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");
        //edgeOptions.addArguments("--headless=new");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify the Highest Points and NRR of the Team")
    @Owner("Avinash Sinha")
    public void test_IPLAutomation() {

        String URL = "https://www.iplt20.com/points-table/men";
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Step 1 : Find the entire WebTable
        By tableLocator = By.cssSelector(".ih-td-tab");
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));

        // Step 2 : Locate the tbody with the chaining of WebElement
        By tbodyLocator = By.id("pointsdata");
        WebElement tbody = table.findElement(tbodyLocator);

        // Step 3 : Find All table rows
        By tableRowLocator = By.tagName("tr");
        List<WebElement> tableRowsList = tbody.findElements(tableRowLocator);

        List<Team> teamList = new ArrayList<Team>();

        for (WebElement row : tableRowsList) {
            By tableDataRowLocator = By.tagName("td");
            List<WebElement> tableDataList = row.findElements(tableDataRowLocator);

            double nrr = Double.parseDouble(tableDataList.get(7).getText());
            int pts = Integer.parseInt(tableDataList.get(10).getText());
            Team team = new Team(tableDataList.get(0).getText(), tableDataList.get(2).getText(), nrr, pts);
            teamList.add(team);
        }

        /*
            for (Team data : teamList) {
            System.out.println(data);
            }
        */

        // 1. Max points
        int maxPoints = teamList.stream()
                .mapToInt(Team::getPoints)
                .max()
                .orElse(-1);

        // 2. Teams with max points
        List<Team> highestPointsTeams = teamList.stream()
                .filter(team -> team.getPoints() == maxPoints)
                .toList();

        // 3. Team with highest NRR
        Optional<Team> highestNrrTeam = teamList.stream()
                .max(Comparator.comparingDouble(Team::getNrr));

        // 4. Print highest points teams
        System.out.println("\nTeams with highest points (" + maxPoints + "):");
        for (Team team : highestPointsTeams) {
            System.out.println("Position: " + team.getPos() + ", Team: " + team.getTeamName() + ", NRR: " + team.getNrr() + ", Points: " + team.getPoints());
        }

        // 5. Print highest NRR team
        highestNrrTeam.ifPresent(team -> {
            System.out.println("\nTeam with highest NRR:");
            System.out.println("Position: " + team.getPos() + ", Team: " + team.getTeamName() + ", NRR: " + team.getNrr() + ", Points: " + team.getPoints());
        });

    }

    @AfterTest
    public void closeBrowser() {

        waitJVM(3000);
        driver.quit();

    }
}