# Selenium Automation Sprint 2026

This repository contains a collection of Selenium WebDriver automation scripts developed as part of a transition toward a Senior SDET role.

## 🛠 Tech Stack
- Java 17
- Maven
- Selenium WebDriver 4.25.0
- TestNG 7.10.2
- JUnit 4.11 (present but not primary test framework)
- Apache POI 5.2.5 (Excel data handling)
- commons-io 2.15.1
- IDE: VS Code

## 📁 Project Structure
- `src/main/java/com/genos/sdet` (core / example app entry)
- `src/test/java/com/genos/sdet` (test scripts)
  - `LoginPage`, `LoginAndPrintDetails`, `SelectDropDownExample`, `CheckBoxExample`, `RadioButtonExample`, `AlertsExample`, `FramesExample`, `WindowsExample`, `ExplicitWaitExample`, `BrokenLinks`, `Screenshots`, `ReadDataFromExcel`, etc.
- `TestData` (input/expected data files)
- `src/test/resources` (test resources; e.g. `TestData.xlsx` optional)
- `testng.xml` (TestNG suite configuration)

## ✅ What is implemented
- Browser automation examples using ChromeDriver
- Dropdown handling via `Select`
- Radio and Checkbox validation (`isSelected`)
- Explicit waits and synchronization (`WebDriverWait`, `ExpectedConditions`)
- Alert handling
- Frame and window switching
- Broken link detection in page anchor tags
- Screenshots capture
- Excel data read/write via Apache POI (`ReadDataFromExcel`, `WriteDataInToExcel`, `WriteDynamicDataInExcel`)

## 🧪 Quick start (run tests)
1. Update ChromeDriver path (if needed):
   - either in OS `PATH`
   - or in code via `System.setProperty("webdriver.chrome.driver", "<path>\chromedriver.exe")`
2. Build:
   - `mvn clean test-compile`
3. Run all tests:
   - `mvn test` or `mvn -Dtestng.xml test`
4. Run a specific TestNG class:
   - `mvn -Dtest=LoginPage test`

## 📌 Excel / data-driven section
- Base file: `resources/testdata.xlsx` (can have multiple sheets)
- `ReadDataFromExcel` reads all rows + columns from a specified sheet and prints values in console.
- `WriteDataInToExcel` writes static data (e.g., cricket player roles) to `Sheet2`.
- `WriteDynamicDataInExcel` allows user input for dynamic rows/columns in `Sheet3`.
- **Key feature**: Write classes preserve existing sheets (e.g., if `Sheet1`, `Sheet2`, `Sheet4` exist, running write adds new sheet without overwriting others).
- If missing, create file manually:
  - headers: `Username`, `Password`
  - sample rows: `testuser1,password123`, `testuser2,password456`, `admin,adminpass`

## ⚙️ Dependency issue note (resolved)
- Updated `pom.xml` to force `commons-io:2.15.1` so that Apache POI 5.2.5 `UnsynchronizedByteArrayOutputStream.Builder` is present.

- [x] POM-based project setup
- [ ] Page Object Model (POM) implementation
- [ ] Parallel execution with TestNG
- [ ] API automation using Rest Assured

## 📝 Useful commands
- `mvn dependency:tree`
- `mvn clean compile`
- `mvn clean test-compile`
- `mvn test`
- (Future) `mvn clean site` if reporting is added
