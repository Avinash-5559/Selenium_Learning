# Selenium Learning Framework - UI Automation

![Java](https://img.shields.io/badge/Java-11%2B-007396?logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-IDE-000000?logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-Framework-FF6C37?logo=testng&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-Web%20Automation-43B02A?logo=selenium&logoColor=white)
![Apache POI](https://img.shields.io/badge/Apache%20POI-Excel%20DataDriven-2496ED?logo=apache&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-Reports-FF69B4?logo=qameta&logoColor=white)

---

## 🗂️ Overview  

This project is a **UI Automation Learning Framework** built using **Selenium WebDriver**, **Java**, and **TestNG**.

It demonstrates end-to-end **Selenium concepts**, including locators, waits, user interactions, JavaScript Executor, file uploads, window handling, and data-driven testing using **Apache POI** and **Excel**.

---

## ⚙️ Tech Stack

- **Java 11+**
- **IntelliJ IDEA** – IDE for development
- **Maven** – Build & dependency management
- **Selenium WebDriver** – Browser automation
- **TestNG** – Testing framework
- **Apache POI** – Excel-based data handling
- **Allure Reports** – Reporting framework
- **Hybrid Learning Structure** – Each module focused on a Selenium concept

---

## 🚀 Features
- Practical examples covering all **Selenium fundamentals**
- Each topic implemented in a separate Java package (modular design)
- Includes real-world examples for:
  - **Locators, XPath, Waits, WebTables**
  - **Actions Class, Windows/Frames Handling**
  - **JavaScript Executor, Shadow DOM, Relative Locators**
  - **Data-Driven Testing using Apache POI**
- Organised **TestNG suite files** for easy test execution
- Integrated **Allure Reporting** for detailed and visually appealing reports

---

## 🏗️ Project Structure

```bash
Selenium_Learning/
│
├── .allure/                                                            # Allure configuration
├── .idea/                                                              # IntelliJ IDEA project files
├── .mvn/                                                               # Maven wrapper files
├── allure-report/                                                      # Allure generated HTML report
├── allure-results/                                                     # Allure results after test execution
├── pom.xml                                                             # Maven dependencies & build setup
├── .gitignore
│
├── src/
│   ├── main/
│   │   └── java/com.avinashsinha/                        
│   │
│   ├── test/
│   │   └── java/com.avinashsinha/
│   │       ├── TestCaseBoilerPlate.java
│   │       │
│   │       ├── SN01_Selenium_Basics/
│   │       │   ├── SB01_Test_Selenium.java
│   │       │   ├── SB02_Test_Selenium.java
│   │       │   ├── SB03_Test_Selenium.java
│   │       │   ├── SB04_Test_Selenium.java
│   │       │   ├── SB05_Test_Selenium.java
│   │       │   ├── SB06_Test_Selenium.java
│   │       │   ├── SB07_Test_Selenium.java
│   │       │   └── SB08_Test_Selenium.java
│   │       │
│   │       ├── SN02_Selenium_Locators/
│   │       │   ├── SL01_Test_Selenium_Mini_Project_1.java
│   │       │   ├── SL02_Test_Selenium_Mini_Project_2.java
│   │       │   └── SL03_Test_Selenium_Mini_Project_3.java
│   │       │
│   │       ├── SN03_Selenium_XPath/
│   │       │   └── SXP01_Test_Selenium_Mini_Project_1.java
│   │       │
│   │       ├── SN04_Selenium_Waits/
│   │       │   ├── SW01_Test_Selenium_ThreadSleep.java
│   │       │   ├── SW02_Test_Selenium_ImplicitWait.java
│   │       │   ├── SW03_Test_Selenium_ExplicitWait.java
│   │       │   ├── SW04_Test_Selenium_MiniProject_1.java
│   │       │   └── SW05_Test_Selenium_FluentWait.java
│   │       │
│   │       ├── SN05_Selenium_ULElements/
│   │       │   ├── SUI01_Test_Selenium_InputBox.java
│   │       │   ├── SUI02_Test_Selenium_CheckBox.java
│   │       │   ├── SUI03_Test_Selenium_RadioButton.java
│   │       │   ├── SUI04_Test_Selenium_StaticSelect.java
│   │       │   ├── SUI05_Test_Selenium_JavaScriptAlert.java
│   │       │   ├── SUI06_Test_Selenium_JavaScriptConfirm.java
│   │       │   └── SUI07_Test_Selenium_JavaScriptPrompt.java
│   │       │
│   │       ├── SN06_Selenium_WaitHelper/
│   │       │   └── SWH01_Test_Selenium_WaitHelper.java
│   │       │
│   │       ├── SN07_Selenium_SVG_Elements/
│   │       │   ├── SSVGE01_Test_Selenium.java
│   │       │   └── SSVGE02_Test_Selenium.java
│   │       │
│   │       ├── SN08_Selenium_Mini_Project/
│   │       │   └── SMP01_Test_Selenium.java
│   │       │
│   │       ├── SN09_Selenium_WebTables/
│   │       │   ├── SWT01_Test_Selenium_StaticWebTable.java
│   │       │   └── SWT02_Test_Selenium_DynamicWebTable.java
│   │       │
│   │       ├── SN10_Selenium_ActionClass/
│   │       │   ├── SAC01_Test_Selenium.java
│   │       │   ├── SAC02_Test_Selenium.java
│   │       │   ├── SAC03_Test_Selenium.java
│   │       │   ├── SAC04_Test_Selenium.java
│   │       │   └── SAC05_Test_Selenium.java
│   │       │
│   │       ├── SN11_Selenium_FileUpload/
│   │       │   ├── FileUpload.txt
│   │       │   └── SFU01_Test_Selenium.java
│   │       │
│   │       ├── SN12_Selenium_Windows/
│   │       │   └── SWD01_Test_Selenium.java
│   │       │
│   │       ├── SN13_Selenium_JS_Executor/
│   │       │   └── SJS01_Test_Selenium.java
│   │       │
│   │       ├── SN14_Selenium_JS_Executor_ShadowDOM/
│   │       │   └── SDOM01_Test_Selenium.java
│   │       │
│   │       ├── SN15_Selenium_Relative_Locators/
│   │       │   ├── SRL01_Test_Selenium.java
│   │       │   ├── SRL02_Test_Selenium.java
│   │       │   └── SRL03_Test_Selenium.java
│   │       │
│   │       ├── SN16_Selenium_Exceptions/
│   │       │   ├── SEO01_Test_Selenium_NoSuchElement.java
│   │       │   ├── SEO02_Test_Selenium_StaleElement.java
│   │       │   ├── SEO02_Test_Selenium_StaleElement_FIX.java
│   │       │   └── SEO03_Test_Selenium_TimeOut.java
│   │       │
│   │       └── SN17_Selenium_DataDrivenTestingPOI/
│   │           ├── SDDT01_Test_Selenium.java
│   │           ├── SDDT02_Test_Selenium.java
│   │           └── UtilExcel.java
│   │
│   └── resources/
│       └── TestData.xlsx
│
├── testNG-xmls/                                                        # Organized TestNG suite files
│   ├── testng_SAC01_Test_Selenium.xml
│   ├── testng_SB01_Test_Selenium.xml
│   ├── testng_SUI01_Test_Selenium.xml
│   ├── testng_SW01_Test_Selenium.xml
│   ├── testng_SSVG01_Test_Selenium.xml
│   ├── testng_SXP01_Test_Selenium.xml
│   ├── testng_UtilExcel.xml
│   └── ... (many additional suite files)
│
└── README.md
```

---

## ▶️ Running Tests

### Run a Specific TestNG Suite

```bash
mvn clean test -DsuiteXmlFile=testng_SAC01_Test_Selenium.xml
```
#### Commonly Used TestNG XMLs

| TestNG File                       | Purpose                    |
| :-------------------------------- | :------------------------- |
| `testng_SAC01_Test_Selenium.xml`  | Basic Selenium tests       |
| `testng_SB01_Test_Selenium.xml`   | Browser handling           |
| `testng_SUI01_Test_Selenium.xml`  | UI Elements & Interactions |
| `testng_SW01_Test_Selenium.xml`   | Waits and Synchronization  |
| `testng_SSVG01_Test_Selenium.xml` | SVG Elements Handling      |
| `testng_SXP01_Test_Selenium.xml`  | XPath Practice             |
| `testng_UtilExcel.xml`            | Excel Data-Driven Tests    |

---

## 📊 Reporting

### Generate Allure Report

```bash
allure serve allure-results
```

This will launch an interactive **Allure report dashboard** in your browser.

Example Allure dashboard view:

![a](https://github.com/user-attachments/assets/11e3071c-0d24-43b5-8ecc-f4049fc46928)

---

## 🧩 Example — Data-Driven Test with Apache POI

```java
@Test(dataProvider = "ExcelDataProvider")
public void loginTest(String username, String password) {
    driver.get("https://example.com/login");
    driver.findElement(By.id("username")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("loginBtn")).click();
}
```

---

## 📚 Selenium Learning Modules

| Module | Topic                            |
| :----- | :------------------------------- |
| SN01   | Selenium Basics                  |
| SN02   | Locators                         |
| SN03   | XPath                            |
| SN04   | Waits                            |
| SN05   | Web Elements                     |
| SN06   | Wait Helper                      |
| SN07   | SVG Elements                     |
| SN08   | Mini Project                     |
| SN09   | Web Tables                       |
| SN10   | Action Class                     |
| SN11   | File Upload                      |
| SN12   | Windows & Frames                 |
| SN13   | JavaScript Executor              |
| SN14   | Shadow DOM                       |
| SN15   | Relative Locators                |
| SN16   | Exception Handling               |
| SN17   | Data-Driven Testing (Apache POI) |

---

## 📌 Author

👤 Avinash Sinha

---

📝 This repository is created exclusively for **educational and practice use**.

---
