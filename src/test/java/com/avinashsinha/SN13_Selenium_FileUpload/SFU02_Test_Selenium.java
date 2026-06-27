package com.avinashsinha.SN13_Selenium_FileUpload;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class SFU02_Test_Selenium {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

    }

    @Test
    @Description("TC#1 : Verify the File Upload")
    @Owner("Avinash Sinha")
    public void test_FileUpload() throws IOException {

        String url = "https://rahulshettyacademy.com/upload-download-test/index.html";
        driver.get(url);

        String fruitName = "Banana";
        String updatedValue = "584";
        String workingDirectory = System.getProperty("user.dir");
        String fullFilePath = workingDirectory + "/src/test/java/com/avinashsinha/SN13_Selenium_FileUpload/download.xlsx";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Download the Excel File
        By downloadButtonLocator = By.cssSelector("#downloadButton");
        WebElement downloadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButtonLocator));
        downloadButton.click();

        // Update the Excel File : getColumnNumber for Price & getRowNumber for fruitName
        int col = getColumnNumber(fullFilePath, "price");
        int row = getRowNumber(fullFilePath, fruitName);

        Assert.assertTrue(updateCell(fullFilePath, row, col, updatedValue));

        // Upload the Updated Excel File
        By chooseFileButtonLocator = By.cssSelector("input[type='file']");
        WebElement chooseFileButton = wait.until(ExpectedConditions.elementToBeClickable(chooseFileButtonLocator));
        chooseFileButton.sendKeys(fullFilePath);

        // Wait for the Upload Success Message Appear
        By toastMessageLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessageLocator));

        String toastMessageText = toastMessage.getText();
        System.out.println("\nToast Message Text Appear on the Screen : " + toastMessageText);

        Assert.assertEquals(toastMessageText, "Updated Excel Data Successfully.");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastMessageLocator));

        // Verify Updated Excel data showing in the Web Table
        By priceColumnLocator = By.xpath("//div[contains(text(),'Price')]");
        WebElement priceColumnCell = wait.until(ExpectedConditions.visibilityOfElementLocated(priceColumnLocator));
        String priceColumn = priceColumnCell.getAttribute("data-column-id");

        By actualPriceLocator = By.xpath("//div[contains(text(),'" + fruitName + "')]/parent::div/parent::div/div[@id='cell-" + priceColumn + "-undefined']");
        WebElement actualPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(actualPriceLocator));
        actualPrice.getText();

        Assert.assertEquals(actualPrice.getText(), updatedValue);

    }

    private static int getColumnNumber(String fileName, String columnName) throws IOException {

        ArrayList<String> arrayList = new ArrayList<String>();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next();

        Iterator<Cell> cell = firstRow.cellIterator();

        int k = 1;
        int column = 0;

        while (cell.hasNext()) {
            Cell value = cell.next();
            if (value.getStringCellValue().equalsIgnoreCase(columnName)) {
                column = k;
            }
            k++;
        }

        return column;

    }

    private static int getRowNumber(String fileName, String text) throws IOException {

        ArrayList<String> arrayList = new ArrayList<String>();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rows = sheet.iterator();

        int k = 1;
        int rowIndex = -1;

        while (rows.hasNext()) {

            Row row = rows.next();

            Iterator<Cell> cells = row.cellIterator();

            while (cells.hasNext()) {
                Cell cell = cells.next();
                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(text)) {
                    rowIndex = k;
                }
            }
            k++;
        }

        return rowIndex;

    }

    private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {

        ArrayList<String> arrayList = new ArrayList<String>();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Row rowField = sheet.getRow(row - 1);

        Cell cellField = rowField.getCell(col - 1);
        cellField.setCellValue(updatedValue);

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        workbook.write(fileOutputStream);
        workbook.close();

        fileOutputStream.close();

        return true;

    }


    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

}