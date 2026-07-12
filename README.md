# 🚀 Selenium Learning Framework - UI Automation

> A comprehensive **Selenium WebDriver learning repository** built using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, **Apache POI**, **Chrome DevTools Protocol (CDP)**, **Cucumber BDD**, and **Allure Reports**, covering UI automation concepts from **fundamentals to advanced real-world scenarios** through practical examples.

<p align="center">

![Java](https://img.shields.io/badge/Java-11+-blue?logo=openjdk)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?logo=selenium&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-Framework-brightgreen)
![Apache POI](https://img.shields.io/badge/Apache%20POI-Excel%20Support-blue)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23D96C?logo=cucumber&logoColor=white)
![CDP](https://img.shields.io/badge/Chrome%20DevTools-Protocol-4285F4?logo=googlechrome&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-Reports-ff69b4)

</p>

---

# 🗂️ Overview

This repository contains a comprehensive collection of **Selenium WebDriver automation programs** developed using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven** to master **UI Automation** through practical, real-world examples.

The repository is organized into dedicated learning modules covering **Browser Automation**, **Locators**, **XPath**, **Wait Strategies**, **UI Elements**, **Web Tables**, **Actions Class**, **Frames & Windows Handling**, **JavaScript Executor**, **Shadow DOM**, **Relative Locators**, **Chrome DevTools Protocol (CDP)**, **Cucumber BDD**, **Data-Driven Testing with Apache POI**, **AutoIT Integration**, **Exception Handling**, and other advanced Selenium concepts.

Each module includes practical examples that demonstrate real-world automation techniques while following a structured, modular, and progressive learning approach.

---

# ✨ Repository Highlights

- ✅ Selenium WebDriver Fundamentals
- ✅ Browser Automation
- ✅ Selenium Locators & XPath
- ✅ Wait Strategies
- ✅ UI Elements Automation
- ✅ SVG Elements
- ✅ Web Tables
- ✅ Actions Class
- ✅ Frames & Multiple Windows
- ✅ Java Streams
- ✅ JavaScript Executor
- ✅ Shadow DOM
- ✅ Relative Locators
- ✅ Screenshot Capture
- ✅ JSON File Update
- ✅ Exception Handling
- ✅ Data-Driven Testing with Apache POI
- ✅ AutoIT File Upload
- ✅ Chrome DevTools Protocol (CDP)
- ✅ Cucumber BDD
- ✅ Allure Reporting

---

# 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| **Java 11+** | Programming Language |
| **Selenium WebDriver** | Browser Automation |
| **Maven** | Dependency & Build Management |
| **TestNG** | Test Framework |
| **Apache POI** | Excel Data-Driven Testing |
| **Chrome DevTools Protocol (CDP)** | Browser Network & Performance Testing |
| **Cucumber** | Behavior-Driven Development (BDD) |
| **AutoIT** | Native Windows File Upload |
| **Allure Reports** | Test Reporting |
| **IntelliJ IDEA** | Development IDE |

---

# 🏗️ Project Structure

```text
Selenium_Learning/
│
├── .allure/                                                                 # Allure configuration
├── .idea/                                                                   # IntelliJ project files
├── .mvn/                                                                    # Maven wrapper files
├── allure-report/                                                           # Generated Allure report
├── allure-results/                                                          # Allure execution results
├── screenshots/                                                             # Execution screenshots
│
├── pom.xml                                                                  # Maven dependencies & build configuration
├── .gitignore
│
├── src/
│   ├── main/
│   │   └── java/com.avinashsinha/
│   │
│   ├── test/
│   │   └── java/com.avinashsinha/
│   │
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
│   │       │   ├── SL03_Test_Selenium_Mini_Project_3.java
│   │       │   └── SL04_Test_Selenium_Mini_Project_4.java
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
│   │       ├── SN05_Selenium_UI_Elements/
│   │       │   ├── SUI01_Test_Selenium_InputBox.java
│   │       │   ├── SUI02_Test_Selenium_CheckBox.java
│   │       │   ├── SUI03_Test_Selenium_RadioButton.java
│   │       │   ├── SUI04_Test_Selenium_StaticSelect.java
│   │       │   ├── SUI05_Test_Selenium_JavaScriptAlert.java
│   │       │   ├── SUI06_Test_Selenium_JavaScriptConfirm.java
│   │       │   ├── SUI07_Test_Selenium_JavaScriptPrompt.java
│   │       │   ├── SUI08_Test_Selenium_CalendarHandle.java
│   │       │   ├── SUI09_Test_Selenium_BrokenLinks.java
│   │       │   └── SUI10_Test_Selenium_Height_Width_WebElement.java
│   │       │
│   │       ├── SN06_Selenium_WaitHelper/
│   │       │   └── SWH01_Test_Selenium_WaitHelper.java
│   │       │
│   │       ├── SN07_Selenium_SVG_Elements/
│   │       │   ├── SSVGE01_Test_Selenium.java
│   │       │   └── SSVGE02_Test_Selenium.java
│   │       │
│   │       ├── SN08_Selenium_Mini_Project/
│   │       │   ├── SMP01_Test_Selenium.java
│   │       │   ├── SMP02_Test_Selenium.java
│   │       │   └── SMP03_Test_Selenium.java
│   │       │
│   │       ├── SN09_Selenium_WebTables/
│   │       │   ├── SWT01_Test_Selenium_StaticWebTable.java
│   │       │   ├── SWT02_Test_Selenium_DynamicWebTable.java
│   │       │   ├── SWT03_Test_Selenium_IPLAutomation.java
│   │       │   └── Team.java
│   │       │
│   │       ├── SN10_Selenium_ActionClass/
│   │       │   ├── SAC01_Test_Selenium.java
│   │       │   ├── SAC02_Test_Selenium.java
│   │       │   ├── SAC03_Test_Selenium.java
│   │       │   ├── SAC04_Test_Selenium.java
│   │       │   └── SAC05_Test_Selenium.java
│   │       │
│   │       ├── SN11_Selenium_FramesHandle/
│   │       │   └── SFH01_Test_Selenium.java
│   │       │
│   │       ├── SN12_Selenium_JavaStream/
│   │       │   ├── SJS01_Test_Selenium.java
│   │       │   ├── SJS02_Test_Selenium.java
│   │       │   └── SJS03_Test_Selenium.java
│   │       │
│   │       ├── SN13_Selenium_FileUpload/
│   │       │   ├── download.xlsx
│   │       │   ├── FileUpload.txt
│   │       │   ├── SFU01_Test_Selenium.java
│   │       │   └── SFU02_Test_Selenium.java
│   │       │
│   │       ├── SN14_Selenium_Windows/
│   │       │   ├── SWD01_Test_Selenium.java
│   │       │   ├── SWD02_Test_Selenium.java
│   │       │   ├── SWD03_Test_Selenium.java
│   │       │   └── SWD04_Test_Selenium.java
│   │       │
│   │       ├── SN15_Selenium_JS_Executor/
│   │       │   ├── SJSE01_Test_Selenium.java
│   │       │   └── SJSE02_Test_Selenium.java
│   │       │
│   │       ├── SN16_Selenium_JS_Executor_ShadowDOM/
│   │       │   ├── SDOM01_Test_Selenium.java
│   │       │   └── SDOM02_Test_Selenium.java
│   │       │
│   │       ├── SN17_Selenium_Relative_Locators/
│   │       │   ├── SRL01_Test_Selenium.java
│   │       │   ├── SRL02_Test_Selenium.java
│   │       │   └── SRL03_Test_Selenium.java
│   │       │
│   │       ├── SN18_Selenium_Screenshots/
│   │       │   ├── SS01_Test_Selenium_Screenshots.java
│   │       │   └── SS02_Test_Selenium_PartialScreenshot.java
│   │       │
│   │       ├── SN19_Selenium_Update_JSON/
│   │       │   └── SUJ01_Test_Selenium_JSON_Update.java
│   │       │
│   │       ├── SN20_Selenium_Exceptions/
│   │       │   ├── SE01_Test_Selenium_NoSuchElement.java
│   │       │   ├── SE02_Test_Selenium_StaleElement.java
│   │       │   ├── SE02_Test_Selenium_StaleElement_FIX.java
│   │       │   └── SE03_Test_Selenium_TimeOut.java
│   │       │
│   │       ├── SN21_Selenium_DataDrivenTestingPOI/
│   │       │   ├── SDDT01_Test_Selenium.java
│   │       │   ├── SDDT02_Test_Selenium.java
│   │       │   └── UtilExcel.java
│   │       │
│   │       ├── SN22_Selenium_MiscellaneousTopics/
│   │       │   ├── SMT01_Test_Selenium_HandleHTTPSCertificate.java
│   │       │   ├── SMT02_Test_Selenium_NetworkInterception.java
│   │       │   ├── SMT03_Test_Selenium_HandleWindowPopUp.java
│   │       │   ├── SMT04_Test_Selenium_UploadFileAutoIt.java
│   │       │   ├── SMT05_Test_Selenium_DownloadFile.java
│   │       │   └── SMT06_Test_Selenium_DownloadDeleteFile.java
│   │       │
│   │       ├── SN23_Selenium_CDP/
│   │       │   ├── SCDP01_Test_Selenium.java
│   │       │   ├── SCDP02_Test_Selenium.java
│   │       │   ├── SCDP03_Test_Selenium.java
│   │       │   ├── SCDP04_Test_Selenium.java
│   │       │   ├── SCDP05_Test_Selenium.java
│   │       │   ├── SCDP06_Test_Selenium.java
│   │       │   ├── SCDP07_Test_Selenium.java
│   │       │   ├── SCDP08_Test_Selenium.java
│   │       │   ├── SCDP09_Test_Selenium.java
│   │       │   └── SCDP10_Test_Selenium.java
│   │       │
│   │       └── SN24_Cucumber/
│   │           ├── feature/
│   │           │   └── Ecommerce.feature
│   │           ├── hooks/
│   │           │   └── Hooks.java
│   │           ├── runner/
│   │           │   └── TestRunner.java
│   │           └── stepDefinitions/
│   │               └── Ecommerce.java
│   │
│   └── resources/
│
├── testNG-xmls/                                                             # TestNG Suite Files
│   ├── testng_SB*.xml
│   ├── testng_SL*.xml
│   ├── testng_SXP*.xml
│   ├── testng_SW*.xml
│   ├── testng_SUI*.xml
│   ├── testng_SWH*.xml
│   ├── testng_SSVGE*.xml
│   ├── testng_SMP*.xml
│   ├── testng_SWT*.xml
│   ├── testng_SAC*.xml
│   ├── testng_SFH*.xml
│   ├── testng_SJS*.xml
│   ├── testng_SFU*.xml
│   ├── testng_SWD*.xml
│   ├── testng_SJSE*.xml
│   ├── testng_SDOM*.xml
│   ├── testng_SRL*.xml
│   ├── testng_SS*.xml
│   ├── testng_SUJ*.xml
│   ├── testng_SE*.xml
│   ├── testng_SDDT*.xml
│   ├── testng_SMT*.xml
│   ├── testng_SCDP*.xml
│   └── testng_UtilExcel.xml
│
├── fileupload.au3                                                           # AutoIT script
├── fileupload.exe                                                           # AutoIT executable
├── PDF.pdf                                                                  # Sample PDF
│
└── README.md
```

---

# 📚 Learning Modules

| Module | Description |
|---------|-------------|
| **SN01** | Selenium Basics |
| **SN02** | Selenium Locators |
| **SN03** | XPath |
| **SN04** | Wait Strategies |
| **SN05** | UI Elements Automation |
| **SN06** | Wait Helper Utilities |
| **SN07** | SVG Elements |
| **SN08** | Selenium Mini Projects |
| **SN09** | Web Tables |
| **SN10** | Actions Class |
| **SN11** | Frames Handling |
| **SN12** | Java Streams |
| **SN13** | File Upload & Download |
| **SN14** | Multiple Windows Handling |
| **SN15** | JavaScript Executor |
| **SN16** | Shadow DOM |
| **SN17** | Relative Locators |
| **SN18** | Screenshot Capture |
| **SN19** | JSON File Manipulation |
| **SN20** | Exception Handling |
| **SN21** | Data-Driven Testing using Apache POI |
| **SN22** | Miscellaneous Selenium Topics |
| **SN23** | Chrome DevTools Protocol (CDP) |
| **SN24** | Cucumber BDD |

---

# ▶️ Running Tests

Execute any TestNG suite using Maven.

### Example

```bash
mvn clean test -DsuiteXmlFile=testNG-xmls/testng_SB01_Test_Selenium.xml
```

### Available Test Suites

| Category | Example XML |
|----------|-------------|
| Selenium Basics | `testng_SB01_Test_Selenium.xml` |
| Selenium Locators | `testng_SL01_Test_Selenium.xml` |
| XPath | `testng_SXP01_Test_Selenium.xml` |
| Wait Strategies | `testng_SW01_Test_Selenium.xml` |
| UI Elements | `testng_SUI01_Test_Selenium.xml` |
| Wait Helper | `testng_SWH01_Test_Selenium.xml` |
| SVG Elements | `testng_SSVGE01_Test_Selenium.xml` |
| Mini Project | `testng_SMP01_Test_Selenium.xml` |
| Web Tables | `testng_SWT01_Test_Selenium.xml` |
| Actions Class | `testng_SAC01_Test_Selenium.xml` |
| Frames | `testng_SFH01_Test_Selenium.xml` |
| Java Streams | `testng_SJS01_Test_Selenium.xml` |
| File Upload | `testng_SFU01_Test_Selenium.xml` |
| Windows | `testng_SWD01_Test_Selenium.xml` |
| JavaScript Executor | `testng_SJSE01_Test_Selenium.xml` |
| Shadow DOM | `testng_SDOM01_Test_Selenium.xml` |
| Relative Locators | `testng_SRL01_Test_Selenium.xml` |
| Screenshots | `testng_SS01_Test_Selenium.xml` |
| JSON Update | `testng_SUJ01_Test_Selenium.xml` |
| Exception Handling | `testng_SE01_Test_Selenium.xml` |
| Data-Driven Testing | `testng_SDDT01_Test_Selenium.xml` |
| Miscellaneous Topics | `testng_SMT01_Test_Selenium.xml` |
| Chrome DevTools Protocol | `testng_SCDP01_Test_Selenium.xml` |

---

# 📊 Allure Reports

Generate the Allure report after executing the test suite:

```bash
allure serve allure-results
```

The command launches an interactive **Allure dashboard** displaying execution statistics, test results, logs, screenshots, and detailed test insights.

---

# ⭐ Repository Highlights

- 🚀 24 Structured Selenium Learning Modules
- 💻 90+ Practical Selenium Automation Programs
- 🌐 Browser Automation using Selenium WebDriver
- 🎯 Advanced Locators & XPath Strategies
- ⏱️ Synchronization with Wait Strategies
- 🖱️ UI Elements, Web Tables & Actions Class
- 🪟 Frames & Multiple Windows Handling
- ⚡ JavaScript Executor & Shadow DOM Automation
- 📍 Relative Locators
- 📸 Screenshot Capture
- 📄 JSON File Manipulation
- ⚠️ Selenium Exception Handling
- 📊 Data-Driven Testing with Apache POI
- 📁 AutoIT File Upload Automation
- 🌍 Chrome DevTools Protocol (CDP)
- 🥒 Cucumber BDD Integration
- 📈 Interactive Allure Reporting

---

# 👨‍💻 Author

**Avinash Sinha**

If you found this repository useful, consider giving it a ⭐.

---

# 📄 License

This repository is intended for **educational**, **learning**, and **practice purposes**.
