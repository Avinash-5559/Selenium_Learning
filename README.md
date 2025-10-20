# Selenium Learning Framework - UI Automation

![Java](https://img.shields.io/badge/Java-11%2B-007396?logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-IDE-000000?logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-Framework-FF6C37?logo=testng&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-Web%20Automation-43B02A?logo=selenium&logoColor=white)
![Apache POI](https://img.shields.io/badge/Apache%20POI-Excel%20DataDriven-2496ED?logo=apache&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-Reports-FF69B4?logo=qameta&logoColor=white)


This project is a **UI Automation Learning Framework** built using **Selenium WebDriver**, **Java**, and **TestNG**.
It demonstrates end-to-end **Selenium concepts**, including locators, waits, user interactions, JavaScript Executor, file uploads, window handling, and data-driven testing using **Apache POI** and **Excel**.

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

## ⚙️ Tech Stack
- **Java 11+**
- **IntelliJ IDEA** (IDE for development)
- **Maven** (Build and dependency management)
- **Selenium WebDriver** (Browser automation)
- **TestNG** (Testing framework)
- **Apache POI** (Excel-driven data management)
- **Allure Reports** (Reporting)
- **Hybrid Learning Structure** (Each module focused on a Selenium concept)

---

## 🏗️ Project Structure
```base
Selenium_Learning/
│
├── .allure/                                           # Allure configuration
├── .idea/                                             # IntelliJ IDEA project settings
├── allure-results/                                    # Allure report results (generated after test runs)
├── pom.xml                                            # Maven dependencies and plugins
├── .gitignore
│
├── src/
│   ├── main/
│   │   └── java/com/avinashsinha/                     # Utility and helper classes (if any)
│   │
│   └── test/
│       └── java/com/avinashsinha/
│           ├── SN01_Selenium_Basics/
│           ├── SN02_Selenium_Locators/
│           ├── SN03_Selenium_XPath/
│           ├── SN04_Selenium_Waits/
│           ├── SN05_Selenium_ULElements/
│           ├── SN06_Selenium_WaitHelper/
│           ├── SN07_Selenium_SVG_Elements/
│           ├── SN08_Selenium_Mini_Project/
│           ├── SN09_Selenium_WebTables/
│           ├── SN10_Selenium_ActionClass/
│           ├── SN11_Selenium_FileUpload/
│           ├── SN12_Selenium_Windows/
│           ├── SN13_Selenium_JS_Executor/
│           ├── SN14_Selenium_JS_Executor_ShadowDOM/
│           ├── SN15_Selenium_Relative_Locators/
│           ├── SN16_Selenium_Exceptions/
│           └── SN17_Selenium_DataDrivenTestingPOI/
│
│   └── resources/
│       └── TestData.xlsx                              # Test data for Excel-driven tests
│
├── testNG-xmls/                                       # Collection of TestNG suite XMLs
│   ├── testng_SAC01_Test_Selenium.xml
│   ├── testng_SB01_Test_Selenium.xml
│   ├── testng_SUI01_Test_Selenium.xml
│   ├── testng_SW01_Test_Selenium.xml
│   ├── testng_SSVG01_Test_Selenium.xml
│   ├── testng_SXP01_Test_Selenium.xml
│   ├── testng_UtilExcel.xml
│   └── ... (additional suite files)
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
